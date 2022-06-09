package lpIIIjavaweb.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.models.Categoria;

public class ListagemCategoria implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("conn");
		CategoriaDao dao = new CategoriaDao(conn);
		List<Categoria> categorias = dao.getAll();
		request.setAttribute("categorias", categorias);
		return "/WEB-INF/ListagemCategoria.jsp";
	}

}