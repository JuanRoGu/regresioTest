package com.acc.regresiontest.com.domains;

import java.io.Serializable;

public class OperacionesAdd implements Serializable{
	
	private String id;
	private String idPeticion;
	private String instrumento;
	private String origen;
	private String accion;
	private String destino;
	private String mensaje;
	private String mensajeNeutro;
	private String mensajeDestino;
	
	public OperacionesAdd() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
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
}
