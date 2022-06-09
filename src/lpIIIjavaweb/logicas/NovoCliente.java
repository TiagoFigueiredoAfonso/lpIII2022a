package lpIIIjavaweb.logicas;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Cliente;

public class NovoCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cliente cliente = new Cliente(0, "", "", "", "", null, null);
		request.setAttribute("cliente", cliente);
		CidadeDao cidadeDao = new CidadeDao();
		List<Cidade> cidades = cidadeDao.getAll();
		request.setAttribute("cidades", cidades);
		return "/WEB-INF/FormularioCliente.jsp";
	}

}
