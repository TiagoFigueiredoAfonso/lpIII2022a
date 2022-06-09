package lpIIIjavaweb.logicas;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.daos.PizzaDao;
import lpIIIjavaweb.models.Categoria;
import lpIIIjavaweb.models.Pizza;

public class SalvarPizza implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");		
		int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
		CategoriaDao categoriaDao = new CategoriaDao();
		Categoria categoria = categoriaDao.get(categoria_id);
		
		LocalDate data = null;
		if (request.getParameter("data") != null) {
  		  data = LocalDate.parse(request.getParameter("data"));
		}  
		System.out.println("request: "+request.getParameter("data"));	
		System.out.println("data: "+data);	
		
		Pizza pizza = new Pizza(id, nome, categoria, data);
		PizzaDao dao = new PizzaDao();
		if (id==0) {
		  dao.save(pizza);
		} else {
		  dao.update(pizza);
		}
		return "/sistema?logica=ListagemPizza";
	}

}