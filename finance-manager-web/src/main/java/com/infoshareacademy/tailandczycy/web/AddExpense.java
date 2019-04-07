package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.statics.Templates;
import com.infoshareacademy.tailandczycy.validations.ExpenseValidator;
import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.HashMap;

@WebServlet(urlPatterns = "/add-expense")
public class AddExpense extends HttpServlet {

    @Inject
    ExpenseValidator expenseValidator;

    @Inject
    TemplateBean templateBean;

    @Inject
    ExpenseBean expenseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> dataModel = new HashMap<>();
        templateBean.handleTemplate(dataModel, Templates.ADD_EXPENSE, resp, getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> dataModel = new HashMap<>();
        if(expenseValidator.areFieldsCorrect(req)) {
            ExpenseDto expenseDto = new ExpenseDto();
            expenseDto.setName(req.getParameter("name"));
            expenseDto.setComment(req.getParameter("comment"));
            expenseDto.setAmount(new BigDecimal(req.getParameter("amount")).setScale(2, RoundingMode.HALF_UP));
            expenseDto.setDate(req.getParameter("date"));
            expenseDto.setCategories(Arrays.asList(req.getParameterValues("categories")));
            expenseBean.saveExpense(expenseDto);
            dataModel.put("state", "added");
            templateBean.handleTemplate(dataModel, Templates.HOME, resp, getServletContext());
        } else {
            dataModel.put("state", "error");
            templateBean.handleTemplate(dataModel, Templates.HOME, resp, getServletContext());
        }
    }
}

