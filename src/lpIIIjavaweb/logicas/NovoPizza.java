package lpIIIjavaweb.logicas;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.models.Categoria;
import lpIIIjavaweb.models.Pizza;

public class NovoPizza implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Pizza pizza= new Pizza(0, "", null);
		request.setAttribute("pizza", pizza);
		CategoriaDao categoriaDao = new CategoriaDao();
		List<Categoria> categorias = categoriaDao.getAll();
		request.setAttribute("categorias", categorias);
		return "/WEB-INF/FormularioPizza.jsp";
	}

}

