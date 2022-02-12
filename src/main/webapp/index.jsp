<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Lista de Veiculos </title>

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-warning">
        <div class="container-fluid">
            <a class="navbar-brand" style="margin-right:1000px; " href="index.jsp">Lista de Carros </a>
              <a class="nav-item" style="text-decoration: none; color:white; font-size: 1.25rem;" href="ipva.jsp">Lista de IPVA </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">

            </div>
        </div>
    </nav>
    
	<div class="container mt-5 col-10" style="outline: 1px solid #d5d5d5;
			border-radius: 11px; padding: 16px;">
       
      <table class="table table-hover">
                <thead>
                    <tr>
                        <th class="col-1">#</th>
                        <th class="col-1">Modelo</th>
                        <th class="col-1">Ano</th>
                        <th class="col-2">IPVA</th>
                        <th  class="col-4">Funcionalidades</th>
                    </tr>
                </thead>
                <tbody>
                <form action="ServletCrud" method="post">
		<button class="btn btn-secondary col-2" style=" margin-bottom: 35px;font-weight: bold;" type="submit"  name="option" value="insertForm"> Adicionar veiculo</button>
		          <div class="container"><h5>Qtd de Carros Cadastrados:</h5></div>
	</form>
                
                    <c:forEach var="carroForEach" items="${itemsVeiculo}">
                        <tr>
                            
                            <form action="ServletCrud" method="post">
                                <td class="col-1">
                                    <c:out value="${carroForEach.idcarro}"/>
                                    <input type="hidden" name="carroID" value="${carroForEach.idcarro}"/>
                                </td>
                                <td class="col-2"><c:out value="${carroForEach.modelo}"/></td>
                                <td class="col-1"><c:out value="${carroForEach.ano}"/></td>
                                <td class="col-1"></td>
                                <td class="col-3">
                                
							     <div class="row" style="justify-content: space-evenly;margin-bottom:10px;">
							    <button  class="btn btn-secondary col-3" style="font-weight: bold;" type="submit" name="option" value="delete">Deletar</button>
							    <button class ="btn btn-secondary col-3" style="font-weight: bold;  "type="submit" name="option" value="updateForm">Atualizar</button> 
							    </div>
						
							</td>
                            </form>
                        </tr>
                    </c:forEach>
                </tbody>
              </table>
              </div>
              
              
</body>
</html>