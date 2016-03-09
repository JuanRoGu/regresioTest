package com.acc.regresiontest.com.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.acc.regresiontest.com.Exception.MongoDBException;
import com.acc.regresiontest.com.domains.CasoAdd;
import com.acc.regresiontest.com.domains.CasoDelete;
import com.acc.regresiontest.com.domains.ResultDelete;
import com.acc.regresiontest.com.domains.User;
import com.acc.regresiontest.com.interfaces.IMongoDao;
import com.acc.regresiontest.com.properties.SavePropertiesMongo;
import com.acc.regresiontest.com.utils.ConnectionMongoDB;
import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Filters.*;


public class MongoDao implements IMongoDao{
	MongoClient mongo;
	SavePropertiesMongo p = new SavePropertiesMongo();
	//p = p.obtener();
	
	public MongoDao(){
		try{
	 mongo = ConnectionMongoDB.getInstance();
		}catch(MongoDBException m){
			throw new MongoDBException("Error de conexion");
		}
	}
	
	@Override
	public User findUser(String user) {
		p = p.obtener();
		User usuario = new User();
		//Recuperamos la base de datos.
		MongoDatabase database = mongo.getDatabase(p.getBaseDeDatosM());
		MongoCollection<Document> collection= database.getCollection(p.getTablaUserM());
		 //Recuperamos los valores de la colección usando un filtro
		Document myDoc = collection.find(eq(p.getUserM(),user)).first();
		//Recuperamos el elemento
		 if(myDoc != null){
		 usuario.setUser(myDoc.get(p.getUserM()).toString());
		 usuario.setPass(myDoc.get(p.getPasswordM()).toString());
		 usuario.setPerfil(myDoc.get(p.getProfileM()).toString());
		 return usuario;
		 }
		 
		return null;
	}
	
	//Metodo para insetar en la base de datos mongo un caso de prueba, si existe lo updatea con los  nuevos datos
	@Override
	public void addDatoMongo(String datos) {
		p = p.obtener();
		System.out.println("Entro en addDatoMongo");
		Gson gson = new Gson();
		//Recuperamos la base de datos.
		MongoDatabase database = mongo.getDatabase(p.getBaseDeDatosM());
		MongoCollection<Document> collection= database.getCollection(p.getTablaCasosDePruebaM());
		//Me paso el json a mi clase
		CasoAdd ope = gson.fromJson(datos, CasoAdd.class);
		System.out.println(ope.getNombreCaso());
		//Compruebo la cola, usando origen y instrumento, me guardo la cola
		
		
		//////////
		
		//Busco el nombreCaso
		Document myDoc = collection.find(eq(p.getNombreCasoM(),ope.getNombreCaso())).first();
		//Si existe el mismo nombreCaso en mongodb updateo
		if(myDoc != null){
			DeleteResult deleteResult = collection.deleteOne(gte(p.getNombreCasoM(), ope.getNombreCaso()));
			System.out.println(deleteResult.getDeletedCount());
			collection.insertOne(Document.parse(datos));
		}else{
			collection.insertOne(Document.parse(datos));
		}

	}
	
	//El metodo para seleccionar Origen/Destino/Instrumentos para el combo box
	@Override
	public List<String> selectCombo(String sentencia) {
		p = p.obtener();
		//Recuperamos la base de datos.
		DB database = (DB) mongo.getDB(p.getBaseDeDatosM());
		 
		 //Recuperamos los datos para los combo box
		 DBCollection coleccion = database.getCollection(p.getTablaFiltersM());
		 @SuppressWarnings("unchecked")
		List<String> cl1 = coleccion.distinct(sentencia);
		 java.util.Collections.sort(cl1);
		return cl1;
	}
	//realiza otra conexion para sacar de la tabla CONEXIONES conexion
	@Override
	public List<String> selectComboConexiones(String sentencia) {
		p = p.obtener();
		//Recuperamos la base de datos.
		DB database = (DB) mongo.getDB(p.getBaseDeDatosM());
		 
		 //Recuperamos los datos para los combo box
		 DBCollection coleccion = database.getCollection(p.getTablaConexionesM());
		 @SuppressWarnings("unchecked")
		List<String> cl1 = coleccion.distinct(sentencia);
		 java.util.Collections.sort(cl1);
		return cl1;
	}
	

	//El metodo para obtener los casos de prueba para el combobox
		@Override
		public List<String> selectComboCasos(String sentencia) {
//			System.out.println("Entro en el DAO");
//			List<String> cl = new ArrayList<String>();
//			 p = p.obtener();
//			//Recuperamos la base de datos.
//			MongoDatabase database = mongo.getDatabase(p.getBaseDeDatosM());
//			MongoCollection<Document> collection= database.getCollection(p.getTablaCasosDePruebaM());
//			
//			MongoCursor<String> cl1 = collection.distinct(sentencia,String.class).iterator();
//			while(cl1.hasNext()) {
//				cl.add(cl1.next());
//			      System.out.println(cl1.next());
//			    }
			
			 p = p.obtener();
			 //Recuperamos la base de datos.
			 DB database = (DB) mongo.getDB(p.getBaseDeDatosM());
			 
			 //Recuperamos los datos para los combo box
			 DBCollection coleccion = database.getCollection(p.getTablaCasosDePruebaM());
			 @SuppressWarnings("unchecked")
			 List<String> cl1 = coleccion.distinct(sentencia);
			 java.util.Collections.sort(cl1);

			return cl1; 
		}

		
//Elimina un CASOSPRUEBA a partir del nombreCaso
	@Override
	public void deleteDatoMongo(String nombreCaso) {
		System.out.println("entro en el dao");
		p = p.obtener();
		Gson gson = new Gson();
		CasoDelete ope = gson.fromJson(nombreCaso, CasoDelete.class);
		System.out.println(ope.getNombreCaso());
		MongoDatabase database = mongo.getDatabase(p.getBaseDeDatosM());
		MongoCollection<Document> collection= database.getCollection(p.getTablaCasosDePruebaM());
		DeleteResult deleteResult = collection.deleteOne(gte(p.getNombreCasoM(),ope.getNombreCaso()));
		System.out.println(deleteResult.getDeletedCount());
	}

	//Guarda un resultado
	@Override
	public void saveMongoResult(String savemongoresult) {
		p = p.obtener();
		//Recuperamos la base de datos.
		MongoDatabase database = mongo.getDatabase(p.getBaseDeDatosM());
		MongoCollection<Document> collection= database.getCollection(p.getTablaResultadosM());
		collection.insertOne(Document.parse(savemongoresult));
	}

	//Elimina un resultado
	@Override
	public void deleteMongoResult(String nombreCaso) {
		Gson gson = new Gson();
		p = p.obtener();
		//Recuperamos la base de datos.
		MongoDatabase database = mongo.getDatabase(p.getBaseDeDatosM());
		MongoCollection<Document> collection= database.getCollection(p.getTablaResultadosM());
        ResultDelete ope = gson.fromJson(nombreCaso, ResultDelete.class);
		DeleteResult deleteResult = collection.deleteMany(gte(p.getNombreResM(), ope.getNombreRes()));
		System.out.println(deleteResult.getDeletedCount());
	}


}
