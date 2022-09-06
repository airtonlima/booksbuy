package br.com.BooksBuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.BooksBuy.bean.Cliente;
import br.com.BooksBuy.bean.LoginRoot;
import br.com.BooksBuy.factory.ConnectionFactory;

public class ClienteDAO {
	
	Connection conn = null;
	
	public ClienteDAO(){
		try{
			conn = ConnectionFactory.getConnection();
		}catch(SQLException ex){}
	}
	
	public void insert(Cliente c){
		

		
		String sql = "INSERT INTO TB_CLIENTE ("
							+ "CPF_CLIENTE,"
							+ "NOME_COMPLETO,"
							+ "EMAIL,"
							+ "DATA_NASCIMENTO,"
							+ "SEXO,"
							+ "CELULAR,"
							+ "TELEFONE_FIXO,"
							+ "USUARIO,"
							+ "SENHA) "
							+ "VALUES(?,?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, c.getCpfCliente());
			stmt.setString(2, c.getNomeCompleto());
			stmt.setString(3, c.getEmailCliente());
			stmt.setString(4, c.getDataNascCliente());
			stmt.setString(5, c.getSexoCliente());
			stmt.setString(6, c.getCelularCliente());
			stmt.setString(7, c.getTelefoneCliente());
			stmt.setString(8, c.getUsuarioCliente());
			stmt.setString(9, c.getSenhaCliente());
			
			stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}
}
