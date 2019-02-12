package com.infoshareacademy.tailandczycy.mappers;

import com.infoshareacademy.tailandczycy.dto.CategoryDto;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.model.Expense;

import javax.faces.bean.RequestScoped;
import java.util.stream.Collectors;

@RequestScoped
public class CategoryDtoMapper {

    public CategoryDto getCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setTotal(category.getTotal());
        categoryDto.setLimit(category.getLimit());
        categoryDto.setExpenses(category.getExpenses().stream().map(Expense::getName).collect(Collectors.toList()));

        return categoryDto;
    }
}
