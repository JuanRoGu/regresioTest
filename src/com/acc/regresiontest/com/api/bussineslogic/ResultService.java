package com.acc.regresiontest.com.api.bussineslogic;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.interfaces.IMongoDao;

@Path("result")
public class ResultService {
	
	public ResultService(@Context ServletContext context) {
		 
	 }	 
	
	
	//Recupero los datos de un oracle mediante un ID
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response guardarResultado(String string){

      System.out.println("entro en el POST guardar resultado");
      
      System.out.println(string);
        ModelError modelError = new ModelError();
        if(modelError.hasErrors()){
               return Response
                       .status(Response.Status.BAD_REQUEST)
                       .entity(modelError)
                       .build();
           }
        
        try{
            
            //Realizo la conexion
          IMongoDao mongo = new MongoDao();
          mongo.saveMongoResult(string);
            
        }catch(DAOException e){
            
            return Response
                       .status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(modelError)
                       .build();
        }
        
        return Response
                   .status(Response.Status.CREATED)
                   .build();
    }
	
	//Recupero el nombre de los resultados
		@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response obtenerResultado(String string){
	      System.out.println("entro en el GET para obtener la lista de resultados");
	      
	      System.out.println(string);
	        ModelError modelError = new ModelError();
	        if(modelError.hasErrors()){
	               return Response
	                       .status(Response.Status.BAD_REQUEST)
	                       .entity(modelError)
	                       .build();
	           }
	        
	        try{
	            
	            //Realizo la conexion
	        
	            
	        }catch(DAOException e){
	            
	            return Response
	                       .status(Response.Status.INTERNAL_SERVER_ERROR)
	                       .entity(modelError)
	                       .build();
	        }
	        
	        return Response
	                   .status(Response.Status.CREATED)
	                   .build();
	    }

}
