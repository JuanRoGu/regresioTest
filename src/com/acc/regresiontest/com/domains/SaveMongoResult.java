package com.acc.regresiontest.com.domains;

import java.io.Serializable;

public class SaveMongoResult implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NombreRes;
	private String Json;
	
	public SaveMongoResult() {
		// TODO Auto-generated constructor stub
	}

	public SaveMongoResult(String nombreRes, String json) {
		super();
		NombreRes = nombreRes;
		Json = json;
	}

	public String getNombreRes() {
		return NombreRes;
	}

	public void setNombreRes(String nombreRes) {
		NombreRes = nombreRes;
	}

	public String getJson() {
		return Json;
	}

	public void setJson(String json) {
		Json = json;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SaveMongoResult [NombreRes=");
		builder.append(NombreRes);
		builder.append(", Json=");
		builder.append(Json);
		builder.append("]");
		return builder.toString();
	}
	
	
	

}
