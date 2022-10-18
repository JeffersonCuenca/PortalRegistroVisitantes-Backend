package pe.edu.upc;

/*import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.entities.Rol;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.exceptions.UsuarioFoundException;
import pe.edu.upc.serviceinterface.IUsuarioServiceinterface;*/

@SpringBootApplication
public class UbicuoAngularApplication implements CommandLineRunner {
	
	/*@Autowired
	private IUsuarioServiceinterface UsuarioServiceinterface;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	public static void main(String[] args) {
		SpringApplication.run(UbicuoAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*try {
			Usuario usuario = new Usuario();
			
			usuario.setUsername("75451867");
			usuario.setNombre("Jefferson");
			usuario.setApellido("Cuenca");
			usuario.setPassword(bCryptPasswordEncoder.encode("1234"));
			usuario.setCorreo("jeffer020301@hotmail.com");
			usuario.setDni("75451867");
			
			Rol rol = new Rol();
			rol.setRolId(1L);
			rol.setRolNombre("ADMIN");
			
			Set<UsuarioRol> usuarioRoles = new HashSet<>();
			UsuarioRol usuarioRol = new UsuarioRol();
			usuarioRol.setRol(rol);
			usuarioRol.setUsuario(usuario);
			usuarioRoles.add(usuarioRol);
			
			Usuario usuarioGuardado = UsuarioServiceinterface.registrarUsuario(usuario, usuarioRoles);
			System.out.println(usuarioGuardado.getUsername());
		} catch (UsuarioFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
	}
}
