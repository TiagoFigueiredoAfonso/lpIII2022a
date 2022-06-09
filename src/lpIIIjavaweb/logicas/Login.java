package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/WEB-INF/FormularioLogin.jsp";
	}

}