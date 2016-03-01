package com.acc.regresiontest.com.domains;

import java.io.Serializable;

public class FiltroExecution implements Serializable{

	private static final long serialVersionUID = 1L;
	private String Id_Peticion;
	private String Instrumento;
	private String Origen;
	private String Destino;
	private String fechaDesde;
	private String fechaHasta;

	public FiltroExecution() {
		// TODO Auto-generated constructor stub
	}

	public FiltroExecution(String id_Peticion, String instrumento, String origen, String destino, String fechaDesde,
			String fechaHasta) {
		super();
		Id_Peticion = id_Peticion;
		Instrumento = instrumento;
		Origen = origen;
		Destino = destino;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
	}

	public String getId_Peticion() {
		return Id_Peticion;
	}

	public void setId_Peticion(String id_Peticion) {
		Id_Peticion = id_Peticion;
	}

	public String getInstrumento() {
		return Instrumento;
	}

	public void setInstrumento(String instrumento) {
		Instrumento = instrumento;
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

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FiltroExecution [Id_Peticion=");
		builder.append(Id_Peticion);
		builder.append(", Instrumento=");
		builder.append(Instrumento);
		builder.append(", Origen=");
		builder.append(Origen);
		builder.append(", Destino=");
		builder.append(Destino);
		builder.append(", fechaDesde=");
		builder.append(fechaDesde);
		builder.append(", fechaHasta=");
		builder.append(fechaHasta);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
