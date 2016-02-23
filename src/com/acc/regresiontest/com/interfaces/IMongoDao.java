package com.acc.regresiontest.com.interfaces;

import java.util.List;

import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.Instrumento;
import com.acc.regresiontest.com.domains.User;

public interface IMongoDao {
	
	public User findUser(String user);
	
	public void addDato(Datos datos);
	
	public List <String> selectInstrumentos(String sentencia);

}
