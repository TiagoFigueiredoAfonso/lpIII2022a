package lpIIIjavaweb.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cliente;

public class ListagemCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("conn");
		ClienteDao dao = new ClienteDao(conn);
		List<Cliente> clientes = dao.getAll();
		request.setAttribute("clientes", clientes);
		return "/WEB-INF/ListagemCliente.jsp";
	}

}
