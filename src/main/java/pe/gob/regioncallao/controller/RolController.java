package pe.gob.regioncallao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.gob.regioncallao.entities.Rol;
import pe.gob.regioncallao.serviceinterface.IRolServiceInterface;

@RestController
@RequestMapping("/roles")
@CrossOrigin("*")
public class RolController {

	@Autowired
	private IRolServiceInterface rolServiceInterface;
	
	@PostMapping("/new")
	public ResponseEntity<Rol> registrarRol(@RequestBody Rol rol) {
		return ResponseEntity.ok(rolServiceInterface.registrarRol(rol));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarRoles(){
		return ResponseEntity.ok(rolServiceInterface.obtenerRoles());
	}
}
