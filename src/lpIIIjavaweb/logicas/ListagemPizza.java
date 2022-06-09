package lpIIIjavaweb.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.PizzaDao;
import lpIIIjavaweb.models.Pizza;

public class ListagemPizza implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("conn");
		PizzaDao dao = new PizzaDao(conn);
		List<Pizza> pizzas = dao.getAll();
		request.setAttribute("pizzas", pizzas);
		return "/WEB-INF/ListagemPizza.jsp";
	}

}