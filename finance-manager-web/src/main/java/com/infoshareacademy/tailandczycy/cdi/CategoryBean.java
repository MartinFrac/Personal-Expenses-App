package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.mappers.CategoryDtoMapper;
import com.infoshareacademy.tailandczycy.model.Category;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestScoped
public class CategoryBean {

    @Inject
    CategoryDao categoryDao;

    @Inject
    CategoryDtoMapper categoryDtoMapper;

    public Optional<CategoryDto> getCategoryDtoById(Long id) {
        Optional<Category> categoryById = categoryDao.findById(id);

        return categoryById.map(category -> categoryDtoMapper.getCategoryDto(category));
    }

    public List<CategoryDto> getAllCategoryDtos() {
        return categoryDao.findAll().stream()
                .map(c -> categoryDtoMapper.getCategoryDto(c))
                .collect(Collectors.toList());
    }

    public void saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setLimit(categoryDto.getLimit());
        categoryDao.save(category);
    }
}
