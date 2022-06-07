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
	    <h1>Listagem de Clientes</h1>
	    <a href="sistema?logica=NovoCliente" class="btn btn-primary">Novo</a>
		<table class="table table-bordered table-striped table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nome</th>
		      <th scope="col">Email</th>
		      <th scope="col">Fone</th>
		      <th scope="col">Endereço</th>
		      <th scope="col">Cidade</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach items="${clientes}" var="cliente">
			    <tr>
			      <th scope="row">${cliente.id}</th>
			      <td>${cliente.nome}</td>
			      <td>${cliente.email}</td>
			      <td>${cliente.fone}</td>
			      <td>${cliente.endereco}</td>
			      <td>${cliente.cidade.descricao}-${cliente.cidade.uf}</td>
			      <td>
			      	<a href="sistema?logica=EditarCliente&id=${cliente.id}" class="btn btn-primary">+</a>
			      	<a href="sistema?logica=ExcluirCliente&id=${cliente.id}" class="btn btn-danger">-</a>
			      </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>    
  	
  	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>