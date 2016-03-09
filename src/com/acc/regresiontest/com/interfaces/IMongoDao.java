package com.acc.regresiontest.com.interfaces;

import java.util.List;

import com.acc.regresiontest.com.domains.CasosDePrueba;
import com.acc.regresiontest.com.domains.SaveMongoResult;
import com.acc.regresiontest.com.domains.User;

public interface IMongoDao {
	
	
	
	public User findUser(String user);	
	
	public List <String> selectCombo(String sentencia);
	
	public List<String> selectComboConexiones(String sentencia);

	public List <String> selectComboCasos(String datos);
	
	public void addDatoMongo(String datos);
		
	public void deleteDatoMongo(String NombreCaso);
	
	public void saveMongoResult(String savemongoresult);
	
	public void deleteMongoResult(String deletemongoresult);

}
