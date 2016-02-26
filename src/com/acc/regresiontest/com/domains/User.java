package com.acc.regresiontest.com.domains;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	private String pass;
	private String profile;
	public User(String user, String pass, String perfil) {
		super();
		this.user = user;
		this.pass = pass;
		this.profile = perfil;
	}
	public User() {
		super();
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPerfil() {
		return profile;
	}
	public void setPerfil(String perfil) {
		this.profile = perfil;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [user=");
		builder.append(user);
		builder.append(", pass=");
		builder.append(pass);
		builder.append(", perfil=");
		builder.append(profile);
		builder.append("]");
		return builder.toString();
	}
	
	

}
