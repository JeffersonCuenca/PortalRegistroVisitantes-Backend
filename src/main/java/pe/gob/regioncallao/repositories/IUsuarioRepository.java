package pe.gob.regioncallao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.gob.regioncallao.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);

}
