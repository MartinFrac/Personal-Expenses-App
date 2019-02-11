package com.infoshareacademy.tailandczycy.service;

import com.infoshareacademy.tailandczycy.cdi.CategoryBean;
import com.infoshareacademy.tailandczycy.dto.CategoryDto;
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
    CategoryBean categoryBean;

    public CategoryService() {
    }

    @GET
    @Path("/categories")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCategories() {

        List<CategoryDto> categories = categoryBean.getCategoryDtos();

        logger.info("Found {} categories", categories.size());

        if(categories.isEmpty()) {
            return Response.noContent().build();
        }
        return Response.ok(categories).build();
    }
}