package com.acc.regresiontest.com.domains;

import java.io.Serializable;

public class Operaciones implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String request_ID;
	private String ID;
	private String Instrumento;
	private String Accion;
	private String Origen;
	private String Destino;
	private String Mensaje;
	private String MensMN;
	private String MensDestino;
	
	public Operaciones() {
		// TODO Auto-generated constructor stub
	}

	public Operaciones(String request_ID, String iD, String instrumento, String accion, String origen, String destino,
			String mensaje, String mensMN, String mensDestino) {
		super();
		this.request_ID = request_ID;
		ID = iD;
		Instrumento = instrumento;
		Accion = accion;
		Origen = origen;
		Destino = destino;
		Mensaje = mensaje;
		MensMN = mensMN;
		MensDestino = mensDestino;
	}

	public String getRequest_ID() {
		return request_ID;
	}

	public void setRequest_ID(String request_ID) {
		this.request_ID = request_ID;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
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

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
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

	public String getMensDestino() {
		return MensDestino;
	}

	public void setMensDestino(String mensDestino) {
		MensDestino = mensDestino;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operaciones [request_ID=");
		builder.append(request_ID);
		builder.append(", ID=");
		builder.append(ID);
		builder.append(", Instrumento=");
		builder.append(Instrumento);
		builder.append(", Accion=");
		builder.append(Accion);
		builder.append(", Origen=");
		builder.append(Origen);
		builder.append(", Destino=");
		builder.append(Destino);
		builder.append(", Mensaje=");
		builder.append(Mensaje);
		builder.append(", MensMN=");
		builder.append(MensMN);
		builder.append(", MensDestino=");
		builder.append(MensDestino);
		builder.append("]");
		return builder.toString();
	}
	
	

}
