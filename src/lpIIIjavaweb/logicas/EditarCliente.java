package lpIIIjavaweb.logicas;

import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Cliente;

public class EditarCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		Connection conn = (Connection) request.getAttribute("conn");
		ClienteDao dao = new ClienteDao(conn);
		Cliente cliente = dao.get(id);
		request.setAttribute("cliente", cliente);
		CidadeDao cidadeDao = new CidadeDao(conn);
		List<Cidade> cidades = cidadeDao.getAll();
		request.setAttribute("cidades", cidades);
		
		return "/WEB-INF/FormularioCliente.jsp";
	}

}
