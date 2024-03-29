<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<tags:template>
<h1 style="color:green;">Listagem de Pizzas</h1>
	    
		<table class="table table-bordered table-striped table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Imagem</th>
		      <th scope="col">Nome</th>	
		      <th scope="col">Categoria</th>
		      <th scope="col">Data</th>	
		     		      
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach items="${pizzas}" var="pizza">
			    <tr>
			      <th scope="row">${pizza.id}</th>
			      <td>
			  <c:if test = "${!empty pizza.foto}">
			      <img src="imagens/${pizza.foto}" style="width: 60px">
			  </c:if>  
		      
		      </td>
			      <td style="color:red">${pizza.nome}</td>
			      		      
			      <td style="color:red">${pizza.categoria.nome}</td>
			      <td style="color:red">
			      <tags:localDate date="${pizza.data}" />
			      </td>
			      <td>
			      	<a href="sistema?logica=EditarPizza&id=${pizza.id}" class="btn btn-primary">+</a>
			      	<a href="sistema?logica=ExcluirPizza&id=${pizza.id}" class="btn btn-danger">-</a>
			      </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table> 
		<a href="sistema?logica=NovoPizza" class="btn btn-outline-primary">Novo</a> 
</tags:template>  