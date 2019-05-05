package br.com.br.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.contato.Contato;
import br.com.agenda.dao.ContatoDao;

@WebServlet("/AdicionaContatoServlet") 
public class AdicionaContatoServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 //busca o writer
		  PrintWriter out = response.getWriter();
		  
		  //buscando os parâmetros no request
		  String nome = request.getParameter("nome");
		  String email = request.getParameter("email");
		  String endereco = request.getParameter("endereco");
		  String dataNascimento = request.getParameter("dataNascimento");
		  
		  //monta um objeto contato
		  Contato contato = new Contato();
		  contato.setNome(nome);
		  contato.setEmail(email);
		  contato.setEndereco(endereco);
		  contato.setDataNascimento(dataNascimento);
		  
		  ContatoDao dao = new ContatoDao();
		  dao.adiciona(contato);
		  
		  out.println("<html>");
		  out.println("<body>");
		  out.println("Contato " + contato.getNome() + 
				      " adicionado com sucesso");
		  out.println("</body>");
		  out.println("</html>");
		  
		 
		 
	}

}
