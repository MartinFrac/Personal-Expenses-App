package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.dao.CategoryDao;
import com.infoshareacademy.tailandczycy.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/")
public class CategoryService {

    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Context
    private UriInfo uriInfo;

    @Inject
    CategoryDao categoryDao;

    public CategoryService() {
    }

    @GET
    @Path("/categories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() {

        List<Category> categories = categoryDao.findAll();

        logger.info("Found {} categories", categories.size());

        if(categories.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(categories).build();
    }
}