package com.acc.regresiontest.com.domains;

import java.io.Serializable;



public class Datos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String idPeticion;
	private String instrumento;
	private String accion;
	private String origen;
	private String destino;
	private String mensaje;
	private String mensajeNeutro;
	private String mensajeDestino;
	private String id;
	
	
	
	public Datos(String idPeticion, String instrumento, String accion, String origen, String destino, String mensaje,
			String mensajeNeutro, String mensajeDestino, String id) {
		super();
		this.idPeticion = idPeticion;
		this.instrumento = instrumento;
		this.accion = accion;
		this.origen = origen;
		this.destino = destino;
		this.mensaje = mensaje;
		this.mensajeNeutro = mensajeNeutro;
		this.mensajeDestino = mensajeDestino;
		this.id = id;
	}
	public Datos() {
		super();
	}
	public String getIdPeticion() {
		return idPeticion;
	}
	public void setIdPeticion(String idPeticion) {
		this.idPeticion = idPeticion;
	}
	public String getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getMensajeNeutro() {
		return mensajeNeutro;
	}
	public void setMensajeNeutro(String mensajeNeutro) {
		this.mensajeNeutro = mensajeNeutro;
	}
	public String getMensajeDestino() {
		return mensajeDestino;
	}
	public void setMensajeDestino(String mensajeDestino) {
		this.mensajeDestino = mensajeDestino;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Datos [idPeticion=");
		builder.append(idPeticion);
		builder.append(", instrumento=");
		builder.append(instrumento);
		builder.append(", accion=");
		builder.append(accion);
		builder.append(", origen=");
		builder.append(origen);
		builder.append(", destino=");
		builder.append(destino);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", mensajeNeutro=");
		builder.append(mensajeNeutro);
		builder.append(", mensajeDestino=");
		builder.append(mensajeDestino);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	

	
}
