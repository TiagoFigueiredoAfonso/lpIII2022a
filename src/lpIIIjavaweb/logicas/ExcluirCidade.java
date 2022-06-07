package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.models.Cidade;

public class ExcluirCidade implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CidadeDao dao = new CidadeDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Cidade cidade = new Cidade(id, "", "");
		dao.delete(cidade);
		return "sistema?logica=ListagemCidade";
	}

}
