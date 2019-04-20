package com.infoshareacademy.tailandczycy.validations;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import org.apache.commons.lang3.StringUtils;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequestScoped
public class ExpenseValidator implements Validator{

    @Inject
    private CategoryDao categoryDao;

    public boolean areFieldsCorrect(HttpServletRequest request) {

        List<String> categoryList;

        if(request.getParameterValues("categories")==null) {
            return false;
        } else {
            categoryList = new ArrayList<>(Arrays.asList(request.getParameterValues("categories")));
        }

        if (!isNameCorrect(request.getParameter("name"))) {
            return false;
        }
        if (!isCommentCorrect(request.getParameter("comment"))) {
            return false;
        }
        if (!areCategoriesCorrect(categoryList)) {
            return false;
        }
        if (!isAmountCorrect(request.getParameter("amount"), categoryList)) {
            return false;
        }
        if (!isDateCorrect(request.getParameter("date"))) {
            return false;
        }

        return true;
    }

    private boolean isCommentCorrect(String comment) {
        return comment == null || comment.isEmpty() || !StringUtils.isNumeric(comment);
    }

    private boolean isNameCorrect(String name) {
        if (name == null || name.isEmpty() || !isLessThan16Letters(name)) {
            return false;
        }
        return true;
    }

    private boolean isAmountCorrect(String amount, List<String> categoriesString) {
        if(amount == null) return false;
        if (!isBigDecimalCorrect(amount)) return false;
        if (!amountDoesNotExceedCategoryLimit(new BigDecimal(amount), categoriesString)) return false;
        return true;
    }

    private boolean isDateCorrect(String date) {
        if(date==null) return false;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean areCategoriesCorrect(List<String> categoriesString) {
        if (categoriesString.isEmpty()) {
            return false;
        }
        if (categoryDao.findCategoriesByNames(categoriesString).size() != categoriesString.size()) {
            return false;
        }
        return true;
    }

    private boolean isLessThan16Letters(String string) {
        return string.chars().count() < 16;
    }

    private boolean isBigDecimalCorrect(String bigDecimalString) {
        try {
            BigDecimal bigDecimal = new BigDecimal(bigDecimalString);
            if(bigDecimal.signum()>0) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean amountDoesNotExceedCategoryLimit(BigDecimal amount, List<String> categoriesString) {
        List<Category> categories = categoryDao.findCategoriesByNames(categoriesString);
        return categories.stream()
                .anyMatch(category -> category.getTotal().add(amount).compareTo(category.getLimit()) <= 0);
    }
}
