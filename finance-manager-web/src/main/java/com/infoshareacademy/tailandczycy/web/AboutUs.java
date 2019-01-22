package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Transactional
@WebServlet(urlPatterns = "/about")
public class AboutUs extends HttpServlet {

    private static final String TEMPLATE_NAME = "/aboutUs";

    @Inject
    TemplateBean templateBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> dataModel = new HashMap<>();
        templateBean.handleTemplate(dataModel, TEMPLATE_NAME, resp, getServletContext());
    }
}
