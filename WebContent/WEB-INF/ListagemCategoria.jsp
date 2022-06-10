<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<tags:template>
<h1 style="color:green;">Listagem de Categorias</h1>
		
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
			      <td style="color:red">${categoria.nome}</td>     
			      
			      <td>			      
			      	<a href="sistema?logica=EditarCategoria&id=${categoria.id}" class="btn btn-primary">+</a>
			      	<a href="sistema?logica=ExcluirCategoria&id=${categoria.id}" class="btn btn-danger">-</a>
			      </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>   
		<a href="sistema?logica=NovoCategoria" class="btn btn-outline-primary">Novo</a>
</tags:template>