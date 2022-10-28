package pe.edu.upc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.sf.jasperreports.engine.JRException;
import pe.edu.upc.entities.ReporteJasperVisitantes;
import pe.edu.upc.entities.Visitante;
import pe.edu.upc.enums.TipoReporteEnum;
import pe.edu.upc.serviceinterface.IVisitanteServiceInterface;

@RestController
@RequestMapping("/visitantes")
@CrossOrigin("*")
public class VisitanteController {
	
	@Autowired 
	private IVisitanteServiceInterface visitanteServiceInterface;
	
	@PostMapping("/new")
	public ResponseEntity<Visitante> registrarVisitante(@RequestBody Visitante visitante){
		//visitante.setFechaHoraIngreso(LocalDateTime.now());
		visitante.setFechaIngreso(LocalDate.now());
		visitante.setHoraIngreso(LocalTime.now());
		return ResponseEntity.ok(visitanteServiceInterface.registrarVisitante(visitante));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Visitante> actualizarVisitante(@RequestBody Visitante visitante){
		return ResponseEntity.ok(visitanteServiceInterface.actualizarVisitante(visitante));
	}
	
	@PutMapping("/updateSalida")
	public ResponseEntity<Visitante> actualizarVisitanteSalida(@RequestBody Visitante visitante){
		//visitante.setFechaHoraSalida(LocalDateTime.now());
		visitante.setFechaSalida(LocalDate.now());
		visitante.setHoraSalida(LocalTime.now());
		return ResponseEntity.ok(visitanteServiceInterface.actualizarVisitante(visitante));
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> listarVisitantes(){
		return ResponseEntity.ok(visitanteServiceInterface.obtenerVisitantes());
	}
	
	@GetMapping("/list/{id}")
	public Visitante listarVisitante(@PathVariable("id") Long id){
		return visitanteServiceInterface.obtenerVisitante(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void eliminarVisitante(@PathVariable("id") Long id){
		visitanteServiceInterface.eliminarVisitante(id);
	}
	
	@GetMapping("/reporteJasperVisitantes")
	public ResponseEntity<Resource> reporteJasperVisitantes(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {
		ReporteJasperVisitantes dto = visitanteServiceInterface.reporteJasperVisitantes(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;
		if (params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;
		} else {
			mediaType = MediaType.APPLICATION_PDF;
		} 

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);
	}

}
