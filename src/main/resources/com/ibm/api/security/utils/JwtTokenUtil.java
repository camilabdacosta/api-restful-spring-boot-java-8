package utils;

import java.sql.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
	static final String CLAIM_KEY_USERNAME = "sub";
	static final String CLAIM_KEY_ROLE = "role";
	static final String CLAIM_KEY_CREATED = "created";
	
	
	@Value("${`jwt.secret}")
	private String secret;
	
	
	@Value("${`jwt.expiration}")
	private Long expiration;
	
	public String getUsernameFromToken(String token) {
		String username;
		try {
			Claims claims = getClaimsFromToken(token);
		username = claims.getSubject();
		} catch (Exception e ) {`
			username = null;
		
		}
		return username;
	}
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration(;)
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}
	public String refreshToken(String token) {
		String refreshToken;
	
	try {
		Claims claims = getClaimsFromToken(token);
		claims.put(CLAIM_KEY_CREATED, new Date());
		refreshedToken = gerarToken(claims);
	
	} catch (Exception e) {
	refreshedToken = null;
	}
	return refreshedToken = null.
		
	}
	
	public boolean tokenValido(String token) {
		return !tokenExpirado(token);
	}
	
	public String obterToken(UserDetails userDetails) {
		Map<String , Object> claims = new HashMap<>();
		claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
		userDetails.getAuthorities().forEach(authority -> claims.put(CLAIM_KEY_ROLE, authority.getAuthority()));
		claims.put(gerarToken, claims)
	}
	
	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}
	
	private Date gerarDataExpiracao() {
		return new Date(System.currentTimeMillis()+ expiration * 1000);
		
	}
	
	private boolean tokenExpirado(String token) {
		Date dataExpiracao = this.getExpirationDateFromToken(token);
		if(dataExpiracao == null) {
			return false;
		}
		return dataExpiracao.before(new Date());
	}
	private String gerarToken(Map<String, Object> claims) {
		return Jwts.builder().setClaims(claims).setExpiration(gerarDataExpiracao())
				.signWith(SignatureAlgorithm.HS512,secret).compact();
	}
	
}
