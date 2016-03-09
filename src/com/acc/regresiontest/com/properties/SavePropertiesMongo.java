package com.acc.regresiontest.com.properties;

import java.util.Properties;

public class SavePropertiesMongo {

	//Datos conexion
	private String URLM;
	private String PuertoM;
	private String baseDeDatosM;
			//Tablas
	private String tablaUserM;
	private String tablaCasosDePruebaM;
	private String tablaFiltersM;
	private String tablaResultadosM;
	private String tablaConexionesM;
			//Tabla Conexiones
	private String NombreM;
	private String ConexionesM;
			//Tabla user
	private String UserM;
	private String PasswordM;
	private String ProfileM;
			//TablaCasosDePrueba
	private String nombreCasoM;
	private String request_IDM;
	private String IDM;
	private String InstrumentoM;
	private String AccionM;
	private String OrigenM;
	private String DestinoM;
	private String MensajeM;
	private String MensMNM;
	private String MensDestinoM;
			//TablaFilters
	private String DestinoFM;
	private String OrigenFM;
			//TablaResultados
	private String NombreResM;
	private String JsonM;
	
	public SavePropertiesMongo obtener(){
		
		ArchivoPropiedades archivopropiedades = new ArchivoPropiedades();
		Properties propiedades = new Properties();
		
		propiedades = archivopropiedades.recuperarDatos();
		SavePropertiesMongo save = new SavePropertiesMongo();
		//Conexiones base datos
		save.setURLM(propiedades.getProperty("URLM"));
		save.setPuertoM(propiedades.getProperty("PuertoM"));
		save.setBaseDeDatosM(propiedades.getProperty("baseDeDatosM"));
		//Tablas
		save.setTablaUserM(propiedades.getProperty("tablaUserM"));
		save.setTablaCasosDePruebaM(propiedades.getProperty("tablaCasosDePruebaM"));
		save.setTablaFiltersM(propiedades.getProperty("tablaFiltersM"));
		save.setTablaResultadosM(propiedades.getProperty("tablaResultadosM"));
		save.setTablaConexionesM(propiedades.getProperty("tablaConexionesM"));
		//Tabla Conexiones
		save.setNombreM(propiedades.getProperty("NombreM"));
		save.setConexionesM(propiedades.getProperty("ConexionM"));
		//Tabla user
		save.setUserM(propiedades.getProperty("UserM"));
		save.setPasswordM(propiedades.getProperty("PasswordM"));
		save.setProfileM(propiedades.getProperty("ProfileM"));
		//TablaCasosDePrueba
		save.setNombreCasoM(propiedades.getProperty("nombreCasoM"));
		save.setRequest_IDM(propiedades.getProperty("request_IDM"));
		save.setIDM(propiedades.getProperty("IDM"));
		save.setInstrumentoM(propiedades.getProperty("InstrumentoM"));
		save.setAccionM(propiedades.getProperty("AccionM"));
		save.setOrigenM(propiedades.getProperty("OrigenM"));
		save.setDestinoM(propiedades.getProperty("DestinoM"));
		save.setMensajeM(propiedades.getProperty("MensajeM"));
		save.setMensMNM(propiedades.getProperty("MensMNM"));
		save.setMensDestinoM(propiedades.getProperty("MensDestinoM"));
		//TablaFilters
		save.setDestinoFM(propiedades.getProperty("DestinoFM"));
		save.setOrigenFM(propiedades.getProperty("OrigenFM"));
		//TablaResultados
		save.setNombreResM(propiedades.getProperty("NombreResM"));
		save.setJsonM(propiedades.getProperty("JsonM"));
		
		return save;
		
	}
	public String getURLM() {
		return URLM;
	}
	public String getBaseDeDatosM() {
		return baseDeDatosM;
	}
	public String getTablaUserM() {
		return tablaUserM;
	}
	public String getTablaCasosDePruebaM() {
		return tablaCasosDePruebaM;
	}
	public String getTablaFiltersM() {
		return tablaFiltersM;
	}
	public String getTablaResultadosM() {
		return tablaResultadosM;
	}
	public String getUserM() {
		return UserM;
	}
	public String getPasswordM() {
		return PasswordM;
	}
	public String getProfileM() {
		return ProfileM;
	}
	public String getNombreCasoM() {
		return nombreCasoM;
	}
	public String getRequest_IDM() {
		return request_IDM;
	}
	public String getIDM() {
		return IDM;
	}
	public String getInstrumentoM() {
		return InstrumentoM;
	}
	public String getAccionM() {
		return AccionM;
	}
	public String getOrigenM() {
		return OrigenM;
	}
	public String getDestinoM() {
		return DestinoM;
	}
	public String getMensajeM() {
		return MensajeM;
	}
	public String getMensMNM() {
		return MensMNM;
	}
	public String getMensDestinoM() {
		return MensDestinoM;
	}
	public String getDestinoFM() {
		return DestinoFM;
	}
	public String getOrigenFM() {
		return OrigenFM;
	}
	public String getNombreResM() {
		return NombreResM;
	}
	public String getJsonM() {
		return JsonM;
	}
	public int getPuertoM() {
		return Integer.parseInt(PuertoM);
	}

