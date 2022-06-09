package lpIIIjavaweb.models;

import java.time.LocalDate;

public class Pizza {
	private int id;
	private String nome;
	private Categoria categoria;
	private LocalDate data;
	private String foto;
	
	public Pizza(int id, String nome, Categoria categoria, LocalDate data, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.data = data;
		this.foto = foto;
	}
	

	public String getFoto() {
		return foto;
	}



	public void setFoto(String foto) {
		this.foto = foto;
	}



	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
