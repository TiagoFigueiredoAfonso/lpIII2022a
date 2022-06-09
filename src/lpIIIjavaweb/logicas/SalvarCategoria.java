package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.models.Categoria;

public class SalvarCategoria implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");		
		Categoria categoria = new Categoria(id, nome);
		CategoriaDao dao = new CategoriaDao();
		if (id==0) {
		  dao.save(categoria);
		} else {
		  dao.update(categoria);
		}
		return "/sistema?logica=ListagemCategoria";
	}

}
