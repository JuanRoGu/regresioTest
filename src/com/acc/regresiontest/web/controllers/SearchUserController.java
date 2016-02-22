package com.acc.regresiontest.web.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acc.regresiontest.com.dao.MongoDao;
import com.acc.regresiontest.com.domains.DomainException;
import com.acc.regresiontest.com.domains.User;
import com.acc.regresiontest.com.interfaces.IController;

/**
 * This Controller is for validating u in the first page and redirects to
 * visitor homepage based on credentials. if validation fails, error message is
 * printed on same screen
 *
 */
public class SearchUserController implements IController {

	@Override
	public String process(HttpServletRequest request,
			HttpServletResponse response) {
		String view = "/WEB-INF/usermain.jsp";
		MongoDao Mdao = new MongoDao();
		try {

			User usuario;
			String usu, pass;
			// Se obtiene username y password del Request
			usu = request.getParameter("user");
			pass = request.getParameter("password");;
			usuario = Mdao.findUser(usu);
			// Buscamos un visitor con ese username
		
			if (usuario != null) {
				// Comprobamos que las password coinciden
				if (usuario.getPass().equals(pass)) {
					request.getSession().setAttribute("user", usuario);

				} else {
					request.setAttribute("error", "Invalid Username / Password");
					view = "index.jsp";

				}
			} else {
				request.setAttribute("error",
						"That User Name has not yet been registered");
				view = "index.jsp";
			}

		} catch (DomainException e) {
			request.setAttribute("error", e.getMessage());
			view = "index.jsp";

		}
		return view;

	}

}
