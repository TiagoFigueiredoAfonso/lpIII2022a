package lpIIIjavaweb.servlets.back;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Cliente;

/**
 * Servlet implementation class SalvarCliente
 */
@WebServlet("/salvarCliente")
public class SalvarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalvarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		response.sendRedirect("listagemCliente");
	}

}
