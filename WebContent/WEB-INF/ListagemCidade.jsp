<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<tags:template>
	<h1 class="mt-5">Listagem de Cidades</h1>
	    <a href="sistema?logica=NovaCidade" class="btn btn-primary">Novo</a>
		<table class="table table-bordered table-striped table-hover">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Descrição</th>
		      <th scope="col">UF</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
			<c:forEach items="${cidades}" var="cidade">
			    <tr>
			      <th scope="row">${cidade.id}</th>
			      <td>${cidade.descricao}</td>
			      <td>${cidade.uf}</td>
			      <td>
			      	<a href="sistema?logica=EditarCidade&id=${cidade.id}" class="btn btn-primary">+</a>
			      	<a href="sistema?logica=ExcluirCidade&id=${cidade.id}" class="btn btn-danger">-</a>
			      </td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>   
</tags:template> 