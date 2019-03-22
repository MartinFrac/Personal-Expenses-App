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
        expenseDto.setDate(expense.getDate());
        expenseDto.setAmount(expense.getAmount());
        if(expense.getComment()!=null) {
            expenseDto.setComment(expense.getComment());
        }
        if(expense.getCategories().size()>0) {
            expenseDto.setCategories(expense.getCategories().stream()
                    .map(Category::getName)
                    .collect(Collectors.toList()));
        }
        return expenseDto;
    }
}
