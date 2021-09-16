

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import user.Usuario;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	public Optional<Usuario> buscarPorEmail(String email){
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}
