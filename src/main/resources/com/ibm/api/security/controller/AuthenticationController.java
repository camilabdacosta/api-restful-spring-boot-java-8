import java.util.Optional;
import java.util.logging.Logger;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.JwtAuthenticationDto;
import dto.TokenDto;
import io.swagger.models.Response;
import utils.JwtTokenUtil;

@RestController
@RequestMapping({"/auth"})
@CrossOrigin(
    origins = {"*"}
)
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    private static final String TOKEN_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;

    public AuthenticationController() {
    }

    @PostMapping
    public ResponseEntity<Response<TokenDto>> gerarTokenJwt(@Valid @RequestBody JwtAuthenticationDto authenticationDto, BindingResult result) throws AuthenticationException {
        Response<TokenDto> response = new Response();
        if (result.hasErrors()) {
            log.error("Erro validando lançamento: {}", result.getAllErrors());
            result.getAllErrors().forEach((error) -> {
                response.getErrors().add(error.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(response);
        } else {
            log.info("Gerando token para o email {}.", authenticationDto.getEmail());
            Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationDto.getEmail(), authenticationDto.getSenha()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationDto.getEmail());
            String token = this.jwtTokenUtil.obterToken(userDetails);
            response.setData(new TokenDto(token));
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping({"/refresh"})
    public ResponseEntity<Response<TokenDto>> gerarRefreshTokenJwt(HttpServletRequest request) {
        log.info("Gerando refresh token JWT.");
        Response<TokenDto> response = new Response();
        Optional<String> token = Optional.ofNullable(request.getHeader("Authorization"));
        if (token.isPresent() && ((String)token.get()).startsWith("Bearer ")) {
            token = Optional.of(((String)token.get()).substring(7));
        }

        if (!token.isPresent()) {
            response.getErrors().add("Token não informado.");
        } else if (!this.jwtTokenUtil.tokenValido((String)token.get())) {
            response.getErrors().add("Token inválido ou expirado.");
        }

        if (!response.getErrors().isEmpty()) {
            return ResponseEntity.badRequest().body(response);
        } else {
            String refreshedToken = this.jwtTokenUtil.refreshToken((String)token.get());
            response.setData(new TokenDto(refreshedToken));
            return ResponseEntity.ok(response);
        }
    }
}