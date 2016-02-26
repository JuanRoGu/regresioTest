package com.acc.regresiontest.com.api.bussineslogic;

import javax.servlet.ServletContext;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.domains.User;
import com.acc.regresiontest.com.domains.UserAjax;
import com.google.gson.Gson;

@Path("login")

public class LoginService {

	public LoginService(@Context ServletContext context) {
	}

	//Busco el usuario en mongodb
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUserMongo(String string) {
        
        String user ;
        String datos1 ="";
        Gson gson = new Gson();
        
        UserAjax userajax = gson.fromJson(string, UserAjax.class);
        System.out.println("El usuario es: "+userajax.getUser());
        
        user = userajax.getUser();
        User u = new User();

        ModelError modelError = new ModelError();
        if(user == null || user.equals("")){
              modelError.addModelError("user", "atributo obligtorio");
           }
       
        if(modelError.hasErrors()){
               return Response
                       .status(Response.Status.BAD_REQUEST)
                       .entity(modelError)
                       .build();
           }
        
        try{
            //Realizo la conexion
           
               MongoDao mongo = new MongoDao();
               u = mongo.findUser(user);
               datos1 = gson.toJson(u);
                System.out.println(datos1);
            
        }catch(DAOException e){
            return Response
                       .status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity(modelError)
                       .build();
        }
        
        return Response
                //Devuelvo usuario,password,profile
                   .status(Response.Status.OK)
                   .entity(datos1)
                   .build();
    }



}
