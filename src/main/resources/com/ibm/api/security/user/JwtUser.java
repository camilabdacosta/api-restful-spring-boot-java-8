package user;

public class JwtUser implemnts UserDetails {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;
	private Collection<? extends GrantedAutority> authorities;
	
	
	public JwUser(Long id, String username, String password,Collection<? extends Granted Authority> authorities) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
	}
	public Long getId() {
		return id;
	}
	public Long setId() {
		this.id = id;		
}
	@Override
	public String getUsername() {
		return username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialNonExpired() {
		return true;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority >getAuthorities(){
		return authorities;
	}
	@Override
	public voolean isEnabled() {
		return true;
	}
}
