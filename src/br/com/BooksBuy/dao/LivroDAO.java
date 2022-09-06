package br.com.BooksBuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.BooksBuy.bean.Livro;
import br.com.BooksBuy.factory.ConnectionFactory;

public class LivroDAO {

	Connection conn = null;
	public LivroDAO(){
		try{
			conn = ConnectionFactory.getConnection();
		}catch(SQLException ex){ }
	}
	
	public void insert(Livro l){

		String sql = "INSERT INTO  TB_LIVRO ("
								+ "ISBN, "
								+ "TITULO, "
								+ "AUTOR, "
								+ "EDITORA, "
								+ "QTDE_PAGINAS, "
								+ "EDICAO, "
								+ "ANO_EDICAO, "
								+ "PRECO, "
								+ "IDIOMA, "
								+ "FOTO, "
								+ "SINOPSE) "
				   + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, l.getIsbnLivro());
			stmt.setString(2, l.getTituloLivro());
			stmt.setString(3, l.getAutorLivro());
			stmt.setString(4, l.getEditoraLivro());
			stmt.setInt(5, l.getQtdePaginas());
			stmt.setInt(6, l.getEdicaoLivro());
			stmt.setInt(7, l.getAnoEdicaoLivro());
			stmt.setFloat(8, l.getPrecoLivro());
			stmt.setString(9, l.getIdiomaLivro());
			stmt.setString(10, l.getFotoLivro());
			stmt.setString(11, l.getSinopseLivro());
			
			stmt.executeUpdate();
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	/*
	public void update(Livro l){

		String sql = "UPDATE tb_contatos SET nome = ?, email = ?, telefone = ? WHERE id = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, l.getTituloLivro());
			stmt.setString(3, l.getTelefone());
			stmt.setInt(4, l.getId());
					
			stmt.executeUpdate();
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
	}
	*/
	public void delete(Integer idLivro){

		String sql = "DELETE FROM TB_LIVRO WHERE ID_LIVRO = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, idLivro);
			stmt.executeUpdate();
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
	}
	
	public List<Livro> getAll(){

		String sql = "SELECT ID_LIVRO"
						+ ", ISBN"
						+ ", TITULO"
						+ ", AUTOR"
						+ ", EDITORA"
						+ ", QTDE_PAGINAS"
						+ ", EDICAO"
						+ ", ANO_EDICAO"
						+ ", PRECO"
						+ ", IDIOMA"
						+ ", FOTO"
						+ ", SINOPSE"
						+ "FROM TB_LIVRO";
		
		List<Livro> livro = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			livro = new ArrayList<Livro>();
			
			while(rs.next()){
				Livro l = new Livro();
				l.setIdLivro(rs.getInt("ID_LIVRO"));
				l.setIsbnLivro(rs.getString("ISBN"));
				l.setTituloLivro(rs.getString("TITULO"));
				l.setAutorLivro(rs.getString("AUTOR"));
				l.setEditoraLivro(rs.getString("EDITORA"));
				
				livro.add(l);
			}
			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		
		return livro;
	}
	
	public List<Livro> getByNome(String nome){

		String sql = "SELECT id, nome, email, telefone FROM tb_contatos WHERE nome LIKE ? ORDER BY nome";
		
		List<Livro> contatos = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, '%' + nome + '%');
			
			ResultSet rs = stmt.executeQuery();

			contatos = new ArrayList<Livro>();
			
			while(rs.next()){
				Livro l = new Livro();
				l.setIdLivro(rs.getInt("id"));
				l.setTituloLivro(rs.getString("titulo"));

				
				contatos.add(l);
			}
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		return contatos;
	}

	
	public Livro getByPK(Integer id){

		String sql = "SELECT   TB_LIVRO.ID_LIVRO, "
							+ "TB_LIVRO.ISBN, "
							+ "TB_LIVRO.TITULO, "
							+ "TB_LIVRO.AUTOR, "
							+ "TB_LIVRO.EDITORA, "
							+ "TB_LIVRO.QTDE_PAGINAS, "
							+ "TB_LIVRO.EDICAO, "
							+ "TB_LIVRO.ANO_EDICAO,"
							+ "TB_LIVRO.PRECO, "
							+ "TB_LIVRO.IDIOMA, "
							+ "TB_LIVRO.FOTO, "
							+ "TB_LIVRO.SINOPSE, "
							+ "TB_CATEGORIA_LIVRO.NOME_CATEGORIA "
							+ "FROM TB_LIVRO, TB_CATEGORIA_LIVRO "
							+ "WHERE TB_LIVRO.ID_LIVRO = ? AND "
							+ "TB_LIVRO.TB_CATEGORIA_LIVRO_ID_CATEGORIA = TB_CATEGORIA_LIVRO.ID_CATEGORIA;";		
		Livro l = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);			
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next()){
				l = new Livro();
				l.setIdLivro(rs.getInt("ID_LIVRO"));
				l.setIsbnLivro(rs.getString("ISBN"));
				l.setTituloLivro(rs.getString("TITULO"));
				l.setAutorLivro(rs.getString("AUTOR"));
				l.setEditoraLivro(rs.getString("EDITORA"));
				l.setQtdePaginas(rs.getInt("QTDE_PAGINAS"));
				l.setEdicaoLivro(rs.getInt("EDICAO"));
				l.setAnoEdicaoLivro(rs.getInt("ANO_EDICAO"));
				l.setPrecoLivro(rs.getFloat("PRECO"));
				l.setIdiomaLivro(rs.getString("IDIOMA"));
				l.setFotoLivro(rs.getString("FOTO"));
				l.setSinopseLivro(rs.getString("SINOPSE"));
				l.setNomeCategoriaLivro(rs.getString("NOME_CATEGORIA"));
			}
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		return l;
	}
	
	public List<Livro> getFifty(){

		String sql = "SELECT ID_LIVRO, "
							+ "TITULO, "
							+ "PRECO, "
							+ "FOTO "
					+ "FROM TB_LIVRO "
					+ "WHERE ID_LIVRO <= ? ;";
		
		List<Livro> livro = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);			
			
			stmt.setInt(1, 50);
			
			ResultSet rs = stmt.executeQuery();
			
			livro = new ArrayList<Livro>();
			
			while(rs.next()){
				Livro l = new Livro();
				
				l.setIdLivro(rs.getInt("ID_LIVRO"));
				l.setTituloLivro(rs.getString("TITULO"));
				l.setPrecoLivro(rs.getFloat("PRECO"));
				l.setFotoLivro(rs.getString("FOTO"));
				
				livro.add(l);
			}
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		return livro;
	}
	
	public List<Livro> getByIdCategoria(Integer idCategoria){

		String sql = "SELECT ID_LIVRO, "
							+ "TITULO, "
							+ "PRECO, "
							+ "FOTO "
					+ "FROM TB_LIVRO "
					+ "WHERE ID_LIVRO <= ? AND "
					+ "TB_CATEGORIA_LIVRO_ID_CATEGORIA = ?;";
		
		List<Livro> livro = null;
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);			
			
			stmt.setInt(1, 50);
			stmt.setInt(2, idCategoria);
			
			ResultSet rs = stmt.executeQuery();
			
			livro = new ArrayList<Livro>();
			
			while(rs.next()){
				Livro l = new Livro();
				
				l.setIdLivro(rs.getInt("ID_LIVRO"));
				l.setTituloLivro(rs.getString("TITULO"));
				l.setPrecoLivro(rs.getFloat("PRECO"));
				l.setFotoLivro(rs.getString("FOTO"));
				
				livro.add(l);
			}
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		return livro;
	}
}
