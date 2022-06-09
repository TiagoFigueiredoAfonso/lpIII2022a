<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<tags:template>
<h1>Formulário de Cliente</h1>
	<form action="sistema?logica=SalvarCliente" method="post">
	  <div class="mb-3">
	    <label for="id" class="form-label">Id</label>
	    <input readonly type="text" class="form-control" id="id" name="id" value="${cliente.id}">
	  </div>
	  <div class="mb-3">
	    <label for="nome" class="form-label">Nome</label>
	    <input type="text" class="form-control" id="nome" name="nome" value="${cliente.nome}">
	  </div>
	  <div class="mb-3">
	    <label for="email" class="form-label">Email</label>
	    <input type="email" class="form-control" id="email" name="email" value="${cliente.email}" >
	  </div>
	  <div class="mb-3">
	    <label for="fone" class="form-label">Telefone</label>
	    <input type="text" class="form-control" id="fone" name="fone" value="${cliente.fone}">
	  </div>
	  <div class="mb-3">
	    <label for="endereco" class="form-label">Endereço</label>
	    <input type="text" class="form-control" id="endereco" name="endereco"  value="${cliente.endereco}">
	  </div>
	  <div class="mb-3">
	    <label for="data_nascimento" class="form-label">Data Nascimento</label>
	    <input type="date" class="form-control" id="data_aniversario" name="data_aniversario" value="${cliente.data_nascimento}" >
	  </div>
	  <div class="mb-3">
	    <label for="cidade_id" class="form-label">Cidade</label>
		<select class="form-select" name="cidade_id" id="cidade_id">
		    <c:forEach items="${cidades}" var="cidade">
		    	<option ${cidade.id==cliente.cidade.id ? 'selected' : ''} value="${cidade.id}">${cidade.descricao}-${cidade.uf}</option>
		    </c:forEach>
		</select>
	  </div>	 

	  <button type="submit" class="btn btn-primary">Salvar</button>
	</form>	
</tags:template> 