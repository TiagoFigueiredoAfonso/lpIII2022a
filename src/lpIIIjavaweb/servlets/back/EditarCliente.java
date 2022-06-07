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
 * Servlet implementation class EditarCliente
 */
@WebServlet("/editarCliente")
public class EditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.get(id);
		request.setAttribute("cliente", cliente);
		CidadeDao cidadeDao = new CidadeDao();
		List<Cidade> cidades = cidadeDao.getAll();
		request.setAttribute("cidades", cidades);
		
		RequestDispatcher rd = request.getRequestDispatcher("FormularioCliente.jsp");
		rd.forward(request, response);
	}

}