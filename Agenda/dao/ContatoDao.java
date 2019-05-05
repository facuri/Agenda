package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.contato.Contato;
import br.com.agenda.factory.ConnectionFactory;

public class ContatoDao {
	
	Connection con = null;
	private Connection connection;
	
	public ContatoDao(){
		this.connection = new ConnectionFactory().getConnection();
	}
	public void adiciona(Contato contato){
		String sql = "insert into contatos(nome, email, endereco, datanascimento)values(?, ?, ?, ?)";
		try{
			 PreparedStatement stmt = connection.prepareStatement(sql);
			 stmt.setString(1, contato.getNome());
			 stmt.setString(2, contato.getEmail());
			 stmt.setString(3, contato.getEndereco());
			 stmt.setString(4, contato.getDataNascimento());
			 
			 stmt.execute();
			 stmt.close();
		}catch(SQLException e){
			throw new RuntimeException();
			
		}
	}
	public void altera(Contato contato){
		String sql = "update contatos  set nome = ?, email = ?, endereco = ?," + 
				     "datanascimento = ? where id = ? ";
		try{
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setString(4, contato.getDataNascimento());
			stmt.setInt(5, contato.getId());
			stmt.execute();
			stmt.close();
			
		}catch(SQLException e){
			throw new RuntimeException();
			
		}
		
	}
	public void remove(Contato contato){
		try{
			PreparedStatement stmt = connection.prepareStatement("delete from contatos where id = ?");
			stmt.setInt(1, contato.getId());
			stmt.execute();
			stmt.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
			
		}
		
	}
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Contanto
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setDataNascimento(rs.getString("dataNascimento"));

				// adicionando o objeto à lista
				contatos.add(contato);

			}
			 
          return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
	public void pesquisar() throws SQLException {
		// pega a conexão e o Statement
		PreparedStatement stmt = con.prepareStatement("select * from contatos");
		// executa um select
		ResultSet rs = stmt.executeQuery();
		// itera no ResultSet
		while (rs.next()) {
		}
		rs.close();
		stmt.close();
		con.close();
	}
 

}
