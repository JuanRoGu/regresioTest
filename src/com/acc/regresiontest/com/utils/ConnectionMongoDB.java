package com.acc.regresiontest.com.utils;

import com.mongodb.MongoClient;

/**
 * Prueba para realizar conexión con MongoDB.
 * 
 * @author j
 *
 */

public class ConnectionMongoDB {

	private static ConnectionMongoDB connectionBD;
	//private static MongoClient connection;
	private static MongoClient mongo;


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
        try {
        	mongo = new MongoClient("localhost", 27017);
        }
        catch (Exception e) {
        	System.err.println(e.getClass().getName() + ": ");
        	e.getMessage();
        }
 
        return mongo;
    }

}
