package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.mappers.ExpenseDtoMapper;
import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class ExpenseBean {
    @Inject
    private ExpenseDao expenseDao;
    @Inject
    private CategoryDao categoryDao;
    @Inject
    ExpenseDtoMapper expenseDtoMapper;

    public List<ExpenseDto> getAllExpenseDtos() {
        return expenseDao.findAll().stream()
                .map(e -> expenseDtoMapper.mapToDto(e))
                .collect(Collectors.toList());
    }

    public void saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setAmount(expenseDto.getAmount());
        expense.setComment(expense.getComment());
        expense.setDate(parseStringToLocalDate(expenseDto.getDate()));
        expense.setCategories(categoryDao.findCategoriesByNames(expenseDto.getCategories()));
        expenseDao.save(expense);
    }

    private LocalDate parseStringToLocalDate(String date) {
        return LocalDate.parse(date);
    }
}
