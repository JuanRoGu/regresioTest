package com.acc.regresiontest.com.interfaces;

import java.util.List;

import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.Operaciones;

public interface IOracleDao {
	
	public List<Datos> listAll();
	
	public Datos findByid(String id);
	
	public Operaciones findID(String request_ID);

}
