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
import javax.ws.rs.core.Response;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.dao.OracleDao;
import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.CasosDePrueba;
import com.acc.regresiontest.com.domains.Instrumento;
import com.acc.regresiontest.com.domains.Operaciones;
import com.google.gson.Gson;

@Path("configuration")
@Produces("json/application")
public class ConfiguracionService {

	 public ConfiguracionService(@Context ServletContext context) {
		 
	 }
	 
	//Recupero los datos de un oracle mediante un ID
     @POST
     public Response findID(@Context ServletContext context, 
                 @FormParam("request_ID") String request_ID){
         
         System.out.println("Entro en el buscador de oracle");
         Operaciones operacion = null;
         String datos1 = "";
         Gson gson = new Gson();
         
         ModelError modelError = new ModelError();
         if(request_ID == null || request_ID.equals("")){
               modelError.addModelError("request_ID", "atributo obligtorio");
            }
         if(modelError.hasErrors()){
                return Response
                        .status(Response.Status.BAD_REQUEST)
                        .entity(modelError)
                        .build();
            }
         
         try{
             
             //Realizo la conexion
             OracleDao od = new OracleDao();
             operacion = od.findID(request_ID);
             datos1 = gson.toJson(operacion);
             
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
     
     
	 
	 //Microservicios configuracion
	 //Crea un caso de prueba
	@POST
	 public Response altaCaso(@Context ServletContext context, 
			 	@FormParam("nombreCaso") String nombreCaso,
			 	@FormParam("request_ID") String request_ID,
			 	@FormParam("ID") String ID,
			 	@FormParam("Instrumento") String Instrumento,
			 	@FormParam("Accion") String Accion,
			 	@FormParam("Origen") String Origen,
			 	@FormParam("Destino") String Destino,
			 	@FormParam("Mensaje") String Mensaje,
			 	@FormParam("MensMN") String MensMN,
			 	@FormParam("MensDestino") String MensDestino){
		 
		 ModelError modelError = new ModelError();
		 if(nombreCaso == null || nombreCaso.equals("")){
	           modelError.addModelError("nombreCaso", "atributo obligtorio");
	        }else if(request_ID == null || request_ID.equals("")){
	        	modelError.addModelError("request_ID", "atributo obligtorio");
	        }else if(ID == null || ID.equals("")){
	        	modelError.addModelError("ID", "atributo obligtorio");
	        }else if(Instrumento == null || Instrumento.equals("")){
	        	modelError.addModelError("Instrumento", "atributo obligtorio");
	        }else if(Accion == null || Accion.equals("")){
	        	modelError.addModelError("Accion", "atributo obligtorio");
	        }else if(Origen == null || Origen.equals("")){
	        	modelError.addModelError("Origen", "atributo obligtorio");
	        }else if(Destino == null || Destino.equals("")){
	        	modelError.addModelError("Destino", "atributo obligtorio");
	        }else if(Mensaje == null || Mensaje.equals("")){
	        	modelError.addModelError("Mensaje", "atributo obligtorio");
	        }else if(MensMN == null || MensMN.equals("")){
	        	modelError.addModelError("MensMN", "atributo obligtorio");
	        }else if(MensDestino == null || MensDestino.equals("")){
	        	modelError.addModelError("MensDestino", "atributo obligtorio");
	        }
		//Si todo a funcionado
		
		 CasosDePrueba casos = new CasosDePrueba();
		 Operaciones operaciones = new Operaciones();
		 
		//set de las operaciones
		 operaciones.setRequest_ID(request_ID);
		 operaciones.setID(ID);
		 operaciones.setInstrumento(Instrumento);
		 operaciones.setAccion(Accion);
		 operaciones.setOrigen(Origen);
		 operaciones.setDestino(Destino);
		 operaciones.setMensaje(Mensaje);
		 operaciones.setMensMN(MensMN);
		 operaciones.setMensDestino(MensDestino);
		 
		 //set de casos de prueba
		 casos.setNombreCaso(nombreCaso);
		 casos.setOperaciones(operaciones);

		 if(modelError.hasErrors()){
	            return Response
	                    .status(Response.Status.BAD_REQUEST)
	                    .entity(modelError)
	                    .build();
	        }
		 
		 
		 try{
			 MongoDao md = new MongoDao();
			 md.addDatoMongo(casos);
			 
		 }catch(DAOException e){
			 
			 return Response
	                    .status(Response.Status.INTERNAL_SERVER_ERROR)
	                    .entity(modelError)
	                    .build();
		 }
		 
		 return Response
	                .status(Response.Status.CREATED)
	                .entity(casos)
	                .build();
		 
	 } 
	 
	 
	//Elimina un caso de prueba
	 @DELETE
	 @Path("{id}")
	 public Response deleteCaso(@Context ServletContext context, @PathParam("id") int id){
		return null;
		 
	 }
	 
	//Edita un caso de prueba
	 @PUT
	 @Path("{id}")
	 public Response editarCaso(@Context ServletContext context, @PathParam("id") int id){
		return null;
		 
	 }
	 
	 
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
          System.out.println(instrumento.getDestinos());
          //Convierto la clase en json para facilitar el insert
          
          datos1 = gson.toJson(instrumento);
          System.out.println(datos1);
          
          
          }catch(DAOException e){
              
              return Response
                         .status(Response.Status.INTERNAL_SERVER_ERROR)
                         .entity(gson.toJson(instrumento))
                         .build();
          }
          
          return Response
                     .status(Response.Status.OK)
                     .entity(gson.toJson(instrumento))
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
