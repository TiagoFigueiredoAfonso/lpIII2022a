package lpIIIjavaweb.servlets.back;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.ClienteDao;
import lpIIIjavaweb.models.Cliente;

/**
 * Servlet implementation class PrimeiroServlet
 */
@WebServlet("/listagemCliente")
public class ListagemCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListagemCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes = dao.getAll();
		request.setAttribute("clientes", clientes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListagemCliente.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
