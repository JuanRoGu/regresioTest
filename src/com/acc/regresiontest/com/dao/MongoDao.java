package com.acc.regresiontest.com.dao;

import com.acc.regresiontest.com.Exception.MongoDBException;
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
	
	

}
