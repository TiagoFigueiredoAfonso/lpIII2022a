package lpIIIjavaweb.models;

public class Cidade {
  private int id;
  private String descricao;
  private String uf;

  
	public Cidade(int id, String descricao, String uf) {
	super();
	this.id = id;
	this.descricao = descricao;
	this.uf = uf;
}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
  
}
