package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;

import com.infoshareacademy.tailandczycy.model.Expense;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class ExpenseBean {
    @Inject
    private ExpenseDao expenseDao;
    @Inject
    private CategoryDao categoryDao;

    public ExpenseDto getExpenseDto(HttpServletRequest req) {
        ExpenseDto expenseDto = new ExpenseDto();
        List<String> categoriesString = new ArrayList<>(Arrays.asList(req.getParameterValues("categories")));

        expenseDto.setName(req.getParameter("name"));
        expenseDto.setComment(req.getParameter("comment"));
        expenseDto.setAmount(parseStringToBigDecimal(req.getParameter("amount")));
        expenseDto.setDate(parseStringToLocalDate(req.getParameter("date")));
        expenseDto.setCategories(categoriesString);

        return expenseDto;
    }

    public Optional<ExpenseDto> getExpenseById(Long id) {

        Optional<Expense> expenseById = expenseDao.findById(id);

        if (expenseById.isPresent()) {
            ExpenseDto expenseDto = new ExpenseDto();

            expenseDto.setId(expenseById.get().getId());
            expenseDto.setAmount(expenseById.get().getAmount());
            expenseDto.setComment(expenseById.get().getComment());
            expenseDto.setDate(expenseById.get().getDate());

            return Optional.of(expenseDto);
        }
        return Optional.empty();
    }

    public void saveExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setAmount(expenseDto.getAmount());
        expense.setComment(expense.getComment());
        expense.setDate(expenseDto.getDate());
        expense.setCategories(categoryDao.findCategoriesByNames(expenseDto.getCategories()));
        expenseDao.save(expense);
    }

    private LocalDate parseStringToLocalDate(String date) {
        return LocalDate.parse(date);
    }

    private BigDecimal parseStringToBigDecimal(String param) {
        return new BigDecimal(param).setScale(2, RoundingMode.HALF_UP);
    }
}
