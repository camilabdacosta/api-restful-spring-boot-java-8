


import java.io.*;

@Entity
@Table(nome="usuario");
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String email;
	private STring senha;
	private PerfilEnum perfil;
	
	public Usuario() {
		
	}
	
	
}
