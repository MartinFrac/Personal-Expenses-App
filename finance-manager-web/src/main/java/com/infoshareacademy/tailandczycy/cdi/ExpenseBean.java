package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.mappers.ExpenseDtoMapper;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ExpenseBean {

    @Inject
    private ExpenseDao expenseDao;
    @Inject
    private CategoryDao categoryDao;
    @Inject
    private ExpenseDtoMapper expenseDtoMapper;

    public List<ExpenseDto> getAllExpenseDtos() {
        return expenseDao.findAll().stream()
                .map(e -> expenseDtoMapper.mapToDto(e))
                .collect(Collectors.toList());
    }

    public void saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        String name = expenseDto.getName();
        BigDecimal amount = expenseDto.getAmount();
        String comment = expenseDto.getComment();
        LocalDate date = parseStringToLocalDate(expenseDto.getDate());
        List<Category> categories = categoryDao.findCategoriesByNames(expenseDto.getCategories());

        expense.setName(name);
        expense.setAmount(amount);
        expense.setComment(comment);
        expense.setDate(date);
        expense.setCategories(categories);

        expenseDao.save(expense);

        categories.forEach(category -> {
            category.setTotal(category.getTotal().add(amount));
            categoryDao.update(category);
        });
    }

    private LocalDate parseStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
        return LocalDate.parse(date, formatter);
    }
}
