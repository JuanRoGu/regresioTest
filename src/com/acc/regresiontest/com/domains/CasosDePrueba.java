package com.acc.regresiontest.com.domains;

import java.io.Serializable;
import java.util.List;

public class CasosDePrueba implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreCaso;
	private List<OperacionesMongo> operaciones;
	List<String> casosdeprueba;
	
	public CasosDePrueba() {
		// TODO Auto-generated constructor stub
	}

	public CasosDePrueba(String nombreCaso, List<OperacionesMongo> operaciones) {
		super();
		this.nombreCaso = nombreCaso;
		this.operaciones = operaciones;
	}

	public String getNombreCaso() {
		return nombreCaso;
	}

	public void setNombreCaso(String nombreCaso) {
		this.nombreCaso = nombreCaso;
	}

	public List<OperacionesMongo> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<OperacionesMongo> operaciones) {
		this.operaciones = operaciones;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CasosDePrueba [nombreCaso=");
		builder.append(nombreCaso);
		builder.append(", operaciones=");
		builder.append(operaciones);
		builder.append("]");
		return builder.toString();
	}
	
	public List<String> getCasosPrueba() {
		return casosdeprueba;
	}

	public void setCasosPrueba(List<String> casosdeprueba) {
		this.casosdeprueba = casosdeprueba;
	}
	
	
	
	

}
