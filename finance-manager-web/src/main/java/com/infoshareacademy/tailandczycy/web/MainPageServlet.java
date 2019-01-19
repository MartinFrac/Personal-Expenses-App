package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/home")
public class MainPageServlet extends HttpServlet {
    private static final String TEMPLATE_NAME = "welcome";

    @Inject
    private TemplateBean templateBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Map<String, Object> dataModel = new HashMap<>();
        List<Integer> expenses = new ArrayList<>();
        dataModel.put("expenses", expenses);
        templateBean.handleTemplate(dataModel, TEMPLATE_NAME, resp, getServletContext());
    }
}

