package pe.edu.upc.entities;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "visitantes")
public class Visitante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreVisitante;
	
	private String apellidoVisitante;
	
	private String dniVisitante;
	
	//private LocalDateTime fechaHoraIngreso;
	
	//private LocalDateTime fechaHoraSalida;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaIngreso;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate fechaSalida;
	
	private LocalTime horaIngreso;
	
	private LocalTime horaSalida;
	
	@ManyToOne
	private Area area;
	
	public Visitante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visitante(Long id, String nombreVisitante, String apellidoVisitante, String dniVisitante,
			LocalDate fechaIngreso, LocalDate fechaSalida, LocalTime horaIngreso, LocalTime horaSalida, Area area) {
		super();
		this.id = id;
		this.nombreVisitante = nombreVisitante;
		this.apellidoVisitante = apellidoVisitante;
		this.dniVisitante = dniVisitante;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaIngreso = horaIngreso;
		this.horaSalida = horaSalida;
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
	
	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalTime getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(LocalTime horaIngreso) {
		this.horaIngreso = horaIngreso;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
}
