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
	private Connection bd = null;
	
	public PizzaDao(Connection bd) {
		super();
		this.bd = bd;
	}

	@Override
	public Pizza get(int id) {
		
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
				String foto = resultado.getString("foto");
				LocalDate data =null;
				if (resultado.getDate("data")!=null) {
					data = LocalDate.parse(
							resultado.getDate("data").toString());
				}
				pizza = new Pizza(id, nome, categoria, data, foto);
			}
			resultado.close();			
			sentenca.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pizza;
	}

	@Override
	public List<Pizza> getAll() {
		
		List<Pizza> lista = new ArrayList<Pizza>();
		try {
			Statement sentenca = bd.createStatement();
			String sql = "SELECT pizza.*, categoria.nome as categoria_nome FROM pizza LEFT JOIN categoria ON categoria.id = pizza.categoria_id ORDER BY nome";
			
			ResultSet resultado = sentenca.executeQuery(sql);
			while(resultado.next()) {
				int id = resultado.getInt("id");
				String nome = resultado.getString("nome");				
				int categoria_id = resultado.getInt("categoria_id");
				String foto = resultado.getString("foto");
				
				String categoria_nome = resultado.getString("categoria_nome");
				
				Categoria categoria = new Categoria(categoria_id, categoria_nome);
				LocalDate data =null;
				if (resultado.getDate("data")!=null) {
					data = LocalDate.parse(
							resultado.getDate("data").toString());
				}
				Pizza pizza = new Pizza(id, nome, categoria, data, foto);
				
				lista.add(pizza);
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
	public void save(Pizza pizza) {
		
		String sql = "INSERT INTO pizza (nome, categoria_id, data, foto) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, pizza.getNome());		
			sentenca.setInt(2,  pizza.getCategoria().getId());
			sentenca.setDate(3, java.sql.Date.valueOf(
					pizza.getData()));
			sentenca.setString(4, pizza.getFoto());
			sentenca.execute();
			sentenca.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Pizza pizza) {
		
		String sql = "UPDATE pizza SET nome=?, categoria_id=?, data=?, foto=? WHERE id=?";
		try {
			PreparedStatement sentenca = bd.prepareStatement(sql);
			sentenca.setString(1, pizza.getNome());			
			sentenca.setInt(2, pizza.getCategoria().getId());
			sentenca.setDate(3, java.sql.Date.valueOf(
					pizza.getData()));
			sentenca.setString(4, pizza.getFoto());
			sentenca.setInt(5, pizza.getId());
			sentenca.execute();
			sentenca.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Pizza pizza) {
		int id = pizza.getId();
		
		String sql = "DELETE FROM pizza WHERE id=?";
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
