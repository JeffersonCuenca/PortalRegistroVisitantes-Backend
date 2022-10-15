package pe.edu.upc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
	
	public Usuario findByUsername(String username);

}
