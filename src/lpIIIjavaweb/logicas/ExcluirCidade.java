package lpIIIjavaweb.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.models.Cidade;

public class ExcluirCidade implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("conn");
		CidadeDao dao = new CidadeDao(conn);
		int id = Integer.parseInt(request.getParameter("id"));
		Cidade cidade = new Cidade(id, "", "");
		dao.delete(cidade);
		return "sistema?logica=ListagemCidade";
	}

}
