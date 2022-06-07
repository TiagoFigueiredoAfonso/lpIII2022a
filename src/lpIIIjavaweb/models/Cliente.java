package lpIIIjavaweb.models;


public class Cliente {
  private int id;
  private String nome;
  private String email;
  private String fone;
  private String endereco;
  private Cidade cidade;

  public Cliente(int id, String nome, String email, String fone, String endereco, Cidade cidade) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.fone = fone;
	this.endereco = endereco;
	this.cidade = cidade;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFone() {
	return fone;
}

public void setFone(String fone) {
	this.fone = fone;
}

public String getEndereco() {
	return endereco;
}

public void setEndereco(String endereco) {
	this.endereco = endereco;
}



public Cidade getCidade() {
	return cidade;
}

public void setCidade(Cidade cidade) {
	this.cidade = cidade;
}

@Override
public String toString() {
	return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", fone=" + fone + ", endereco=" + endereco
			+ "]";
}

@Override
public boolean equals(Object obj) {
	Cliente cliente = (Cliente) obj;
	return (this.id == cliente.getId());
}


  
  
}