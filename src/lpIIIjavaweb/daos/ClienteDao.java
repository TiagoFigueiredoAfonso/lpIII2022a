package lpIIIjavaweb.daos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import lpIIIjavaweb.models.Cidade;
import lpIIIjavaweb.models.Cliente;


public class ClienteDao implements Dao<Cliente>{
	@Override
	public Cliente get(int id) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "SELECT cliente.*, cidade.descricao as cidade_descricao, cidade.uf as cidade_uf FROM cliente LEFT JOIN cidade ON cidade.id = cliente.cidade_id WHERE cliente.id=?";
		Cliente cliente = null;
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			if(resultado.next()) {
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String fone = resultado.getString("fone");
				String endereco = resultado.getString("endereco");
				
				int cidade_id = resultado.getInt("cidade_id");
				String cidade_descricao = resultado.getString("cidade_descricao");
				String cidade_uf = resultado.getString("cidade_uf");
				Cidade cidade = new Cidade(cidade_id, cidade_descricao, cidade_uf);
				
				cliente = new Cliente(id, nome, email, fone, endereco, cidade);
			}
			resultado.close();			
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}

	@Override
	public List<Cliente> getAll() {
		Connection bd = FactoryConnection.getConnection();
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			Statement sentenca = bd.createStatement();
			String sql = "SELECT cliente.*, cidade.descricao as cidade_descricao, cidade.uf as cidade_uf FROM cliente LEFT JOIN cidade ON cidade.id = cliente.cidade_id ORDER BY nome";
			ResultSet resultado = sentenca.executeQuery(sql);
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");
				String email = resultado.getString("email");
				String fone = resultado.getString("fone");
				String endereco = resultado.getString("endereco");
				
				int cidade_id = resultado.getInt("cidade_id");
				String cidade_descricao = resultado.getString("cidade_descricao");
				String cidade_uf = resultado.getString("cidade_uf");
				Cidade cidade = new Cidade(cidade_id, cidade_descricao, cidade_uf);
				
				Cliente cliente = new Cliente(id, nome, email, fone, endereco, cidade);
				lista.add(cliente);
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
	public void save(Cliente cliente) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "INSERT INTO cliente (nome, email, fone, endereco, cidade_id) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, cliente.getNome());
			sentenca.setString(2, cliente.getEmail());
			sentenca.setString(3, cliente.getFone());
			sentenca.setString(4, cliente.getEndereco());
			sentenca.setInt(5,  cliente.getCidade().getId());
			sentenca.execute();
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Cliente cliente) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "UPDATE cliente SET nome=?, email=?, fone=?, endereco=?, cidade_id=? WHERE id=?";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, cliente.getNome());
			sentenca.setString(2, cliente.getEmail());
			sentenca.setString(3, cliente.getFone());
			sentenca.setString(4, cliente.getEndereco());
			sentenca.setInt(5, cliente.getCidade().getId());
			sentenca.setInt(6, cliente.getId());
			sentenca.execute();
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Cliente cliente) {
		int id = cliente.getId();
		Connection bd = FactoryConnection.getConnection();
		String sql = "DELETE FROM cliente WHERE id=?";
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
