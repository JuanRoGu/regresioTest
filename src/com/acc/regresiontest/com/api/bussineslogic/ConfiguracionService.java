package com.acc.regresiontest.com.api.bussineslogic;
import javax.servlet.ServletContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;




@Path("configuracion")
public class ConfiguracionService {
	

	 public ConfiguracionService(@Context ServletContext context) {
		 
	 }
	 
	 @POST    
	    public Response newAlta(@Context ServletContext context, @FormParam("requestId") String requestId){
		 
		 ModelError modelError = new ModelError();
		 
		 
		   //Check user input
		 if(requestId == null || requestId.equals("")){
	           modelError.addModelError("requestId", "atributo obligtorio");
	        }
		 
		 if(modelError.hasErrors()){
	            return Response
	                    .status(Response.Status.BAD_REQUEST)
	                    .entity(modelError)
	                    .build();
	        }
		 
		 
		 
		 
		 
		 
		
		 
		 return Response
	                .status(Response.Status.CREATED)
	                .entity(a)
	                .build();
		 
	 }
	

}
