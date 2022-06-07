<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
    <title>Categorias</title>
  </head>
  <body>
  	<div class="container mt-5">
	    <h1 style="color:blue;">Listagem de Categorias</h1>
		<table class="table table-bordered table-striped table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nome</th>		  
		      <th scope="col">Editar</th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach items="${categorias}" var="categoria">
			    <tr>
			      <th scope="row">${categoria.id}</th>
			      <td>${categoria.nome}</td>     
			      
			      <td>			      
			      	<a href="sistema?logica=EditarCategoria&id=${categoria.id}" class="btn btn-primary">+</a>
			      	<a href="sistema?logica=ExcluirCategoria&id=${categoria.id}" class="btn btn-danger">-</a>
			      </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>   
		<a href="novoCategoria?id=${categoria.id}" class="btn btn-primary">Novo</a> 
  	
  	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>