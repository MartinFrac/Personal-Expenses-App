package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.validations.Validator;
import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(urlPatterns = "/add-expense")
public class AddExpense extends HttpServlet {

    private static final String TEMPLATE_ADD = "transactions/newTransaction";

    @Inject
    Validator validator;

    @Inject
    TemplateBean templateBean;

    @Inject
    ExpenseBean expenseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        HashMap<String, Object> dataModel = new HashMap<>();
        templateBean.handleTemplate(dataModel, TEMPLATE_ADD, resp, getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> dataModel = new HashMap<>();
        if(validator.isExpenseCorrect(req)) {
            ExpenseDto expenseDto = expenseBean.getExpenseDto(req);
            expenseBean.saveExpense(expenseDto);
            dataModel.put("state", "added");
            templateBean.handleTemplate(dataModel, TEMPLATE_ADD, resp, getServletContext());
        } else {
            dataModel.put("state", "error");
            templateBean.handleTemplate(dataModel, TEMPLATE_ADD, resp, getServletContext());
        }
    }
}

