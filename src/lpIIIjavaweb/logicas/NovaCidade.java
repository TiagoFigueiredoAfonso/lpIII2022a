package lpIIIjavaweb.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.models.Cidade;

public class NovaCidade implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cidade cidade= new Cidade(0, "", "");
		request.setAttribute("cidade", cidade);
		return "/WEB-INF/FormularioCidade.jsp";
	}

}
