<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>  

<html>
<head>
<meta charset="ISO-8859-1">
<title> Lista de Veiculos  </title>

<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-warning ">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">Lista de Carros</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">

            </div>
        </div>
    </nav>

     
        
       
   
            <form action="ServletCrud" method="post">



         <c:choose>
			<c:when test="${ carro == null }">
			
			<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5;
			border-radius: 11px; padding: 16px;">
			<div class="row justify-content-center">
             <h1 class=c>Adicionar Veiculo</h1>
             
             
             <div class="mb-3">
				<label for="exampleInput" class="form-label">Modelo:</label>
				<input class="form-control" type="text" name="modeloDocarro" required/>
				</div>
				
				<div class="mb-3">
				<label for="exampleInput" class="form-label">Ano:</label>
				<input class="form-control" type="text" name="anoDoCarro"/>
				</div>
				
				<div class="mb-3">
				<button  class="btn btn-secondary" type="submit" name="option" value="insert">Salvar </button>
				</div>
				</div>
				</div>
			
			</c:when>
			<c:otherwise>
			
			<div class="container mt-5 col-6" style="outline: 1px solid #d5d5d5;
			border-radius: 11px; padding: 16px;">
			<div class="row justify-content-center">
             <h1 class=c>Atualizar Veiculo</h1>
             
             
             <div class="mb-3">
				<label for="exampleInput" class="form-label">Modelo:</label>
				<input class="form-control" type="text" name="modeloDocarro" required/>
				</div>
				
				<div class="mb-3">
				<label for="exampleInput" class="form-label">Ano:</label>
				<input class="form-control" type="text" name="anoDoCarro"/>
				</div>
				
				<div class="mb-3">
				<button  class="btn btn-secondary" type="submit" name="option" value="update"> Atualizar </button>
				</div>
				</div>
				</div>
			</c:otherwise>
		</c:choose>
            </form>
        </div>
</body>

</html>