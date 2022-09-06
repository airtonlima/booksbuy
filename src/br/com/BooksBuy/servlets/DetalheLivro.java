package br.com.BooksBuy.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BooksBuy.bean.Livro;
import br.com.BooksBuy.dao.LivroDAO;

@WebServlet("/Detalhe")
public class DetalheLivro extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public DetalheLivro() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}
	
	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "detalhe.jsp";
		
		Integer id = Integer.parseInt(request.getParameter("id"));

		LivroDAO dao = new LivroDAO();
	
		Livro l = null;
		
		l = dao.getByPK(id);
		
		request.setAttribute("livroDetalhe", l);

		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
