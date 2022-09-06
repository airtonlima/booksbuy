package br.com.BooksBuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.BooksBuy.bean.LoginRoot;
import br.com.BooksBuy.factory.ConnectionFactory;

public class LoginDAO {

	Connection conn = null;
	
	public LoginDAO(){
		
		try{
			conn = ConnectionFactory.getConnection();
		}
		catch(SQLException ex){ }
	}
	
	public boolean login(LoginRoot l){

		String sql = "SELECT "
				+ ", USUARIO"
				+ ", SENHA"
				+ ", ROOT"
				+ "FROM TB_LOGIN "
				+ "WHERE usuario = ? and senha = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, l.getUsernameUsuario());
			stmt.setString(2, l.getSenhaUsuario());
					
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				return true;

		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean verificaRoot(boolean root){

		String sql = "SELECT * FROM tb_login WHERE root = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setBoolean(1, root);
					
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
				return true;
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
		return false;
	}
	
	public void insert(LoginRoot l){
			
			// `TB_LOGIN_ID_USUARIO` INT NOT NULL,
			
			String sql = "INSERT INTO TB_LOGIN ("
								+ "USUARIO,"
								+ "SENHA,"
								+ "VALUES(?,?)";
			
			try{
				PreparedStatement stmt = conn.prepareStatement(sql);
				
				stmt.setString(1, l.getUsernameUsuario());
				stmt.setString(2, l.getSenhaUsuario());
				
				
				stmt.executeUpdate();
				
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}

}
