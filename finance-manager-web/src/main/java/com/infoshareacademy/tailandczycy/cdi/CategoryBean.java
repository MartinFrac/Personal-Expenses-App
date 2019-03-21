package com.infoshareacademy.tailandczycy.cdi;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.mappers.CategoryDtoMapper;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped
public class CategoryBean {

    @Inject
    CategoryDao categoryDao;

    @Inject
    CategoryDtoMapper categoryDtoMapper;

    public List<CategoryDto> getAllCategoryDtos() {
        return categoryDao.findAll().stream()
                .map(c -> categoryDtoMapper.mapToDto(c))
                .collect(Collectors.toList());
    }
}
