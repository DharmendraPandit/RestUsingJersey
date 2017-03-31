package com.rest.exception.mapping;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class EmployeeNotFoundMapper implements
        ExceptionMapper<EmployeeNotFoundException> {
    @Override
    public Response toResponse(EmployeeNotFoundException ex) {
        return Response.status(Status.NOT_FOUND).entity(EmployeeNotFoundException.NOT_FOUND_MESSAGE).type(MediaType.TEXT_PLAIN).build();
    }
}