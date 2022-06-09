package lpIIIjavaweb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import lpIIIjavaweb.models.Usuario;

public class UsuarioDao implements Dao<Usuario>{
	private Connection bd = null;
	
	

	public UsuarioDao(Connection bd) {
		super();
		this.bd = bd;
	}


	public Usuario getByEmail(String email) {
		String sql = "SELECT * FROM usuario WHERE email=?";
		Usuario usuario = null;
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, email);
			ResultSet resultado = sentenca.executeQuery();
			if(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String password = resultado.getString("password");
				usuario = new Usuario(id, nome, email, password); 
			}
			resultado.close();			
			sentenca.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	
	@Override
	public Usuario get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Usuario t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Usuario t) {
		// TODO Auto-generated method stub
		
	}

}

