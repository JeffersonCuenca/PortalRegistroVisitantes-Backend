package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entities.UsuarioRol;

public interface IUsuarioRolRepository extends JpaRepository<UsuarioRol, Long>{
	
	public UsuarioRol findByUsuarioYaAsignado(Long id);
	
}
