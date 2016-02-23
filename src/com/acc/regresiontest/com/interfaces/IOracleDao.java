package com.acc.regresiontest.com.interfaces;

import java.util.List;

import com.acc.regresiontest.com.domains.Datos;

public interface IOracleDao {
	
	public List<Datos> listAll();
	
	public Datos findByid(String id);

}
