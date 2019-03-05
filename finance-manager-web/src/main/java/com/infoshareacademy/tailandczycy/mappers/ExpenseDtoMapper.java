package com.infoshareacademy.tailandczycy.mappers;

import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;

import javax.faces.bean.RequestScoped;
import java.util.stream.Collectors;

@RequestScoped
public class ExpenseDtoMapper {

    public ExpenseDto getExpenseDto(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(expense.getId());
        expenseDto.setName(expense.getName());
        expenseDto.setComment(expense.getComment());
        expenseDto.setDate(expense.getDate());
        expenseDto.setAmount(expense.getAmount());
        expenseDto.setCategories(expense.getCategories().stream()
                                    .map(Category::getName).collect(Collectors.toList()));

        return expenseDto;
    }
}
