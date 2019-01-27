package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import com.infoshareacademy.tailandczycy.statics.Templates;
import com.infoshareacademy.tailandczycy.validations.Validator;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "edit-expense")
public class EditExpense extends HttpServlet {

    @Inject
    TemplateBean templateBean;

    @Inject
    ExpenseBean expenseBean;

    @Inject
    Validator validator;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ExpenseDto expenseDto = expenseBean.getExpenseById(Long.parseLong(req.getParameter("editId")));
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("expense", expenseDto);
        templateBean.handleTemplate(dataModel, Templates.EDIT_EXPENSE, resp, getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(validator.isExpenseCorrect(req)) {
            ExpenseDto expenseDto = expenseBean.getExpenseDto(req);
            expenseBean.saveExpense(expenseDto);
            Map<String, Object> dataModel = new HashMap<>();
            dataModel.put("edited", expenseDto);
            templateBean.handleTemplate(dataModel, Templates.HOME, resp, getServletContext());
        }
    }
}
