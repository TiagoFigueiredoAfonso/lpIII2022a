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
import lpIIIjavaweb.models.Cidade;

/**
 * Servlet implementation class ListagemCidade
 */
@WebServlet("/listagemCidade")
public class ListagemCidade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListagemCidade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CidadeDao dao = new CidadeDao();
		List<Cidade> cidades = dao.getAll();
		request.setAttribute("cidades", cidades);
		RequestDispatcher dispacher = request.getRequestDispatcher("ListagemCidade.jsp");
		dispacher.forward(request, response);
	}

}
