package pe.gob.regioncallao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.regioncallao.entities.UsuarioRol;

public interface IUsuarioRolRepository extends JpaRepository<UsuarioRol, Long>{
	
	public UsuarioRol findByUsuarioYaAsignado(Long id);
	
}
