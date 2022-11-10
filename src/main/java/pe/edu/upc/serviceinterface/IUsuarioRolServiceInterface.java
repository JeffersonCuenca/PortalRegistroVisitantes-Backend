package pe.edu.upc.serviceinterface;

import java.util.Set;

import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.exceptions.UsuarioFoundException;

public interface IUsuarioRolServiceInterface {
	
	UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol) throws UsuarioFoundException;
	
	Set<UsuarioRol> obtenerUsuariosRoles();

}
