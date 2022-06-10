<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pizzaria</title>
    <!-- Bootstrap core CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta name="theme-color" content="#7952b3">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Anton&display=swap" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
      
	body {
	  min-height: 75rem;
	  padding-top: 4.5rem;
	  background-image: url(https://images.pexels.com/photos/3944307/pexels-photo-3944307.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1);
	  background-size: 100%;
	}
	table {
				background-color: rgba(113, 214, 120, 0.8);
				
			}
			th, tr, thead,tbody {
				color: white;
			}
			h1 {
				font-family: 'Anton', sans-serif;
				text-shadow: 1px 3px red;
				text-align: center;
			}
			label {
			color: red;
			text-shadow: 1px 1px black;
		}      
    </style>
    
  </head>
  <body>
    
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-success">
  <div class="container-fluid">
    <a class="navbar-brand" href="sistema?logica=Index"><img width="40px" src="https://i.pinimg.com/originals/d0/f2/76/d0f276d5e726c409518a99c065edafd6.png"/></a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarCollapse">
      <ul style="color:white" class="navbar-nav me-auto mb-2 mb-md-0" >
      <c:if test = "${!empty usuarioLogado}">       
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="sistema?logica=ListagemPizza">Pizza</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="sistema?logica=ListagemCategoria">Categoria</a>
        </li>
         <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="sistema?logica=Logout">Sair</a>
	        </li>
         </c:if>  
          <c:if test = "${empty usuarioLogado}">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="sistema?logica=Login">Entrar</a>
	        </li>
		  </c:if>  
      </ul>
    </div>
  </div>
</nav>

<main class="container">
  <c:if test = "${!empty usuarioLogado}">
         <p style="color:white;text-shadow:2px 2px 2px black;">Usuário: ${usuarioLogado.email}<p>
  </c:if>  
  <div class=" bg-light p-5 rounded">

  	<jsp:doBody/>

  </div>
</main>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
      
  </body>
</html>
