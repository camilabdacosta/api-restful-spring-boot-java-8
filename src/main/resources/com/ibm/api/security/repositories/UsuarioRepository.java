import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import user.Usuario;

@Transactional(
    readOnly = true
)
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String var1);
}
