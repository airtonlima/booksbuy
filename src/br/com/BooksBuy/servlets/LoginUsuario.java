package br.com.BooksBuy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BooksBuy.bean.LoginRoot;
import br.com.BooksBuy.classes.CriptoSHA_256;
import br.com.BooksBuy.dao.LoginDAO;

@WebServlet("/LoginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginUsuario() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}
	
	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginRoot lg = new LoginRoot();
		LoginDAO dao = new LoginDAO();
		CriptoSHA_256 ck = new CriptoSHA_256();
		
		String pagina = "";
		
		
		
		lg.setUsernameUsuario(request.getParameter("txtUsuario"));
		lg.setSenhaUsuario(ck.criptString(request.getParameter("txtSenha")));
		
		if(dao.login(lg))
			pagina = "home";
		else
			pagina = "login.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
