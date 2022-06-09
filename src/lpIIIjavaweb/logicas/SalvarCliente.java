package lpIIIjavaweb.logicas;

import java.sql.Connection;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Cliente;

public class SalvarCliente implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("conn");
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String fone = request.getParameter("fone");
		String endereco = request.getParameter("endereco");
		int cidade_id = Integer.parseInt(request.getParameter("cidade_id"));
		CidadeDao cidadeDao = new CidadeDao(conn);
		Cidade cidade = cidadeDao.get(cidade_id);
		
		LocalDate data_aniversario = null;
		if (request.getParameter("data_aniversario") != null) {
  		  data_aniversario = LocalDate.parse(request.getParameter("data_aniversario"));
		}  
		System.out.println("request: "+request.getParameter("data_aniversario"));	
		System.out.println("data: "+data_aniversario);	
		Cliente cliente = new Cliente(id, nome, email, fone, endereco, cidade, data_aniversario);
		ClienteDao dao = new ClienteDao(conn);
		if (id==0) {
		  dao.save(cliente);
		} else {
		  dao.update(cliente);
		}
		return "/sistema?logica=ListagemCliente";
	}

}
