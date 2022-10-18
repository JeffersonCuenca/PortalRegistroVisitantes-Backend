package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entities.Area;

public interface IAreaRepository extends JpaRepository<Area, Long>{
	
	@Query("select count(a.nombreArea) from Area a where a.nombreArea=:nombreArea")
	public int areaExistente(@Param("nombreArea") String nombreArea);
}
