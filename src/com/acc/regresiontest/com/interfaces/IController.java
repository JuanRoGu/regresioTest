package com.acc.regresiontest.com.interfaces;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * INTERFACE que define los m�todos abstractos de Un CONTROLLERIMPLEMENT
 *
 */
public interface IController {

	String process(HttpServletRequest request, HttpServletResponse response);

}
