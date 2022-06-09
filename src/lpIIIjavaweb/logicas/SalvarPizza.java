package lpIIIjavaweb.logicas;

import java.io.File;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import lpIIIjavaweb.daos.CategoriaDao;
import lpIIIjavaweb.daos.PizzaDao;
import lpIIIjavaweb.models.Categoria;
import lpIIIjavaweb.models.Pizza;

public class SalvarPizza implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Connection conn = (Connection) request.getAttribute("conn");
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");		
		int categoria_id = Integer.parseInt(request.getParameter("categoria_id"));
		CategoriaDao categoriaDao = new CategoriaDao(conn);
		Categoria categoria = categoriaDao.get(categoria_id);
		
		LocalDate data = null;
		if (request.getParameter("data") != null) {
  		  data = LocalDate.parse(request.getParameter("data"));
		}  
		System.out.println("request: "+request.getParameter("data"));	
		System.out.println("data: "+data);	
		
		String uploadPath = request.getServletContext().getRealPath("") + File.separator + "imagens";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) { 
			uploadDir.mkdir();
		}

		Part part = request.getPart("arquivo");
		String foto = request.getParameter("foto");
		if (part.getSize()>0) {
			String name = part.getSubmittedFileName();
			String[] fileNameSplits = name.split("\\.");
			int extensionIndex = fileNameSplits.length -1;
			
		    String fileName = UUID.randomUUID().toString()+"."+ fileNameSplits[extensionIndex];
	
		    part.write(uploadPath + File.separator + fileName);
		    foto = fileName;
		}
		
		Pizza pizza = new Pizza(id, nome, categoria, data, foto);
		PizzaDao dao = new PizzaDao(conn);
		if (id==0) {
		  dao.save(pizza);
		} else {
		  dao.update(pizza);
		}
		return "/sistema?logica=ListagemPizza";
	}

}