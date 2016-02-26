package com.acc.regresiontest.com.domains;

import java.io.Serializable;

public class OperacionesOracle implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String request_ID;
	private String Instrumento;
	private String Accion;
	private String Origen;
	private String Mensaje;
	private String MensMN;
	
	public OperacionesOracle() {
		// TODO Auto-generated constructor stub
	}

	public OperacionesOracle(String request_ID, String instrumento, String accion, String origen, String mensaje,
			String mensMN) {
		super();
		this.request_ID = request_ID;
		Instrumento = instrumento;
		Accion = accion;
		Origen = origen;
		Mensaje = mensaje;
		MensMN = mensMN;
	}

	public String getRequest_ID() {
		return request_ID;
	}

	public void setRequest_ID(String request_ID) {
		this.request_ID = request_ID;
	}

	public String getInstrumento() {
		return Instrumento;
	}

	public void setInstrumento(String instrumento) {
		Instrumento = instrumento;
	}

	public String getAccion() {
		return Accion;
	}

	public void setAccion(String accion) {
		Accion = accion;
	}

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}

	public String getMensaje() {
		return Mensaje;
	}

	public void setMensaje(String mensaje) {
		Mensaje = mensaje;
	}

	public String getMensMN() {
		return MensMN;
	}

	public void setMensMN(String mensMN) {
		MensMN = mensMN;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OperacionesOracle [request_ID=");
		builder.append(request_ID);
		builder.append(", Instrumento=");
		builder.append(Instrumento);
		builder.append(", Accion=");
		builder.append(Accion);
		builder.append(", Origen=");
		builder.append(Origen);
		builder.append(", Mensaje=");
		builder.append(Mensaje);
		builder.append(", MensMN=");
		builder.append(MensMN);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

}
