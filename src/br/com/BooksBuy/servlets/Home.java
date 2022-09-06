package br.com.BooksBuy.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.BooksBuy.bean.CategoriaLivro;
import br.com.BooksBuy.bean.Livro;
import br.com.BooksBuy.dao.CategoriaLivroDAO;
import br.com.BooksBuy.dao.LivroDAO;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Home() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestHandler(request, response);
	}
	
	protected void requestHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pagina = "index.jsp";
		
		CategoriaLivroDAO daoCategoria = new CategoriaLivroDAO();
		ArrayList<CategoriaLivro> categorias = null;
		categorias = (ArrayList<CategoriaLivro>)daoCategoria.getAll();
		request.setAttribute("listaCategorias", categorias);
		
		LivroDAO daoLivro = new LivroDAO();
		ArrayList<Livro> livros = null;
		
		try{	
			Integer idCategoria = Integer.parseInt(request.getParameter("id"));
			
			livros = (ArrayList<Livro>)daoLivro.getByIdCategoria(idCategoria);
			request.setAttribute("listaLivros", livros);
			
		}catch(Exception e){
			
			livros = (ArrayList<Livro>)daoLivro.getFifty();
			request.setAttribute("listaLivros", livros);
		}
		
		if(livros.isEmpty()){
			request.setAttribute("mensagem", "A Busca retornou vazia.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}
}
