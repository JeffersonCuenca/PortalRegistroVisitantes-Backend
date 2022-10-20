package pe.edu.upc.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@Table(name = "visitantes")
public class Visitante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreVisitante;
	
	private String apellidoVisitante;
	
	private String dniVisitante;
	
	private LocalDateTime fechaHoraIngreso;
	
	@Nullable
	private LocalDateTime fechaHoraSalida;
	
	@ManyToOne
	private Area area;
	
	public Visitante() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Visitante(Long id, String nombreVisitante, String apellidoVisitante, String dniVisitante,
			LocalDateTime fechaHoraIngreso, LocalDateTime fechaHoraSalida, Area area) {
		super();
		this.id = id;
		this.nombreVisitante = nombreVisitante;
		this.apellidoVisitante = apellidoVisitante;
		this.dniVisitante = dniVisitante;
		this.fechaHoraIngreso = fechaHoraIngreso;
		this.fechaHoraSalida = fechaHoraSalida;
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreVisitante() {
		return nombreVisitante;
	}

	public void setNombreVisitante(String nombreVisitante) {
		this.nombreVisitante = nombreVisitante;
	}

	public String getApellidoVisitante() {
		return apellidoVisitante;
	}

	public void setApellidoVisitante(String apellidoVisitante) {
		this.apellidoVisitante = apellidoVisitante;
	}

	public String getDniVisitante() {
		return dniVisitante;
	}

	public void setDniVisitante(String dniVisitante) {
		this.dniVisitante = dniVisitante;
	}

	public LocalDateTime getFechaHoraIngreso() {
		return fechaHoraIngreso;
	}

	public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
		this.fechaHoraIngreso = fechaHoraIngreso;
	}

	public LocalDateTime getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}
	
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	/*@PrePersist
	public void asignarFechaHoraIngreso() {
		fechaHoraIngreso = LocalDateTime.now();
	}
	
	@PrePersist
	public void asignarFechaHoraSalida() {
		fechaHoraSalida = LocalDateTime.now();
	}*/
}
