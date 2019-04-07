package com.infoshareacademy.tailandczycy.validations;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExpenseValidatorTest {

    @Mock
    HttpServletRequest request;

    @Mock
    CategoryDao categoryDao;

    @InjectMocks
    ExpenseValidator expenseValidator = new ExpenseValidator();

    @Test
    void shouldReturnTrueWhenAllFieldsCorrect() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("name");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertTrue(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenNameIsLongerThan15Chars() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("1234567890123456");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenNameIsEmptyString() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenNameIsNull() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenAmountIsNull() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("name");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn(null);
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenAmountIsNotNumeric() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("name");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("haha");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenAmountExceedsCategoryLimit() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(300));
        category.setTotal(new BigDecimal(150));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("name");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenAmountDateIsIncorrect() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("name");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("03-03-2017");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenCategoriesAreEmpty() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {};
        List<String> categoryStringList = new ArrayList<>(Arrays.asList(categoryStringArray));
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("name");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }

    @Test
    void shouldReturnFalseWhenCategoriesAreNotFound() {
        //given
        Category category = new Category();
        category.setLimit(new BigDecimal(500));
        category.setTotal(new BigDecimal(100));
        String[] categoryStringArray = {"string"};
        List<String> categoryStringList = new ArrayList<>();
        List<Category> categories = new ArrayList<>(Collections.singletonList(category));
        //when
        lenient().when(request.getParameter("name")).thenReturn("name");
        lenient().when(request.getParameter("comment")).thenReturn("comment");
        lenient().when(request.getParameterValues("categories")).thenReturn(categoryStringArray);
        lenient().when(request.getParameter("amount")).thenReturn("200");
        lenient().when(request.getParameter("date")).thenReturn("2017-03-03");
        lenient().when(categoryDao.findCategoriesByNames(categoryStringList)).thenReturn(categories).thenReturn(categories);
        //then
        assertFalse(expenseValidator.areFieldsCorrect(request));
    }
}