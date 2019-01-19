package com.infoshareacademy.tailandczycy.web;


import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dao.ExpenseDao;
import com.infoshareacademy.tailandczycy.model.Expense;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/delete-expense")
public class DeleteExpense extends HttpServlet {
    private static final String TEMPLATE_NAME = "delete-expense";

    @Inject
    ExpenseDao expenseDao;

    @Inject
    TemplateBean templateBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        HashMap<String, Object> dataModel = new HashMap<>();
        Long id = Long.parseLong(req.getParameter("id"));
        Expense expense = expenseDao.findById(id);
        dataModel.put("expenses", expense);
        expenseDao.delete(id);
        templateBean.handleTemplate(dataModel, TEMPLATE_NAME, resp, getServletContext());
    }
}
