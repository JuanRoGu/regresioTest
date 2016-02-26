package com.acc.regresiontest.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.OperacionesOracle;
import com.acc.regresiontest.com.interfaces.IOracleDao;
import com.acc.regresiontest.com.utils.ConnectionBD;




public class OracleDao implements IOracleDao {


	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	
	private Connection conn;

	public OracleDao() {
		try {
			conn = ConnectionBD.getInstance();
			
			this.findAllStatement = conn.prepareStatement("SELECT idpeticion, instrumento, accion, origen, destino, mensaje  "
									+ "FROM operaciones");
			
			
			this.findByIdStatement = conn.prepareStatement("SELECT REQUEST_ID,INSTRUMENTO,ACCION,ORIGEN,MENSAJE,MENSMN "
									+ "FROM operaciones WHERE request_ID = ?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List <Datos> listAll() {
		
		List <Datos> datosList = new ArrayList<Datos>();

		ResultSet resultSet = null;

		try{

			resultSet = this.findAllStatement.executeQuery();
			while(resultSet.next()){
				Datos datos = new Datos();
				datos.setIdPeticion(resultSet.getString(1));
				datos.setInstrumento(resultSet.getString(2));
				datos.setAccion(resultSet.getString(3));
				datos.setOrigen(resultSet.getString(4));
				datos.setDestino(resultSet.getString(5));
				datos.setMensaje(resultSet.getString(6));
				datosList.add(datos);
			}
			return datosList;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Datos findByid(String id) {
		

		ResultSet resultSet = null;
		
		Datos datos = new Datos();
		
		try {
			// Preparamos el preparedStatement con la query de inserción
			
			this.findByIdStatement.setString(1, id);
			resultSet = this.findAllStatement.executeQuery();
			
			if(resultSet.next()){
				datos.setIdPeticion(resultSet.getString("idpeticion"));
				datos.setInstrumento(resultSet.getString("instrumento"));
				datos.setAccion(resultSet.getString("accion"));
				datos.setOrigen(resultSet.getString("origen"));
				datos.setDestino(resultSet.getString("destino"));
				datos.setMensaje(resultSet.getString("mensaje"));
				datos.setMensajeNeutro(resultSet.getString("mensajeneutro"));
				
				return datos;
			}
		} catch (SQLException e) {

			throw new DAOException(e.getMessage());
			
		}
		return null;
		
	}

	@Override
	public List<OperacionesOracle> findID(String request_ID) {
		System.out.println("Entro en el metodo de buscar de oracle");
		ResultSet resultSet = null;
		
		List<OperacionesOracle> operaciones = new ArrayList<>();
		
		try {
			
			this.findByIdStatement.setString(1, request_ID);
			resultSet = this.findByIdStatement.executeQuery();
			
			while(resultSet.next()){
				OperacionesOracle ope = new OperacionesOracle();
				ope.setRequest_ID(resultSet.getString("request_ID"));
				ope.setInstrumento(resultSet.getString("Instrumento"));
				ope.setAccion(resultSet.getString("Accion"));
				ope.setOrigen(resultSet.getString("Origen"));
				ope.setMensaje(resultSet.getString("Mensaje"));
				ope.setMensMN(resultSet.getString("MensMN"));
				operaciones.add(ope);
			}
			return operaciones;
		} catch (SQLException e) {

			throw new DAOException(e.getMessage());
			
		}
	}
	
	

}
