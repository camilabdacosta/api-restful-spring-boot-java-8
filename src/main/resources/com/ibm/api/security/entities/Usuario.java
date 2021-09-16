


import java.io.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(nome="usuario");
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String email;
	private String senha;
	private PerfilEnum perfil;
	
	public Usuario() {
		
	}
	
	@Id
	@GeneratedValue(Strategy = GenarationType.AUTO)
	
	public Long getId() {
		return id;
	}
	public Long setId() {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public String setEmail() {
		this.email = email;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "senha", nullable = false)
	public String getSenha() {
		return senha;
	}
	
	public String setSenha(String senha) {
		this.senha=senha;
	}
}
