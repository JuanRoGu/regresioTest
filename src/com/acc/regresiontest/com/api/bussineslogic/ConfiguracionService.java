package com.acc.regresiontest.com.api.bussineslogic;
import javax.servlet.ServletContext;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.dao.OracleDao;
import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.Instrumento;






@Path("configuration")
public class ConfiguracionService {
	
	 

	 public ConfiguracionService(@Context ServletContext context) {
		 
		 System.out.println("hola");
		 
	 }
	 
	 
	 @GET
	    public Response ListSelect(){
	        
		 MongoDao md = new MongoDao();
		 Instrumento instrumento = new Instrumento();
		 try{
		 instrumento.setDestinos(md.selectInstrumentos("destino"));
	        
	            
		 }catch(DAOException e){
			 
			 return Response
	                    .status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity(instrumento)
	                    .build();
		 }
		 
		 return Response
	                .status(Response.Status.CREATED)
	                .entity(instrumento)
	                .build();
	 }
	  
	 
	 @POST    
	    public Response newAlta(@Context ServletContext context, @FormParam("requestId") String requestId){
		 
		 ModelError modelError = new ModelError();
		 Datos datos = null;
		 
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
		 
		 
		 try{
			 MongoDao md = new MongoDao();
			 OracleDao od = new OracleDao();
			 datos = od.findByid(requestId);
			 md.addDato(datos);
		 }catch(DAOException e){
			 
			 return Response
	                    .status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity(modelError)
	                    .build();
		 }
		 
		 return Response
	                .status(Response.Status.CREATED)
	                .entity(datos)
	                .build();
		 
	 }
	

}
