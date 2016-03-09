package com.acc.regresiontest.com.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.acc.regresiontest.com.properties.SavePropertiesOracle;
public final class ConnectionBD {
	
	private static SavePropertiesOracle p = new SavePropertiesOracle();
	
	private static ConnectionBD connectionBD;
	
	private static Connection connection;
	
	private ConnectionBD(){
		p = p.obtener();
	
			try {
				Class.forName(ConnectionBD.p.getDRIVER_NAMEO());
				connection = DriverManager.getConnection(ConnectionBD.p.getURLOracleO(), p.getUSERO(), p.getPASSWORDO());
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
