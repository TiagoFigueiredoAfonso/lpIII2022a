package lpIIIjavaweb.logicas;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lpIIIjavaweb.daos.UsuarioDao;
import lpIIIjavaweb.models.Usuario;
import lpIIIjavaweb.utils.GeraMD5;

public class Logar implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Connection conn = (Connection) request.getAttribute("conn");
		UsuarioDao dao = new UsuarioDao(conn);
		Usuario usuario = dao.getByEmail(email);
		if (usuario == null) {  // não encontrei o usuario 
			return "sistema?logica=Login";
		} else {
			String passwordmd5 = GeraMD5.md5(password);
			if (!passwordmd5.equals(usuario.getPassword())) {
				// senha não é válida
				return "sistema?logica=Login";
			}
		}
		HttpSession sessao = request.getSession();
		sessao.setAttribute("usuarioLogado", usuario);
		return "sistema?logica=Index";
	}

}