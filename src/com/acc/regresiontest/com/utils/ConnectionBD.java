package com.acc.regresiontest.com.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public final class ConnectionBD {
	
	private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver" ;
	private static final String URL = "jdbc:oracle:thin:@//localhost:1521" ;
	private static final String USER = "system" ;
	private static final String PASSWORD = "admin123" ;
	
	private static ConnectionBD connectionBD;
	
	private static Connection connection;
	
	private ConnectionBD(){
	
	
			try {
				Class.forName(ConnectionBD.DRIVER_NAME);
				connection = DriverManager.getConnection(ConnectionBD.URL, USER, PASSWORD);
				connection.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		
	}
	
	
	public static Connection getInstance(){
		if (ConnectionBD.connectionBD == null){
			ConnectionBD.connectionBD = new ConnectionBD();
		}
		return ConnectionBD.connection;
	}
	
	public static void close(){
		
		try{
			if(connection != null){
				connection.close();
			}
		} catch(SQLException e) {
			
		}
		
		ConnectionBD.connectionBD = null;
	}
	
	public static void rollback(){
		
		try{
			connection.rollback();
		} catch (SQLException e){
			close();
		}
	}
	
	public static void commit(){
		

			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	public static void closeResultSet(ResultSet resultSet){
		
		try{
			resultSet.close();
		} catch (Exception e){
			
		}
	}
}
