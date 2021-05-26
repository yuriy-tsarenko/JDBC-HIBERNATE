package com.example.demo.proxy;

import com.example.demo.dto.UserDto;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(value = MediaType.APPLICATION_JSON)
@Consumes(value = MediaType.APPLICATION_JSON)
public interface Proxy {

    @GET
    Response getAll();

    @GET
    @Path("/{id}")
    Response getById(@PathParam(value = "id") Integer id, @HeaderParam(value = "Authorization") String token);

    @POST
    Response create(UserDto userDto, @HeaderParam(value = "Authorization") String token);

    @PUT
    @Path("/{id}")
    Response update(@PathParam(value = "id") Integer id, UserDto userDto, @HeaderParam(value = "Authorization") String token);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam(value = "id") Integer id, @HeaderParam(value = "Authorization") String token);


}
