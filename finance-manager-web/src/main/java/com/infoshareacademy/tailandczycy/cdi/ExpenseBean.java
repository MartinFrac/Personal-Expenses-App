package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;

import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

@RequestScoped
public class ExpenseBean {
    @Inject
    private ExpenseDao expenseDao;
    @Inject
    private CategoryDao categoryDao;

    public Optional<ExpenseDto> getExpenseById(Long id) {

        Optional<Expense> expenseById = expenseDao.findById(id);

        if (expenseById.isPresent()) {
            ExpenseDto expenseDto = new ExpenseDto();

            expenseDto.setId(expenseById.get().getId());
            expenseDto.setAmount(expenseById.get().getAmount());
            expenseDto.setComment(expenseById.get().getComment());
            expenseDto.setDate(expenseById.get().getDate().toString());

            return Optional.of(expenseDto);
        }
        return Optional.empty();
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
