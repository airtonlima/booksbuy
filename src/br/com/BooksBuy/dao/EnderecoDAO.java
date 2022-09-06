package br.com.BooksBuy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.BooksBuy.bean.Cliente;
import br.com.BooksBuy.bean.Endereco;
import br.com.BooksBuy.factory.ConnectionFactory;

public class EnderecoDAO {
	
	Connection conn = null;

	public EnderecoDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch (SQLException ex){}
	}
	
	public void insert(Endereco e, Cliente c){
		
		
		String sqlFK = "SELECT CPF_CLIENTE FROM TB_CLIENTE WHERE CPF_CLIENTE = ?";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sqlFK);			
			
			stmt.setString(1, c.getCpfCliente());
			
			ResultSet rs = stmt.executeQuery();

			if(rs.next())
				e.setCpfClienteTbCliente(rs.getString("CPF_CLIENTE"));			
		}
		catch(SQLException ex){ 
			ex.printStackTrace();
		}
				
		String sql = "INSERT INTO TB_ENDERECO ("
								+ "LOGRADOURO,"
								+ "NUMERO_RESID,"
								+ "CEP,"
								+ "BAIRRO,"
								+ "COMPLEMENTO,"
								+ "MUNICIPIO,"
								+ "ESTADO,"
								+ "TB_CLIENTE_CPF_CLIENTE) "
								+ "VALUES(?,?,?,?,?,?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
						
			stmt.setString(1, e.getLogradouroEndereco());
			stmt.setString(2, e.getNumeroResidenciaEndereco());
			stmt.setString(3, e.getCepEndereco());
			stmt.setString(4, e.getBairroEndereco());
			stmt.setString(5, e.getComplementoEndereco());
			stmt.setString(6, e.getMunicipioEndereco());
			stmt.setString(7, e.getEstadoEndereco());
			stmt.setString(8, e.getCpfClienteTbCliente());
			
			stmt.executeUpdate();
			
		}catch(SQLException ex){
			ex.printStackTrace();
		}		
	}
	
	
}

