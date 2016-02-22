package com.acc.regresiontest.com.interfaces;

import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.User;

public interface IMongoDao {
	
	public User findUser(String user);
	
	public void addDato(Datos datos);

}
