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
	    <h1>Formulário de Cidade</h1>
	<form action="sistema?logica=SalvarCidade" method="post">
	  <div class="mb-3">
	    <label for="id" class="form-label">Id</label>
	    <input readonly type="text" class="form-control" id="id" name="id" value="${cidade.id}">
	  </div>
	  <div class="mb-3">
	    <label for="descricao" class="form-label">Descrição</label>
	    <input type="text" class="form-control" id="descricao" name="descricao" value="${cidade.descricao}">
	  </div>
	  <div class="mb-3">
	    <label for="uf" class="form-label">UF</label>
	    <input type="text" class="form-control" id="uf" name="uf" value="${cidade.uf}" >
	  </div>
	  <button type="submit" class="btn btn-primary">Salvar</button>
	</form>	    
  	
  	</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  </body>
</html>