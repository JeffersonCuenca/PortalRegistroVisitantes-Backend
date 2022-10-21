package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entities.Visitante;

public interface IVisitanteRepository extends JpaRepository<Visitante, Long>{
	
	/*select *
	from visitantes
	where fecha_hora_ingreso between '20221021 00:00:00' and '20221021 23:59:59'*/

}
