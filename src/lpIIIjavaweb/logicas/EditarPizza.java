package lpIIIjavaweb.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.daos.PizzaDao;
import lpIIIjavaweb.models.Categoria;
import lpIIIjavaweb.models.Pizza;

public class EditarPizza implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = (Connection) request.getAttribute("conn");
		PizzaDao dao = new PizzaDao(conn);
		Pizza pizza = dao.get(id);
		request.setAttribute("pizza", pizza);
		CategoriaDao categoriaDao = new CategoriaDao(conn);
		List<Categoria> categorias = categoriaDao.getAll();
		request.setAttribute("categorias", categorias);
		
		return "/WEB-INF/FormularioPizza.jsp";
	}

}
