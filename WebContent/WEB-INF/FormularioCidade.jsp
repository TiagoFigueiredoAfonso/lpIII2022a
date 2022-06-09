<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<tags:template>
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
</tags:template>