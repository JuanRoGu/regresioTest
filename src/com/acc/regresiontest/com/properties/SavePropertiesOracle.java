package com.acc.regresiontest.com.properties;

import java.util.Properties;

public class SavePropertiesOracle {

	//Datos conexion
	private String DRIVER_NAMEO;
	private String URLOracleO;
	private String USERO;
	private String PASSWORDO;
	///Tablas
	private String OPERACIONESO;
	//Dato Tabla Operaciones
	private String REQUEST_IDO;
	private String IDO;
	private String INSTRUMENTOO;
	private String ACCIONO;
	private String ORIGENO;
	private String DESTINOO;
	private String MENSAJEO;
	private String MENSMNO;
	private String MENSDESTINOO;
	private String FECHAALTAO;
	
	
	public SavePropertiesOracle obtener(){
		ArchivoPropiedades archivopropiedades = new ArchivoPropiedades();
		Properties propiedades = new Properties();
		
		propiedades = archivopropiedades.recuperarDatos();
		SavePropertiesOracle save = new SavePropertiesOracle();
		
		//Conexiones Oracle
		save.setDRIVER_NAMEO(propiedades.getProperty("DRIVER_NAMEO"));
		save.setURLOracleO(propiedades.getProperty("URLOracleO"));
		save.setUSERO(propiedades.getProperty("USERO"));
		save.setPASSWORDO(propiedades.getProperty("PASSWORDO"));
		//Tablas
		save.setOPERACIONESO(propiedades.getProperty("OPERACIONESO"));
		//Dato Tabla Operaciones
		save.setREQUEST_IDO(propiedades.getProperty("REQUEST_IDO"));
		save.setIDO(propiedades.getProperty("IDO"));
		save.setINSTRUMENTOO(propiedades.getProperty("INSTRUMENTOO"));
		save.setACCIONO(propiedades.getProperty("ACCIONO"));
		save.setORIGENO(propiedades.getProperty("ORIGENO"));
		save.setDESTINOO(propiedades.getProperty("DESTINOO"));
		save.setMENSAJEO(propiedades.getProperty("MENSAJEO"));
		save.setMENSMNO(propiedades.getProperty("MENSMNO"));
		save.setMENSDESTINOO(propiedades.getProperty("MENSDESTINOO"));
		save.setFECHAALTAO(propiedades.getProperty("FECHAALTAO"));
		return save;
		
	}


	public String getDRIVER_NAMEO() {
		return DRIVER_NAMEO;
	}


	public void setDRIVER_NAMEO(String dRIVER_NAMEO) {
		DRIVER_NAMEO = dRIVER_NAMEO;
	}


	public String getURLOracleO() {
		return URLOracleO;
	}


	public void setURLOracleO(String uRLOracleO) {
		URLOracleO = uRLOracleO;
	}


	public String getUSERO() {
		return USERO;
	}


	public void setUSERO(String uSERO) {
		USERO = uSERO;
	}


	public String getPASSWORDO() {
		return PASSWORDO;
	}


	public void setPASSWORDO(String pASSWORDO) {
		PASSWORDO = pASSWORDO;
	}


	public String getOPERACIONESO() {
		return OPERACIONESO;
	}


	public void setOPERACIONESO(String oPERACIONESO) {
		OPERACIONESO = oPERACIONESO;
	}


	public String getREQUEST_IDO() {
		return REQUEST_IDO;
	}


	public void setREQUEST_IDO(String rEQUEST_IDO) {
		REQUEST_IDO = rEQUEST_IDO;
	}


	public String getIDO() {
		return IDO;
	}


	public void setIDO(String iDO) {
		IDO = iDO;
	}


	public String getINSTRUMENTOO() {
		return INSTRUMENTOO;
	}


	public void setINSTRUMENTOO(String iNSTRUMENTOO) {
		INSTRUMENTOO = iNSTRUMENTOO;
	}


	public String getACCIONO() {
		return ACCIONO;
	}


	public void setACCIONO(String aCCIONO) {
		ACCIONO = aCCIONO;
	}


	public String getORIGENO() {
		return ORIGENO;
	}


	public void setORIGENO(String oRIGENO) {
		ORIGENO = oRIGENO;
	}


	public String getDESTINOO() {
		return DESTINOO;
	}


	public void setDESTINOO(String dESTINOO) {
		DESTINOO = dESTINOO;
	}


	public String getMENSAJEO() {
		return MENSAJEO;
	}


	public void setMENSAJEO(String mENSAJEO) {
		MENSAJEO = mENSAJEO;
	}


	public String getMENSMNO() {
		return MENSMNO;
	}


	public void setMENSMNO(String mENSMNO) {
		MENSMNO = mENSMNO;
	}


	public String getMENSDESTINOO() {
		return MENSDESTINOO;
	}


	public void setMENSDESTINOO(String mENSDESTINOO) {
		MENSDESTINOO = mENSDESTINOO;
	}


	public String getFECHAALTAO() {
		return FECHAALTAO;
	}


	public void setFECHAALTAO(String fECHAALTAO) {
		FECHAALTAO = fECHAALTAO;
	}
	
	
	
	
}
