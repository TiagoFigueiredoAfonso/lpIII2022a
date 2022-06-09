package lpIIIjavaweb.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.models.Categoria;

public class SalvarCategoria implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = (Connection) request.getAttribute("conn");
		String nome = request.getParameter("nome");		
		Categoria categoria = new Categoria(id, nome);
		CategoriaDao dao = new CategoriaDao(conn);
		if (id==0) {
		  dao.save(categoria);
		} else {
		  dao.update(categoria);
		}
		return "/sistema?logica=ListagemCategoria";
	}

}
