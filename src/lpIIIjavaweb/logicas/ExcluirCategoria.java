package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.models.Categoria;

public class ExcluirCategoria implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		CategoriaDao dao = new CategoriaDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Categoria categoria = new Categoria(id, "");		
		dao.delete(categoria);
		return "sistema?logica=ListagemCategoria";
	}

}
