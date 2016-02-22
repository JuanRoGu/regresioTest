package com.acc.regresiontest.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acc.regresiontest.com.interfaces.IController;
import com.acc.regresiontest.web.controllers.LogoutController;
import com.acc.regresiontest.web.controllers.SearchUserController;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, IController> controllers = new HashMap<String, IController>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
    }
    
    
    

	@Override
	public void init() throws ServletException {
//		controllers.put("/mantenimientoController.do", new MantenimientoController());
//		controllers.put("/newUser.do", new NewUserController());
		controllers.put("/searchUser.do", new SearchUserController());
		controllers.put("/logout.do", new LogoutController());
//		controllers.put("/altaController.do", new AltaController());
//		controllers.put("/modifyController.do", new ModifyController());
//		controllers.put("/buscadorController.do", new SearchController());
		super.init();
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Getting action
		String action = request.getServletPath();
		// execute method process from the controller
		String view = controllers.get(action).process(request, response);
		// create dispatcher to view
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		// forward dispatcher
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	

}
