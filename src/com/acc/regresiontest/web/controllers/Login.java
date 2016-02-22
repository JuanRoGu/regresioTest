package com.acc.regresiontest.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.domains.User;
import com.acc.regresiontest.com.interfaces.IController;


public class Login extends HttpServlet implements IController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void processRequestPOST(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/usermain.jsp";
		MongoDao Mdao = new MongoDao();

		HttpSession sesion = request.getSession();
		String usu, pass;
		usu = request.getParameter("user");
		pass = request.getParameter("password");
		// buscamos en la base de mongodb
		User usuario = Mdao.findUser(usu);
		if(usuario == null){
			request.setAttribute("error", "Invalid Username / Password");
		}
		else if(usu.equals(usuario.getUser()) && pass.equals(usuario.getPass()) && sesion.getAttribute("usuario") == null) {
			// si coincide usuario y password y además no hay sesión iniciada
			sesion.setAttribute("usuario", usu);
			// redirijo a página con información de login exitoso
			response.sendRedirect("loginExito.jsp");
		} 
		
	}

	// método encargado de la gestión del método GET
	protected void processRequestGET(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// me llega la url "proyecto/login/out"
		String action = (request.getPathInfo() != null ? request.getPathInfo() : "");
		HttpSession sesion = request.getSession();
		if (action.equals("/out")) {
			sesion.invalidate();
			response.sendRedirect("/index.jsp");
		} else {

		}
	}

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
