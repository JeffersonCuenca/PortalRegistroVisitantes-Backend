package pe.gob.regioncallao.serviceinterface;

import java.util.Set;

import pe.gob.regioncallao.entities.UsuarioRol;
import pe.gob.regioncallao.exceptions.UsuarioFoundException;

public interface IUsuarioRolServiceInterface {
	
	UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol) throws UsuarioFoundException;
	
	UsuarioRol actualizarUsuarioRol(UsuarioRol usuarioRol);
	
	Set<UsuarioRol> obtenerUsuariosRoles();
	
	UsuarioRol obtenerUsuarioRol(Long id);
	
	void eliminarUsuarioRol(Long id);
	
}
