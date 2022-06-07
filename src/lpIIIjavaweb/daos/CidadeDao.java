package lpIIIjavaweb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Cliente;

public class CidadeDao implements Dao<Cidade>{

	@Override
	public Cidade get(int id) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "SELECT * FROM cidade WHERE id=?";
		Cidade cidade = null;
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			if(resultado.next()) {
				String descricao = resultado.getString("descricao");
				String uf = resultado.getString("uf");
				cidade = new Cidade(id, descricao, uf); 
			}
			resultado.close();			
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cidade;
	}

	@Override
	public List<Cidade> getAll() {
		Connection bd = FactoryConnection.getConnection();
		List<Cidade> lista = new ArrayList<Cidade>();
		try {
			Statement sentenca = bd.createStatement();
			String sql = "SELECT * FROM cidade ORDER BY descricao";
			ResultSet resultado = sentenca.executeQuery(sql);
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String descricao = resultado.getString("descricao");
				String uf = resultado.getString("uf");
				Cidade cidade = new Cidade(id, descricao, uf);
				lista.add(cidade);
			}
			resultado.close();
			sentenca.close();
			bd.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return lista;
	}

	@Override
	public void save(Cidade cidade) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "INSERT INTO cidade (descricao, uf) VALUES (?, ?)";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, cidade.getDescricao());
			sentenca.setString(2, cidade.getUf());
			sentenca.execute();
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Cidade cidade) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "UPDATE cidade SET descricao=?, uf=? WHERE id=?";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, cidade.getDescricao());
			sentenca.setString(2, cidade.getUf());
			sentenca.setInt(3, cidade.getId());
			sentenca.execute();
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Cidade cidade) {
		int id = cidade.getId();
		Connection bd = FactoryConnection.getConnection();
		String sql = "DELETE FROM cidade WHERE id=?";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setInt(1, id);
			sentenca.execute();
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
