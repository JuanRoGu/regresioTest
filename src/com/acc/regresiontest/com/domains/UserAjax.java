package com.acc.regresiontest.com.domains;

import java.io.Serializable;

public class UserAjax implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String user;
	
	public UserAjax() {
		// TODO Auto-generated constructor stub
	}

	public UserAjax(String user) {
		super();
		this.user = user;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserAjax [user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}
	

}
