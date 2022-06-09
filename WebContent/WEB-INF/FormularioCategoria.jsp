<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<tags:template>
<h1>Formulário de Categoria</h1>
	<form action="sistema?logica=SalvarCategoria" method="post">
	  <div class="mb-3">
	    <label for="id" class="form-label">Id</label>
	    <input readonly type="text" class="form-control" id="id" name="id" value="${categoria.id}">
	  </div>
	  <div class="mb-3">
	    <label for="nome" class="form-label">Nome</label>
	    <input type="text" class="form-control" id="nome" name="nome" value="${categoria.nome}">
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Salvar</button>
	</form>	    
</tags:template>	