package lpIIIjavaweb.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cliente;

public class ExcluirCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = (Connection) request.getAttribute("conn");
		Cliente cliente = new Cliente(id, "", "", "", "", null, null);
		ClienteDao dao = new ClienteDao(conn);
		dao.delete(cliente);
		return "sistema?logica=ListagemCliente";
	}

}
