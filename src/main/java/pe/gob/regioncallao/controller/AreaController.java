package pe.gob.regioncallao.controller;

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

import pe.gob.regioncallao.entities.Area;
import pe.gob.regioncallao.serviceinterface.IAreaServiceInterface;

@RestController
@RequestMapping("/areas")
@CrossOrigin("*")
public class AreaController {

	@Autowired
	private IAreaServiceInterface areaServiceInterface;
	
	/*@PostMapping("/new")
	public ResponseEntity<Area> registrarArea(@RequestBody Area area){
		return ResponseEntity.ok(areaServiceInterface.registrarArea(area));
	}*/
	
	@SuppressWarnings("unchecked")
	@PostMapping("/new")
	public ResponseEntity<Integer> registrarArea(@RequestBody Area area){
		int rpta = areaServiceInterface.registrarArea(area);
		if(rpta > 0) {
			return (ResponseEntity<Integer>) ResponseEntity.badRequest();
		}
		return ResponseEntity.ok(rpta);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Area> actualizaArea(@RequestBody Area area){
		return ResponseEntity.ok(areaServiceInterface.actualizarArea(area));
	}
	
	/*@SuppressWarnings("unchecked")
	@PutMapping("/update")
	public ResponseEntity<Integer> actualizaArea(@RequestBody Area area){
		int rpta = areaServiceInterface.actualizarArea(area);
		if(rpta > 0) {
			return (ResponseEntity<Integer>) ResponseEntity.badRequest();
		}
		return ResponseEntity.ok(rpta);
	}*/
	
	@GetMapping("/list")
	public ResponseEntity<?> listarAreas(){
		return ResponseEntity.ok(areaServiceInterface.obtenerAreas());
	}
	
	@GetMapping("/list/{id}")
	public Area listarArea(@PathVariable("id") Long id){
		return areaServiceInterface.obtenerArea(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarArea(@PathVariable("id") Long id){
		areaServiceInterface.eliminarArea(id);
	}	
}
