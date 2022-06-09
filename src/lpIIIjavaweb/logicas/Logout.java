package lpIIIjavaweb.logicas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession sessao = request.getSession();
		sessao.invalidate();
		return "sistema?logica=Login";
	}

}

