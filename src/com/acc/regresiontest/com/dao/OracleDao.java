package com.acc.regresiontest.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.interfaces.IDatosDao;
import com.acc.regresiontest.com.utils.ConnectionBD;

public class OracleDao implements IDatosDao {


	private PreparedStatement findAllStatement;
	private Connection conn;

	public OracleDao() {
		try {
			conn = ConnectionBD.getInstance();
			this.findAllStatement = conn.prepareStatement("SELECT idpeticion, instrumento, accion, origen, destino, mensaje  " + "FROM operaciones");
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

}