	public void setURLM(String uRLM) {
		URLM = uRLM;
	}

	public void setPuertoM(String puertoM) {
		PuertoM = puertoM;
	}

	public void setBaseDeDatosM(String baseDeDatosM) {
		this.baseDeDatosM = baseDeDatosM;
	}

	public void setTablaUserM(String tablaUserM) {
		this.tablaUserM = tablaUserM;
	}

	public void setTablaCasosDePruebaM(String tablaCasosDePruebaM) {
		this.tablaCasosDePruebaM = tablaCasosDePruebaM;
	}

	public void setTablaFiltersM(String tablaFiltersM) {
		this.tablaFiltersM = tablaFiltersM;
	}

	public void setTablaResultadosM(String tablaResultadosM) {
		this.tablaResultadosM = tablaResultadosM;
	}

	public void setUserM(String userM) {
		UserM = userM;
	}

	public void setPasswordM(String passwordM) {
		PasswordM = passwordM;
	}

	public void setProfileM(String profileM) {
		ProfileM = profileM;
	}

	public void setNombreCasoM(String nombreCasoM) {
		this.nombreCasoM = nombreCasoM;
	}

	public void setRequest_IDM(String request_IDM) {
		this.request_IDM = request_IDM;
	}

	public void setIDM(String iDM) {
		IDM = iDM;
	}

	public void setInstrumentoM(String instrumentoM) {
		InstrumentoM = instrumentoM;
	}

	public void setAccionM(String accionM) {
		AccionM = accionM;
	}

	public void setOrigenM(String origenM) {
		OrigenM = origenM;
	}

	public void setDestinoM(String destinoM) {
		DestinoM = destinoM;
	}

	public void setMensajeM(String mensajeM) {
		MensajeM = mensajeM;
	}

	public void setMensMNM(String mensMNM) {
		MensMNM = mensMNM;
	}

	public void setMensDestinoM(String mensDestinoM) {
		MensDestinoM = mensDestinoM;
	}

	public void setDestinoFM(String destinoFM) {
		DestinoFM = destinoFM;
	}

	public void setOrigenFM(String origenFM) {
		OrigenFM = origenFM;
	}

	public void setNombreResM(String nombreResM) {
		NombreResM = nombreResM;
	}

	public void setJsonM(String jsonM) {
		JsonM = jsonM;
	}
	public String getTablaConexionesM() {
		return tablaConexionesM;
	}
	public void setTablaConexionesM(String tablaConexionesM) {
		this.tablaConexionesM = tablaConexionesM;
	}
	public String getNombreM() {
		return NombreM;
	}
	public void setNombreM(String nombreM) {
		NombreM = nombreM;
	}
	public String getConexionesM() {
		return ConexionesM;
	}
	public void setConexionesM(String conexionesM) {
		ConexionesM = conexionesM;
	}
	
	
	
	
	
	
	
}
