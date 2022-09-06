package br.com.BooksBuy.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex){}
		
		String server   = "localhost";
		String database = "fiap";
		
		String url  = "jdbc:mysql://" + server + "/" + database;
		String user = "root";
		String key  = "fiap";
		
		Connection conn = DriverManager.getConnection(url, user, key);
		
		return conn;
	}
}
