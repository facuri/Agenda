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

@WebServlet("/AdicionaContatoServletRemove")
public class AdicionaContatoServletRemove extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		  //busca o writer
		  PrintWriter out = response.getWriter();
		  
		  //buscando os parâmetros no request
		  String id = request.getParameter("id");
		  Contato contato = new Contato();
		  contato.setId(Integer.parseInt(id));
		   
		  
		  ContatoDao dao = new ContatoDao();
		  dao.remove(contato);
		  
		  out.println("<html>");
		  out.println("<body>");
		  out.println("Contato " + contato.getId() +  " removido com sucesso");
		  out.println("</body>");
		  out.println("</html>");
		 
		 
	}

}
