package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.exceptions.UsuarioFoundException;
import pe.edu.upc.serviceinterface.IUsuarioRolServiceInterface;

@RestController
@RequestMapping("/usuariosroles")
@CrossOrigin("*")
public class UsuarioRolController {

	@Autowired
	private IUsuarioRolServiceInterface usuarioRolServiceInterface;
	
	@PostMapping("/new")
	public ResponseEntity<UsuarioRol> registrarUsuarioRol(@RequestBody UsuarioRol usuarioRol) throws UsuarioFoundException {
		usuarioRol.setUsuarioYaAsignado(usuarioRol.getUsuario().getId());
		return ResponseEntity.ok(usuarioRolServiceInterface.registrarUsuarioRol(usuarioRol));
	}
	
	@PutMapping("/update")
	public ResponseEntity<UsuarioRol> actualizarUsuarioRol(@RequestBody UsuarioRol usuarioRol) {
		return ResponseEntity.ok(usuarioRolServiceInterface.actualizarUsuarioRol(usuarioRol));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarUsuariosRoles() {
		return ResponseEntity.ok(usuarioRolServiceInterface.obtenerUsuariosRoles());
	}
	
	@GetMapping("/list/{id}")
	public UsuarioRol listarUsuarioRol(@PathVariable("id") Long id) {
		return usuarioRolServiceInterface.obtenerUsuarioRol(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarUsuarioRol(@PathVariable("id") Long id) {
		usuarioRolServiceInterface.eliminarUsuarioRol(id);
	}
}
