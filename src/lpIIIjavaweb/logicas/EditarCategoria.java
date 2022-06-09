package lpIIIjavaweb.logicas;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.models.Categoria;

public class EditarCategoria implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = (Connection) request.getAttribute("conn");
		CategoriaDao dao = new CategoriaDao(conn);
		Categoria categoria = dao.get(id);
		request.setAttribute("categoria", categoria);
		return "/WEB-INF/FormularioCategoria.jsp";
	}

}