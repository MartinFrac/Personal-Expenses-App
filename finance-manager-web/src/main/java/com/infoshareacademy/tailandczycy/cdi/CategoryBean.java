package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class CategoryBean {

    @Inject
    private CategoryDao categoryDao;

    public List<CategoryDto> getCategoryDtos() {

        List<CategoryDto> categoryDtos = new ArrayList<>();

        for(Category category: categoryDao.findAll()) {
            categoryDtos.add(getCategoryDto(category));
        }

        return categoryDtos;
    }

    public CategoryDto getCategoryDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setTotal(category.getTotal());
        categoryDto.setLimit(category.getLimit());

        return categoryDto;
    }

    public CategoryDto getCategoryById(Long id) {
        Category categoryById = categoryDao.findById(id);
        if (categoryById == null) {
            return null;
        }
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setName(categoryById.getName());
        categoryDto.setLimit(categoryById.getLimit());
        return categoryDto;
    }

    public void saveCategory(CategoryDto categoryDto) {
        Category category = categoryDao.findById(categoryDto.getId());
        boolean newCategory = false;
        if (category == null) {
            category = new Category();
            newCategory = true;
        }

        category.setLimit(categoryDto.getLimit());
        category.setName(categoryDto.getName());

        if (newCategory) {
            categoryDao.save(category);
        }
    }
}
