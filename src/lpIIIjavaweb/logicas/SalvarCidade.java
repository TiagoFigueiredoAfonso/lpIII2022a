package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.models.Cidade;

public class SalvarCidade implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String descricao = request.getParameter("descricao");
		String uf = request.getParameter("uf");
		Cidade cidade = new Cidade(id, descricao, uf);
		CidadeDao dao = new CidadeDao();
		if (id==0) {
		  dao.save(cidade);
		} else {
		  dao.update(cidade);
		}
		return "/sistema?logica=ListagemCidade";
	}

}
