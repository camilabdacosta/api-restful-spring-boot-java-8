

import java.util.*;

public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	public Optional<Usuario> buscarPorEmail(String email){
		return Optional.ofNullable(this.usuarioRepository.findByEmail(email));
	}
}
