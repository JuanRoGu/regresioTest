package com.acc.regresiontest.com.api.bussineslogic;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.dao.OracleDao;
import com.acc.regresiontest.com.domains.CasosDePrueba;
import com.acc.regresiontest.com.domains.FiltroExecution;
import com.acc.regresiontest.com.domains.Instrumento;
import com.acc.regresiontest.com.domains.OperacionesMongo;
import com.acc.regresiontest.com.domains.OperacionesOracle;
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
	 
	//Edita un caso de prueba en mongodb
	 @PUT
	 @Path("{id}")
	 public Response editarCaso(@Context ServletContext context, @PathParam("id") int id){
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
			
			 //Convierto la clase en json para facilitar el insert
			 
			 datos1 = gson.toJson(instrumento);
			
			 
			 
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
				 OracleDao od = new OracleDao();
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

}
