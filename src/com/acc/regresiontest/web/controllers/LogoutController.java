package com.acc.regresiontest.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acc.regresiontest.com.interfaces.IController;

public class LogoutController implements IController{

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String view="index.jsp";

		request.getSession().invalidate();
		
		return view; 
	}

}
