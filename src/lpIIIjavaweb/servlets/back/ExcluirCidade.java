package lpIIIjavaweb.servlets.back;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.models.Cidade;

/**
 * Servlet implementation class ExcluirCidade
 */
@WebServlet("/excluirCidade")
public class ExcluirCidade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirCidade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CidadeDao dao = new CidadeDao();
		int id = Integer.parseInt(request.getParameter("id"));
		Cidade cidade = new Cidade(id, "", "");
		dao.delete(cidade);
		response.sendRedirect("listagemCidade");
		
	}

}
