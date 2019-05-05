 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 
</head>
<body>
    <!--Cria o DAO -->
    <jsp:useBean id="dao" class="br.com.agenda.dao.ContatoDao"/> 
    <table>
         <!-- percorre contatos montando as linhas da tabela-->
         <c:forEach var = "contato" items="${dao.lista}">
         <tr>
             <td>${contato.nome }</td>
             <td>${contato.email }</td>
             <td>${contato.endereco }</td>
             <td>${contato.dataNascimento }</td>
         </tr>
            
         </c:forEach>
         <c:forEach var="contato" items="${dao.lista}">
<tr>
<td>${contato.nome}</td>
<td>
<c:if test="${not empty contato.email}">
<a href="mailto:${contato.email}">${contato.email}</a>
</c:if>
<c:if test="${empty contato.email }">
       Email não informado
</c:if>    
</td>
<td>${contato.endereco}</td>
<td>${contato.dataNascimento}</td>
</tr>
</c:forEach>
    
    </table>
</body>
</html>