package com.acc.regresiontest.com.api.bussineslogic;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.User;

@Path("login")
public class LoginService {
	
 public LoginService(@Context ServletContext context) {
 }
		 
	 @POST    
	    public Response login(@Context ServletContext context, @FormParam("user") String user,
	    													 @FormParam("pass") String pass)	
	{
		 
		 
		 ModelError modelError = new ModelError();
		 
		   //Check user input
		 if(user == null || user.equals("")){
	           modelError.addModelError("user", "atributo obligtorio");
	        }
		 
		 if(pass == null || pass.equals("")){
	           modelError.addModelError("pass", "atributo obligtorio");
	        }
		 
		 if(modelError.hasErrors()){
	            return Response
	                    .status(Response.Status.BAD_REQUEST)
	                    .entity(modelError)
	                    .build();
	        }
		 
		 
		 try{
			 
			 MongoDao Mdao = new MongoDao();

				// buscamos en la base de mongodb
				User usuario = Mdao.findUser(user);
				if(usuario == null){
					if(modelError.hasErrors()){
			            return Response
			                    .status(Response.Status.BAD_REQUEST)
			                    .entity(modelError)
			                    .build();
					}
				else if(user.equals(usuario.getUser()) && pass.equals(usuario.getPass())){
					// si coincide usuario y password y además no hay sesión iniciada

			           
					}
				}
					
			
				}catch (DAOException e) {

					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(modelError).build();
				}

		 return Response
                 .status(Response.Status.ACCEPTED)
                 .entity("1")
                 .build();
		 
	 }

}
