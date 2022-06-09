package lpIIIjavaweb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lpIIIjavaweb.models.Categoria;
import lpIIIjavaweb.models.Pizza;


public class CategoriaDao implements Dao<Categoria>{
	private Connection bd = null;	

	public CategoriaDao(Connection bd) {
		super();
		this.bd = bd;
	}

	@Override
	public Categoria get(int id) {		
		String sql = "SELECT * FROM categoria WHERE id=?";
		Categoria categoria = null;
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			if(resultado.next()) {
				String nome = resultado.getString("nome");				
				categoria = new Categoria(id, nome); 
			}
			resultado.close();			
			sentenca.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoria;
	}

	@Override
	public List<Categoria> getAll() {		
		List<Categoria> lista = new ArrayList<Categoria>();
		try {
			Statement sentenca = bd.createStatement();
			String sql = "SELECT * FROM categoria ORDER BY nome";
			ResultSet resultado = sentenca.executeQuery(sql);
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
                
				Categoria categoria = new Categoria(id, nome);
				lista.add(categoria);
			}
			resultado.close();
			sentenca.close();
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return lista;
	}

	@Override
	public void save(Categoria categoria) {		
		String sql = "INSERT INTO categoria (nome) VALUES (?)";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, categoria.getNome());	
			sentenca.execute();
			sentenca.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Categoria categoria) {		
		String sql = "UPDATE categoria SET nome=? WHERE id=?";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, categoria.getNome());			
			sentenca.setInt(2, categoria.getId());
			sentenca.execute();
			sentenca.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Categoria categoria) {
		int id = categoria.getId();		
		String sql = "DELETE FROM categoria WHERE id=?";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setInt(1, id);
			sentenca.execute();
			sentenca.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
