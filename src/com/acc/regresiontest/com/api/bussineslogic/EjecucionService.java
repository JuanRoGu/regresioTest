package com.acc.regresiontest.com.api.bussineslogic;
import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.domains.CasosDePrueba;
import com.acc.regresiontest.com.interfaces.IMongoDao;
import com.google.gson.Gson;

@Path("ejecution")
public class EjecucionService {

	 public EjecucionService(@Context ServletContext context) {
		 
	 }	 
	 
	//Elimina un caso de prueba en mongodb
	 @DELETE
     @Produces(MediaType.APPLICATION_JSON)
     public Response borrarCaso(String caso){

//		 String caso2 ="{"+caso+"}";
//         caso2= caso2.replaceAll("\\\\", "");
//         caso2= caso2.replaceAll("\"\"", "\"");
//         //caso2= caso2.replaceAll("]\"","]");
         
         ModelError modelError = new ModelError(); 
         
         if(modelError.hasErrors()){
                return Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity(modelError)
                        .build();
            }
         
         
         try{
             IMongoDao md = new MongoDao();
             md.deleteDatoMongo(caso);
             
         }catch(DAOException e){
             
             return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(modelError)
                        .build();
         }
         
         return Response
                    .status(Response.Status.CREATED)
                    .entity("ok")
                    .build();
         
     }
	 
	 
	//Recupera de la tabla CASOSDEPRUEBA los nombres de todos los casos de prueba y envia por json
	 @GET
     public Response ListSelectCasoPruebaJson(){
      IMongoDao md = new MongoDao();
      CasosDePrueba casosprueba = new CasosDePrueba();
      String datos1 = "";
      Gson gson = new Gson();
      try{ 
        casosprueba.setCasosPrueba(md.selectComboCasos("nombreCaso"));            
        //Convierto la clase en json para facilitar el insert             
        datos1 = gson.toJson(casosprueba);
        
      }catch(DAOException e){
          
          return Response
                     .status(Response.Status.INTERNAL_SERVER_ERROR)
                     .entity(datos1)
                     .build();
      }
      
      return Response
                 .status(Response.Status.OK)
                 .entity(datos1)
                 .build();
  }


}
