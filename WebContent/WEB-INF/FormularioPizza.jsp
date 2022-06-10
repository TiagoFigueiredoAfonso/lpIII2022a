<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<tags:template>
<c:if test = "${!empty cliente.foto}">
      <img src="imagens/${cliente.foto}" style="width: 200px">
</c:if>
<h1 style="color:green">Formulário de Pizza</h1>
	<form action="sistema?logica=SalvarPizza" method="post" enctype="multipart/form-data">
	<input type="hidden" class="form-control" id="foto" name="foto" value="${pizza.foto}">
	   <div class="mb-3">
	    <label for="id" class="form-label">Foto</label>
	    <input type="file" class="form-control" id="arquivo" name="arquivo">
	  </div>
	  <div class="mb-3">
	    <label for="id" class="form-label">Id</label>
	    <input readonly type="text" class="form-control" id="id" name="id" value="${pizza.id}">
	  </div>
	  <div class="mb-3">
	    <label for="nome" class="form-label">Nome</label>
	    <input type="text" class="form-control" id="nome" name="nome" value="${pizza.nome}">
	  </div>
	  
	  <div class="mb-3">
	    <label for="categoria_id" class="form-label">Categoria</label>
		<select class="form-select" name="categoria_id" id="categoria_id">
		    <c:forEach items="${categorias}" var="categoria">
		    	<option ${categoria.id==pizza.categoria.id ? 'selected' : ''} value="${categoria.id}">${categoria.nome}</option>
		    </c:forEach>
		</select>
	  </div>
	   <div class="mb-3">
	    <label for="data" class="form-label">Data</label>
	    <input type="date" class="form-control" id="data" name="data" value="${pizza.data}" >
	  </div>	 
	  <button type="submit" class="btn btn-outline-primary">Salvar</button>
	</form>
		    
 </tags:template> 