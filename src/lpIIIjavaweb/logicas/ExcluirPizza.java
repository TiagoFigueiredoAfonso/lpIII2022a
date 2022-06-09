package lpIIIjavaweb.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.PizzaDao;
import lpIIIjavaweb.models.Pizza;

public class ExcluirPizza implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = (Connection) request.getAttribute("conn");
		Pizza pizza = new Pizza(id, "", null, null);
		PizzaDao dao = new PizzaDao(conn);
		dao.delete(pizza);
		return "sistema?logica=ListagemPizza";
	}

}