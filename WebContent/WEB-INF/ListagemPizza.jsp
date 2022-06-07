<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <title>Clientes</title>
  </head>
  <body>
  	<div class="container">
	    <h1>Listagem de Pizzas</h1>
	    <a href="sistema?logica=NovoPizza" class="btn btn-primary">Novo</a>
		<table class="table table-bordered table-striped table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nome</th>	
		      <th scope="col">Categoria</th>	
		     		      
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach items="${pizzas}" var="pizza">
			    <tr>
			      <th scope="row">${pizza.id}</th>
			      <td>${pizza.nome}</td>
			      		      
			      <td>${pizza.categoria.nome}</td>
			      <td>
			      	<a href="sistema?logica=EditarPizza&id=${pizza.id}" class="btn btn-primary">+</a>
			      	<a href="sistema?logica=ExcluirPizza&id=${pizza.id}" class="btn btn-danger">-</a>
			      </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>    
  	
  	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>