package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	    String driver = "org.postgresql.Driver";
	    private String url = "jdbc:postgresql://localhost/bd_fj21";
		private String usuario = "postgres";
		private String senha = "1234";
	
	public Connection getConnection(){
		try{
			return DriverManager.getConnection(url, usuario, senha);
		}catch (SQLException e) {
			throw new RuntimeException(e);
			 
		}
		
	}

}
