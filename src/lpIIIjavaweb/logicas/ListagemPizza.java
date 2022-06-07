package lpIIIjavaweb.logicas;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.PizzaDao;
import lpIIIjavaweb.models.Pizza;

public class ListagemPizza implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PizzaDao dao = new PizzaDao();
		List<Pizza> pizzas = dao.getAll();
		request.setAttribute("pizzas", pizzas);
		return "/WEB-INF/ListagemPizza.jsp";
	}

}