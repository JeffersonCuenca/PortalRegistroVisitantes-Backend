package pe.edu.upc.serviceinterface;

import java.util.Set;

import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.exceptions.UsuarioFoundException;

public interface IUsuarioRolServiceInterface {
	
	UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol) throws UsuarioFoundException;
	
	UsuarioRol actualizarUsuarioRol(UsuarioRol usuarioRol);
	
	Set<UsuarioRol> obtenerUsuariosRoles();
	
	UsuarioRol obtenerUsuarioRol(Long id);
	
	void eliminarUsuarioRol(Long id);
	
}
