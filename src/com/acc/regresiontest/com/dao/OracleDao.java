package com.acc.regresiontest.com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.acc.regresiontest.com.Exception.DAOException;
import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.OperacionesMongo;
import com.acc.regresiontest.com.domains.OperacionesOracle;
import com.acc.regresiontest.com.interfaces.IOracleDao;
import com.acc.regresiontest.com.properties.SavePropertiesMongo;
import com.acc.regresiontest.com.properties.SavePropertiesOracle;
import com.acc.regresiontest.com.utils.ConnectionBD;




public class OracleDao implements IOracleDao {
	SavePropertiesOracle p = new SavePropertiesOracle();

	private PreparedStatement findAllStatement;
	private PreparedStatement findByIdStatement;
	
	private PreparedStatement findByIdStatement1;
	private Connection conn;

	public OracleDao() {
		try {
			
			conn = ConnectionBD.getInstance();
			
			
			this.findAllStatement = conn.prepareStatement("SELECT idpeticion, instrumento, accion, origen, destino, mensaje  "
									+ "FROM operaciones");
			
			this.findByIdStatement = conn.prepareStatement("SELECT REQUEST_ID,INSTRUMENTO,ACCION,ORIGEN,DESTINO,MENSAJE,MENSMN,MENSDESTINO "
					+ "FROM operaciones WHERE request_ID = ? ");

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
		p = p.obtener();

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
	public List<OperacionesOracle> findID(
			String Id_Peticion,
			String Instrumento,
			String Origen,
			String Destino,
			String fechaDesde, 
			String fechaHasta) {
		
		p = p.obtener();
		
//		SELECT REQUEST_ID,INSTRUMENTO,ACCION,ORIGEN,DESTINO,MENSAJE,MENSMN,MENSDESTINO "
//				+ "FROM operaciones WHERE ID = '"+Id_Peticion+"'"
		String sentencia = "SELECT "
				+ ""+p.getREQUEST_IDO()+","
				+ ""+p.getINSTRUMENTOO()+","
				+ ""+p.getACCIONO()+","
				+ ""+p.getORIGENO()+","
				+ ""+p.getDESTINOO()+","
				+ ""+p.getMENSAJEO()+","
				+ ""+p.getMENSMNO()+","
				+ ""+p.getMENSDESTINOO()+" "
					+ "FROM "+p.getOPERACIONESO()+" WHERE "+p.getIDO()+" = '"+Id_Peticion+"'";
		ResultSet resultSet = null;
		List<OperacionesOracle> operaciones = new ArrayList<>();

		try {
		//Creo la sentencia
		if(Instrumento.length() > 0){
			sentencia = sentencia.concat(" AND "+p.getINSTRUMENTOO()+" = '"+Instrumento+"'");
		}else if(Origen.length() > 0){
			sentencia =sentencia.concat(" AND "+p.getORIGENO()+" = '"+Origen+"'");
		}else if(Destino.length() > 0){
			sentencia =sentencia.concat(" AND "+p.getDESTINOO()+" = '"+Destino+"'");
		}else if(fechaDesde.length() >0){
			sentencia =sentencia.concat(" AND "+p.getFECHAALTAO()+" > '"+fechaDesde+"'");
		}else if(fechaHasta.length() >0){
			sentencia =sentencia.concat(" AND "+p.getFECHAALTAO()+" < '"+fechaHasta+"'");
		}
		
		System.out.println(sentencia);
			this.findByIdStatement1 = conn.prepareStatement(sentencia);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			resultSet = this.findByIdStatement1.executeQuery();
			
			while(resultSet.next()){
				OperacionesOracle ope = new OperacionesOracle();
//				ope.setRequest_ID(resultSet.getString("request_ID"));
//				ope.setInstrumento(resultSet.getString("Instrumento"));
//				ope.setAccion(resultSet.getString("Accion"));
//				ope.setOrigen(resultSet.getString("Origen"));
//				ope.setDestino(resultSet.getString("Destino"));
//				ope.setMensaje(resultSet.getString("Mensaje"));
//				ope.setMensMN(resultSet.getString("MensMN"));
//				ope.setMensDestino(resultSet.getString("MensDestino"));
				
				ope.setRequest_ID(resultSet.getString(""+p.getREQUEST_IDO()+""));
				ope.setInstrumento(resultSet.getString(""+p.getINSTRUMENTOO()+""));
				ope.setAccion(resultSet.getString(""+p.getACCIONO()+""));
				ope.setOrigen(resultSet.getString(""+p.getORIGENO()+""));
				ope.setDestino(resultSet.getString(""+p.getDESTINOO()+""));
				ope.setMensaje(resultSet.getString(""+p.getMENSAJEO()+""));
				ope.setMensMN(resultSet.getString(""+p.getMENSMNO()+""));
				ope.setMensDestino(resultSet.getString(""+p.getMENSDESTINOO()+""));
				operaciones.add(ope);
			}
			return operaciones;
		} catch (SQLException e) {

			throw new DAOException(e.getMessage());
			
		}
	}
}
