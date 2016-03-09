package com.acc.regresiontest.com.utils;

import java.util.Properties;

import com.acc.regresiontest.com.properties.ArchivoPropiedades;
import com.acc.regresiontest.com.properties.SavePropertiesMongo;
import com.mongodb.MongoClient;

/**
 * Prueba para realizar conexión con MongoDB.
 * 
 * @author j
 *
 */

public class ConnectionMongoDB {
	
	
	private static ConnectionMongoDB connectionBD;
	private static MongoClient mongo;
	private static SavePropertiesMongo p = new SavePropertiesMongo();

	/**
     * constructor.
     * @param args
     */
	private ConnectionMongoDB(){
        System.out.println("MongoDB");
        mongo = crearConexion();
 
        if (mongo != null) {
            System.out.println("Conexion realizada: ");
 
        } else {
            System.out.println("Error: Conexión no establecida");
        }
    }
	
	public static MongoClient getInstance(){
		ConnectionMongoDB.connectionBD = new ConnectionMongoDB();
		return mongo;
	} 
 
	
	
    /**
     * Clase para crear una conexión a MongoDB.
     * @return MongoClient conexión
     */
    private static MongoClient crearConexion() {
        MongoClient mongo = null;
        p = p.obtener();
        try {
        	mongo = new MongoClient(""+p.getURLM()+"", p.getPuertoM());
        }
        catch (Exception e) {
        	System.err.println(e.getClass().getName() + ": ");
        	e.getMessage();
        }
 
        return mongo;
    }

}
