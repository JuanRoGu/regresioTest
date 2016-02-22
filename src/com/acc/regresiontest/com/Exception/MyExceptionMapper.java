package com.acc.regresiontest.com.Exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class MyExceptionMapper implements ExceptionMapper<Exception>{

    @Override
    public Response toResponse(Exception exception) {
        String message = exception.getMessage();
        String tipo = exception.getClass().toString();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new JAXException(tipo + ": " +message))
                .build();
                
//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
