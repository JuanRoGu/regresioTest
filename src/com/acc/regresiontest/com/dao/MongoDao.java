package com.acc.regresiontest.com.dao;

import java.util.List;

import com.acc.regresiontest.com.Exception.MongoDBException;
import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.CasosDePrueba;
import com.acc.regresiontest.com.domains.Instrumento;
import com.acc.regresiontest.com.domains.User;
import com.acc.regresiontest.com.interfaces.IMongoDao;
import com.acc.regresiontest.com.utils.ConnectionMongoDB;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class MongoDao implements IMongoDao{
	MongoClient mongo;
	
	public MongoDao(){
		try{
	 mongo = ConnectionMongoDB.getInstance();
		}catch(MongoDBException m){
			throw new MongoDBException("Error de conexion");
		}
	}
	@Override
	public User findUser(String user) {
		User usuario = new User();
		//Recuperamos la base de datos.
		 DB database = mongo.getDB("REGRESIONTEST");
		 
		 //Recuperamos los valores de la colección, previamente hemos introducido 
		 //unos valores desde la consola de mongo con db.things.save({name:"mongoDB"})
		 DBCollection coleccion = database.getCollection("USER");
		 
		//Recuperamos el elemento
		 DBObject query = new BasicDBObject("User", user);
		 DBObject documento = coleccion.findOne(query);
		 if(documento != null){
		 usuario.setUser(documento.get("User").toString());
		 usuario.setPass(documento.get("Password").toString());
		 usuario.setPerfil(documento.get("Profile").toString());
		 return usuario;
		 }
		 
		return null;
	}
	
	//Metodo para insetar en la base de datos mongo un caso de prueba
	@Override
	public void addDatoMongo(CasosDePrueba datos) {
		
		System.out.println("Llego al insert de la base de datos");
		 System.out.println(datos.toString());
		
		//Recuperamos la base de datos.
		 DB database = mongo.getDB("REGRESIONTEST");
		 DBCollection coleccion = database.getCollection("CASOSDEPRUEBA");
		 
		 //Convierto la clase en json para facilitar el insert
		 Gson gson = new Gson();
		 String datos1 = gson.toJson(datos);
		 //Inserto en la base de datos de mongo el json		 
		 DBObject dbObject = (DBObject)JSON.parse(datos1);
		 coleccion.insert(dbObject);
		
	}
	
	@Override
	public void addDato(Datos datos) {
		
		
		//Recuperamos la base de datos.
		 DB database = mongo.getDB("login");
		 
		 DBCollection coleccion = database.getCollection("CASOSDEPRUEBA");
		 
		 // creamos el elemento Con un BasicDBObject
		 
		 BasicDBObject doc = new BasicDBObject();
		 
		 doc.put("idPeticion", datos.getIdPeticion());
		 doc.put("instrumento",datos.getInstrumento());
		 doc.put("accion",datos.getAccion());
		 doc.put("origen",datos.getOrigen());
		 doc.put("destino",datos.getDestino());
		 doc.put("mensaje",datos.getMensaje());
		 doc.put("mensajeNeutro", datos.getMensajeNeutro());		 
		 
		 coleccion.insert(doc);
		
	}
	//El metodo para seleccionar Origen/Destino/Instrumentos para el combo box
	@Override
	public List<String> selectCombo(String sentencia) {
		System.out.println("Entro en el metodo");
		//Recuperamos la base de datos.
		 DB database = mongo.getDB("REGRESIONTEST");
		 
		 //Recuperamos los datos para los combo box
		 DBCollection coleccion = database.getCollection("FILTERS");
		 @SuppressWarnings("unchecked")
		List<String> cl1 = coleccion.distinct(sentencia);

		return cl1;
	}
	
	
	

}
