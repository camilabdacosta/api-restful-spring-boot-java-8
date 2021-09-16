package services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import user.JwtUserFactory;
import user.Usuario;

@Service
public class JwtUserDetailsDServicesImpl implements UserDetailsService {
    @Autowired
    private UsuarioService usuarioService;

    public JwtUserDetailsDServicesImpl() {
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> funcionario = this.usuarioService.buscarPorEmail(username);
        if (funcionario.isPresent()) {
            return JwtUserFactory.create((Usuario)funcionario.get());
        } else {
            throw new UsernameNotFoundException("Email não encontrado.");
        }
    }
}
