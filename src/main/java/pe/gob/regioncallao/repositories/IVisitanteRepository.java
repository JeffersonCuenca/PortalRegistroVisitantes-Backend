package pe.gob.regioncallao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.regioncallao.entities.Visitante;

public interface IVisitanteRepository extends JpaRepository<Visitante, Long>{
	
	/*@Query("SELECT v.nombreVisitante, v.apellidoVisitante, v.dniVisitante, a.nombreArea, v.fechaIngreso,v.horaIngreso, v.fechaSalida, v.horaSalida "
		 + "FROM Visitante v JOIN Area a ON v.area = a.id "
		 + "WHERE LOWER(v.apellidoVisitante)=:apellido OR UPPER(v.apellidoVisitante)=:apellido OR v.apellidoVisitante=:apellido AND v.fechaSalida IS NOT NULL "
		 + "ORDER BY v.fechaIngreso ASC ")
	Optional<String> findByLastname(String apellido);
	
	@Query("SELECT v.nombreVisitante, v.apellidoVisitante, v.dniVisitante, a.nombreArea, v.fechaIngreso,v.horaIngreso, v.fechaSalida, v.horaSalida "
			 + "FROM Visitante v JOIN Area a ON v.area = a.id "
			 + "WHERE v.fechaIngreso BETWEEN :fechaInicio AND :fechaFin AND v.fechaSalida IS NOT NULL "
			 + "ORDER BY v.fechaIngreso ASC ")*/
	
	

}
