package com.infoshareacademy.tailandczycy.mappers;

import static org.junit.jupiter.api.Assertions.*;

import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ExpenseDtoMapperTest {

    private ExpenseDtoMapper expenseDtoMapper = new ExpenseDtoMapper();

    @Test
    void shouldReturnTrueWhenCorrectPath() {

        //given
        Long id = 1L;
        String name = "name";
        String comment = "comment";
        BigDecimal amount = new BigDecimal(200);
        LocalDate date = LocalDate.of(2018,3,3);
        List<Category> categories = new ArrayList<>();

        Expense expense = new Expense(id);
        expense.setName(name);
        expense.setComment(comment);
        expense.setAmount(amount);
        expense.setDate(date);
        expense.setCategories(categories);

        List<String> strings = new ArrayList<>();

        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(id);
        expenseDto.setName(name);
        expenseDto.setComment(comment);
        expenseDto.setDate(date.toString());
        expenseDto.setAmount(amount);
        expenseDto.setCategories(strings);

        //when
        ExpenseDto testObj = expenseDtoMapper.mapToDto(expense);

        //then
        assertEquals(expenseDto, testObj);
    }
}