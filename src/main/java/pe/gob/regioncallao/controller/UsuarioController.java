package pe.gob.regioncallao.controller;

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

import pe.gob.regioncallao.entities.Usuario;
import pe.gob.regioncallao.serviceinterface.IUsuarioServiceinterface;

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
		
		return UsuarioServiceInterface.registrarUsuario(usuario);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Usuario> actualizaUsuario(@RequestBody Usuario usuario){
		
		return ResponseEntity.ok(UsuarioServiceInterface.actualizarUsuario(usuario));
	}
	
	@PutMapping("/updatePassword")
	public ResponseEntity<Usuario> actualizarContrasenia(@RequestBody Usuario usuario) {
		
		usuario.setPassword(this.bCryptPasswordEncoder.encode(usuario.getPassword()));
		
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
