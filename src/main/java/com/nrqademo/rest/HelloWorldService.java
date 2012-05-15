/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nrqademo.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author qa
 */
@Path("/hello")
public class HelloWorldService {
    
    @GET
    @Path("/hello/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say: " + msg;
        return Response.status(200).entity(output).build();
    }
    
}
