package dto;
import java.io.IOException;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponde response,
			AuthenticationException authException) throws IOException {
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Acesso negado.Você deve estar autenticado no sistema para acessar a URL solicitada");
	}

	@Override
	public void commence(HttpServletRequest arg0, HttpServletResponse arg1,
			org.springframework.security.core.AuthenticationException arg2) throws IOException, ServletException {
// TODO Auto-generated method stub
		
	}
}
