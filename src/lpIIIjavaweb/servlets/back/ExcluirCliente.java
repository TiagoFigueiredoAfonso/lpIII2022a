package lpIIIjavaweb.servlets.back;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cliente;

/**
 * Servlet implementation class ExcluirCliente
 */
@WebServlet("/excluirCliente")
public class ExcluirCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Cliente cliente = new Cliente(id, "", "", "", "", null);
		ClienteDao dao = new ClienteDao();
		dao.delete(cliente);
		response.sendRedirect("listagemCliente");
	}

}
