package lpIIIjavaweb.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.models.Categoria;

public class NovoCategoria implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Categoria categoria = new Categoria(0, "");
		request.setAttribute("categoria", categoria);
		return "/WEB-INF/FormularioCategoria.jsp";
	}

}