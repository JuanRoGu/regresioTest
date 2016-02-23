package com.acc.regresiontest.com.dao;

import java.util.List;

import com.acc.regresiontest.com.Exception.MongoDBException;
import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.Instrumento;
import com.acc.regresiontest.com.domains.User;
import com.acc.regresiontest.com.interfaces.IMongoDao;
import com.acc.regresiontest.com.utils.ConnectionMongoDB;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

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
		 DB database = mongo.getDB("login");
		 
		 //Recuperamos los valores de la colección, previamente hemos introducido 
		 //unos valores desde la consola de mongo con db.things.save({name:"mongoDB"})
		 DBCollection coleccion = database.getCollection("user");
		 
		//Recuperamos el elemento
		 DBObject query = new BasicDBObject("user", user);
		 DBObject documento = coleccion.findOne(query);
		 if(documento != null){
		 usuario.setUser(documento.get("user").toString());
		 usuario.setPass(documento.get("pass").toString());
		 usuario.setPerfil(documento.get("profile").toString());
		 return usuario;
		 }
		 
		return null;
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
	@Override
	public List<String> selectInstrumentos(String sentencia) {
		List<String> lista;
		System.out.println("Entro en el metodo");
		User usuario = new User();
		//Recuperamos la base de datos.
		 DB database = mongo.getDB("login");
		 
		 //Recuperamos los valores de la colección, previamente hemos introducido 
		 //unos valores desde la consola de mongo con db.things.save({name:"mongoDB"})
		 DBCollection coleccion = database.getCollection("FILTERS");
		 List cl1 = coleccion.distinct(sentencia);
		 
		 for(int x=0;x<cl1.size();x++){
			 System.out.println(cl1.get(x));
		 }

		return null;
	}
	

}
