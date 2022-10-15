package pe.edu.upc;

/*import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*import pe.edu.upc.entities.Rol;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.serviceinterface.IUsuarioServiceinterface;*/

@SpringBootApplication
public class UbicuoAngularApplication implements CommandLineRunner {
	
	/*@Autowired
	private IUsuarioServiceinterface UsuarioServiceinterface;*/

	public static void main(String[] args) {
		SpringApplication.run(UbicuoAngularApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Usuario usuario = new Usuario();
		
		usuario.setNombreU("Jefferson");
		usuario.setApellidoU("Cuenca");
		usuario.setPasswordU("1234");
		usuario.setCorreoU("jeffer020301@hotmail.com");
		usuario.setDniU("75451867");
		
		Rol rol = new Rol();
		rol.setId(1L);
		rol.setNombreR("ADMIN");
		
		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);
		
		Usuario usuarioGuardado = UsuarioServiceinterface.registrarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getDniU());*/
		
	}

}
