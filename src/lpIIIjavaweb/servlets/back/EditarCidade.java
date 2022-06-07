package lpIIIjavaweb.servlets.back;

import java.io.IOException;

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
 * Servlet implementation class EditarCidade
 */
@WebServlet("/editarCidade")
public class EditarCidade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCidade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CidadeDao dao = new CidadeDao();
		Cidade cidade = dao.get(id);
		request.setAttribute("cidade", cidade);
		RequestDispatcher rd = request.getRequestDispatcher("FormularioCidade.jsp");
		rd.forward(request, response);
	}

}
