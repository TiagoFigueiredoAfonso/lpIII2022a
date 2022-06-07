package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Cliente;

public class SalvarCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String fone = request.getParameter("fone");
		String endereco = request.getParameter("endereco");
		int cidade_id = Integer.parseInt(request.getParameter("cidade_id"));
		CidadeDao cidadeDao = new CidadeDao();
		Cidade cidade = cidadeDao.get(cidade_id);
		Cliente cliente = new Cliente(id, nome, email, fone, endereco, cidade);
		ClienteDao dao = new ClienteDao();
		if (id==0) {
		  dao.save(cliente);
		} else {
		  dao.update(cliente);
		}
		return "/sistema?logica=ListagemCliente";
	}

}
