<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    

<tags:template>
    <h1 style="color:green">Login</h1>
	<form action="sistema?logica=Logar" method="post">
	  <div class="mb-3">
	    <label for="email" class="form-label">E-mail</label>
	    <input type="email" class="form-control" id="email" name="email">
	  </div>
	  <div class="mb-3">
	    <label for="password" class="form-label">Senha</label>
	    <input type="password" class="form-control" id="password" name="password">
	  </div>
	  <button type="submit" class="btn btn-primary">Entrar</button>
	</form>	    
</tags:template>