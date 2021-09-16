package documents;

import org.springframework.data.annotation.Id;
@Document(collection ="clientes")
public class Cliente {
@Id
private String id;
private String nome;
private Integer idade;

public Cliente() {
	
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Integer getIdade() {
	return idade;
}

public void setIdade(Integer idade) {
	this.idade = idade;
}


}
