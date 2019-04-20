package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.ExpenseBean;
import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dto.ExpenseDto;
import com.infoshareacademy.tailandczycy.statics.Templates;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/home")
public class Home extends HttpServlet {

    @Inject
    private TemplateBean templateBean;
    @Inject
    private ExpenseBean expenseBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> dataModel = new HashMap<>();
        List<ExpenseDto> expenses = expenseBean.getAllExpenseDtos();
        dataModel.put("expenses", expenses);
        templateBean.handleTemplate(dataModel, Templates.HOME, resp, getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher;
        if (req.getParameter("edit")!=null) {
            requestDispatcher = req.getRequestDispatcher("/edit-expense");
        } else {
            requestDispatcher = req.getRequestDispatcher("/delete-expense");
        }
        requestDispatcher.forward(req, resp);
    }
}