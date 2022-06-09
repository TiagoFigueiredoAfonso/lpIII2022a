package lpIIjavaweb.filtros;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lpIIIjavaweb.models.Usuario;

/**
 * Servlet Filter implementation class FilterLogin
 */
@WebFilter("/sistema")
public class FilterLogin implements Filter {
	private ArrayList<String> operacoesPermitidas = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public FilterLogin() {
        // TODO Auto-generated constructor stub
    	operacoesPermitidas.add("Login");
    	operacoesPermitidas.add("Logar");
    	operacoesPermitidas.add("Index");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
		Usuario usuarioLogado = (Usuario) sessao.getAttribute("usuarioLogado");
		if (usuarioLogado == null) { // usuario nao logado
		  // verificar se é uma operação permitida
		  String logica = request.getParameter("logica");
		  if (!operacoesPermitidas.contains(logica)) {
			  // não é  uma operacao permitida
			  HttpServletResponse resp = (HttpServletResponse) response;
			  resp.sendRedirect("sistema?logica=Login");
			  return;
		  }
		}
		chain.doFilter(request, response);	
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
