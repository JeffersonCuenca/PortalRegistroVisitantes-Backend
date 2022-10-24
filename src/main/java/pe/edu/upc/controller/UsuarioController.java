package pe.edu.upc.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.entities.Rol;
import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.serviceinterface.IUsuarioServiceinterface;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private IUsuarioServiceinterface UsuarioServiceInterface;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/new")
	public Usuario registrarUsuario(@RequestBody Usuario usuario) throws Exception {
		
		usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
		
		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		
		Rol rol = new Rol();	
		rol.setRolId(2L);
		rol.setRolNombre("USUARIO");
		
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setUsuario(usuario);
		usuarioRol.setRol(rol);
		
		usuarioRoles.add(usuarioRol);
		return UsuarioServiceInterface.registrarUsuario(usuario, usuarioRoles);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Usuario> actualizaUsuario(@RequestBody Usuario usuario){
		return ResponseEntity.ok(UsuarioServiceInterface.actualizarUsuario(usuario));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarUsuarios(){
		return ResponseEntity.ok(UsuarioServiceInterface.obtenerUsuarios());
	}
	
	@GetMapping("/list/{username}")
	public Usuario listarUsuario(@PathVariable("username") String username) {
		
		return UsuarioServiceInterface.obtenerUsuario(username);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarUsuario(@PathVariable("id") Long id) {
		UsuarioServiceInterface.eliminarUsuario(id);
	}

}
