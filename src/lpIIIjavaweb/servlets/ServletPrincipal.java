package lpIIIjavaweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.daos.PizzaDao;
import lpIIIjavaweb.logicas.Logica;
import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Pizza;
import lpIIIjavaweb.models.Categoria;

@MultipartConfig(fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet("/sistema")
public class ServletPrincipal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPrincipal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logica = request.getParameter("logica");
		
		// codigo de logs
		System.out.println("log para: "+logica);
		//
		
		String nomeClasse = "lpIIIjavaweb.logicas."+logica;
		try {
			Class classe = Class.forName(nomeClasse);
			Logica controller = (Logica) classe.newInstance();
			String pagina = controller.executa(request, response);
			RequestDispatcher dispacher = request.getRequestDispatcher(pagina);
			dispacher.forward(request, response);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
