package br.com.agenda.contato;

/*PROGRAMA AGENDACONTATO
Programa que inclui, altera, remove e pesquisa o nome de pessoas, 
usando Servlets e  anotaçao @WebServlet, 
foi usado também o banco de dados PostgreSQL(Tabela contatos).
*/
 public class Contato {
	
	private int id;
	private String nome;
	private String email;
	private String endereco;
	private String dataNascimento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	
	

}
