package pruebas;

import com.acc.regresiontest.com.utils.ConnectionMongoDB;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Prueba1 {

	public static void main(String[] args) {
		System.out.println("Prueba conexión MongoDB");
		MongoClient mongo = ConnectionMongoDB.getInstance();

		// MongoClient cliente = new MongoClient( new ServerAddress( "www.notodocodigo.com", 27017));
		
	
	 //Recuperamos la base de datos.
	 DB database = mongo.getDB("login");
	 
	 //Recuperamos los valores de la colección, previamente hemos introducido 
	 //unos valores desde la consola de mongo con db.things.save({name:"mongoDB"})
	 DBCollection coleccion = database.getCollection("user");
	 
	 //Recuperamos el elemento
	 DBObject query = new BasicDBObject("pass", "tester");
	
	 DBObject documento = coleccion.findOne(query);
	 if(documento != null){
	 String prueba = documento.get("user").toString();
	 System.out.println(prueba);
	 }
	 else{
		 System.out.println("usuario no registrado");
	 }
	 
	}
}
