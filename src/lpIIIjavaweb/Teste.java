package lpIIIjavaweb;

import lpIIIjavaweb.daos.CidadeDao;

public class Teste {
	public static void main(String[] args) {
		CidadeDao dao = new CidadeDao();
		System.out.println(dao.getAll());
	}
}
