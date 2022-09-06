package br.com.BooksBuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.BooksBuy.bean.CategoriaLivro;
import br.com.BooksBuy.factory.ConnectionFactory;

public class CategoriaLivroDAO {

	Connection conn = null;

	public CategoriaLivroDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (SQLException ex){}
	}

	public List<CategoriaLivro> getAll() {
		
		String sql = "SELECT id_categoria, "
						  + "nome_categoria "
				   + "FROM tb_categoria_livro "
				   + "ORDER BY nome_categoria;";
		
		List<CategoriaLivro> categoria = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			categoria = new ArrayList<CategoriaLivro>();
			
			while(rs.next()){
				CategoriaLivro c = new CategoriaLivro();
				c.setIdCategoriaLivro(rs.getInt("id_categoria"));
				c.setNomeCategoriaLivro(rs.getString("nome_categoria"));
				
				categoria.add(c);
			}
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}	
		return categoria;
	}
}
