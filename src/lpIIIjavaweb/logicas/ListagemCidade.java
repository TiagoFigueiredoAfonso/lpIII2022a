package lpIIIjavaweb.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.models.Cidade;

public class ListagemCidade implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("conn");
		CidadeDao dao = new CidadeDao(conn);
		List<Cidade> cidades = dao.getAll();
		request.setAttribute("cidades", cidades);
		return "/WEB-INF/ListagemCidade.jsp";
	}

}
