
public class JwtAuthenticationDto {

	
	private String email;
	private String senha;
	
	
	public JwtAuthenticationDto() {
		
	}
	
	@NotEmpty(message = "Email não pode ser vazio")
	@Email(message = "Email invalido")
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@NotEmpty(message = "Senha não pode ser vazia")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
}
