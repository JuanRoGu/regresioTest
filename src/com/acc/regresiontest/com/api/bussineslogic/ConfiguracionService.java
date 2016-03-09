package com.acc.regresiontest.com.api.bussineslogic;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.dao.OracleDao;
import com.acc.regresiontest.com.domains.FiltroExecution;
import com.acc.regresiontest.com.domains.Instrumento;
import com.acc.regresiontest.com.domains.OperacionesOracle;
import com.acc.regresiontest.com.interfaces.IMongoDao;
import com.acc.regresiontest.com.interfaces.IOracleDao;
import com.google.gson.Gson;

@Path("configuration")
public class ConfiguracionService {

	 public ConfiguracionService(@Context ServletContext context) {
		 
	 }
//Elimina un caso de prueba en mongodb
	 @DELETE
	 @Path("{id}")
	 public Response deleteCaso(@Context ServletContext context, @PathParam("id") int id){
		return null;
		 
	 }
	 
	 
	//Recupera de la tabla FILTERS Origen y envia por json
		 @GET
		    public Response ListSelectOrigenJson(){
		     System.out.println("Recoger Origen");
			 MongoDao md = new MongoDao();
			 Instrumento instrumento = new Instrumento();
			 String datos1 = "";
			 Gson gson = new Gson();
			 try{ 
			 instrumento.setOrigenes(md.selectCombo("Origen"));
			 instrumento.setDestinos(md.selectCombo("Destino"));
			 instrumento.setInstrumentos(md.selectCombo("Instrumento"));
			 instrumento.setNombre(md.selectComboConexiones("nombre"));
			 
			 //Convierto la clase en json para facilitar el insert
			 datos1 = gson.toJson(instrumento);
			 System.out.println(datos1);
			 
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
		 
	//Recupero los datos de un oracle mediante un ID
		 @POST
         @Produces(MediaType.APPLICATION_JSON)
         public Response findID(String string){

             
             List<OperacionesOracle> operaciones = new ArrayList<>();
             String datos1 = "";
             Gson gson = new Gson();
             
             FiltroExecution ope = gson.fromJson(string, FiltroExecution.class);
             
             
             ModelError modelError = new ModelError();
             if(modelError.hasErrors()){
                    return Response
                            .status(Response.Status.BAD_REQUEST)
                            .entity(modelError)
                            .build();
                }
             
             try{
                 
                 //Realizo la conexion
                 IOracleDao od = new OracleDao();
                 operaciones = od.findID(
                         ope.getId_Peticion(),
                         ope.getInstrumento(),
                         ope.getOrigen(),
                         ope.getDestino(),
                         ope.getFechaDesde(),
                         ope.getFechaHasta());
                 datos1 = gson.toJson(operaciones);
                 
             }catch(DAOException e){
                 
                 return Response
                            .status(Response.Status.INTERNAL_SERVER_ERROR)
                            .entity(modelError)
                            .build();
             }
             
             return Response
                        .status(Response.Status.OK)
                        .entity(datos1)
                        .build();
         }
		 
		 //Elimina un resultado en mongodb
		    @DELETE
		    @Path("/deleteResult")
		    @Produces(MediaType.APPLICATION_JSON)
		     public Response deleteResultado(String nombreCaso){	
		    	
		         ModelError modelError = new ModelError(); 
		         
		         if(modelError.hasErrors()){
		                return Response
		                        .status(Response.Status.BAD_REQUEST)
		                        .entity(modelError)
		                        .build();
		            }
		         
		         
		         try{
		             IMongoDao md = new MongoDao();
		             md.deleteMongoResult(nombreCaso);
		             
		         }catch(DAOException e){
		             
		             return Response
		                        .status(Response.Status.INTERNAL_SERVER_ERROR)
		                        .entity(modelError)
		                        .build();
		         }
		         
		         return Response
		                    .status(Response.Status.OK)
		                    .entity("ok")
		                    .build();
		         
		     }    
		 
		 
		    
		 
		 
//		  //Crea un caso de prueba en mongodb
		    @POST
		    @Path("/add")
		    @Produces(MediaType.APPLICATION_JSON)
		     public Response altaCaso(String caso){		 
		         ModelError modelError = new ModelError(); 
		         if(modelError.hasErrors()){
		                return Response
		                        .status(Response.Status.BAD_REQUEST)
		                        .entity(modelError)
		                        .build();
		            }
		         
		         
		         try{
		             IMongoDao md = new MongoDao();
		             md.addDatoMongo(caso);
		             
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

}
