package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.statics.Templates;

import javax.inject.Inject;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        Map<String, Object> dataModel = new HashMap<>();
        List<Integer> expenses = new ArrayList<>();
        dataModel.put("expenses", expenses);
        templateBean.handleTemplate(dataModel, Templates.HOME, resp, getServletContext());
    }
}

