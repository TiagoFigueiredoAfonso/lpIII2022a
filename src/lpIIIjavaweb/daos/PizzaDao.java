package lpIIIjavaweb.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import lpIIIjavaweb.models.Categoria;
import lpIIIjavaweb.models.Pizza;

public class PizzaDao implements Dao<Pizza>{

	@Override
	public Pizza get(int id) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "SELECT pizza.*, categoria.nome as categoria_nome FROM pizza LEFT JOIN categoria ON categoria.id = pizza.categoria_id WHERE pizza.id=?";
		
		Pizza pizza = null;
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setInt(1, id);
			ResultSet resultado = sentenca.executeQuery();
			if(resultado.next()) {
				String nome = resultado.getString("nome");				
				int categoria_id = resultado.getInt("categoria_id");
				
				String categoria_nome = resultado.getString("categoria_nome");				
				Categoria categoria = new Categoria(categoria_id, categoria_nome);				
				LocalDate data =null;
				if (resultado.getDate("data")!=null) {
					data = LocalDate.parse(
							resultado.getDate("data").toString());
				}
				pizza = new Pizza(id, nome, categoria, data);
			}
			resultado.close();			
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizza;
	}

	@Override
	public List<Pizza> getAll() {
		Connection bd = FactoryConnection.getConnection();
		List<Pizza> lista = new ArrayList<Pizza>();
		try {
			Statement sentenca = bd.createStatement();
			String sql = "SELECT pizza.*, categoria.nome as categoria_nome FROM pizza LEFT JOIN categoria ON categoria.id = pizza.categoria_id ORDER BY nome";
			
			ResultSet resultado = sentenca.executeQuery(sql);
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");				
				int categoria_id = resultado.getInt("categoria_id");
				
				String categoria_nome = resultado.getString("categoria_nome");
				
				Categoria categoria = new Categoria(categoria_id, categoria_nome);
				LocalDate data =null;
				if (resultado.getDate("data")!=null) {
					data = LocalDate.parse(
							resultado.getDate("data").toString());
				}
				Pizza pizza = new Pizza(id, nome, categoria, data);
				
				lista.add(pizza);
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
	public void save(Pizza pizza) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "INSERT INTO pizza (nome, categoria_id, data) VALUES (?, ?, ?)";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, pizza.getNome());		
			sentenca.setInt(2,  pizza.getCategoria().getId());
			sentenca.setDate(3, java.sql.Date.valueOf(
					pizza.getData()));
			sentenca.execute();
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Pizza pizza) {
		Connection bd = FactoryConnection.getConnection();
		String sql = "UPDATE pizza SET nome=?, categoria_id=?, data=? WHERE id=?";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, pizza.getNome());			
			sentenca.setInt(2, pizza.getCategoria().getId());
			sentenca.setDate(3, java.sql.Date.valueOf(
					pizza.getData()));
			sentenca.setInt(4, pizza.getId());
			sentenca.execute();
			sentenca.close();
			bd.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Pizza pizza) {
		int id = pizza.getId();
		Connection bd = FactoryConnection.getConnection();
		String sql = "DELETE FROM pizza WHERE id=?";
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
