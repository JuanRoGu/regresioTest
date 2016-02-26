package com.acc.regresiontest.com.interfaces;

import java.util.List;

import com.acc.regresiontest.com.domains.Datos;
import com.acc.regresiontest.com.domains.OperacionesOracle;

public interface IOracleDao {
	
	public List<Datos> listAll();
	
	public Datos findByid(String id);
	
	public List<OperacionesOracle> findID(String request_ID);

}
