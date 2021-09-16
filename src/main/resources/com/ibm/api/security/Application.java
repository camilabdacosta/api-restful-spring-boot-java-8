import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import user.Usuario;

@SpringBootApplication
@EnableCaching
public class Application {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main (String[] args ) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner comandLineRunner() {
		return args ->{
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
		};
		
		@Bean
		public ComandLineRunner comandLineRunner() {
			return args -> {
				System.out.println("Executando serviço pela primeira vez:");
				System.out.println(this.exemploCacheService.exemploCache());
				
				System.out.println("Executando serviço pela segunda vez,deve obter dados do cache:");
				System.out.println(this.exemploCacheService.exemploCache());
			};
		}
	}
}
