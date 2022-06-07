package lpIIIjavaweb.logicas;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lpIIIjavaweb.daos.CidadeDao;
import lpIIIjavaweb.models.Cidade;

public class EditarCidade implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		CidadeDao dao = new CidadeDao();
		Cidade cidade = dao.get(id);
		request.setAttribute("cidade", cidade);
		return "/WEB-INF/FormularioCidade.jsp";
	}

}
