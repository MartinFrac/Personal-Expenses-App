package com.infoshareacademy.tailandczycy.web;

import com.infoshareacademy.tailandczycy.cdi.CategoryBean;
import com.infoshareacademy.tailandczycy.cdi.TemplateBean;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;
import com.infoshareacademy.tailandczycy.statics.Templates;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "add-category")
public class AddCategory extends HttpServlet {

    @Inject
    CategoryBean categoryBean;

    @Inject
    TemplateBean templateBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Object> dataModel = new HashMap<>();
        templateBean.handleTemplate(dataModel, Templates.ADD_CATEGORY, resp, getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CategoryDto categoryRequestView = categoryBean.getCategoryDto(req);
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("category", categoryRequestView);
        templateBean.handleTemplate(dataModel, Templates.HOME, resp, getServletContext());
    }
}
