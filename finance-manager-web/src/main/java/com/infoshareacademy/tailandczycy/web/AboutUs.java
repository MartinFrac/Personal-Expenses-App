package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dao.CategoryDao;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Transactional
@WebServlet(urlPatterns = "/about")
public class AboutUsServlet extends HttpServlet {

    private static final String TEMPLATE_NAME = "static/aboutUs";

    @Inject
    TemplateBean templateBean;

    @Inject
    CategoryDao categoryDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("expenses", categoryDao.findCategoriesEven(new BigDecimal(800)));
        templateBean.handleTemplate(dataModel, TEMPLATE_NAME, resp, getServletContext());
    }
}
