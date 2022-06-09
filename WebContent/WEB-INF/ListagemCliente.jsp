<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<tags:template>
   <h1 class="mt-5">Listagem de Clientes</h1>
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
</tags:template>
