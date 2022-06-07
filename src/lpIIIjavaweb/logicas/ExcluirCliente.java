package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cliente;

public class ExcluirCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = new Cliente(id, "", "", "", "", null);
		ClienteDao dao = new ClienteDao();
		dao.delete(cliente);
		return "sistema?logica=ListagemCliente";
	}

}
