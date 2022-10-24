package pe.edu.upc.serviceinterface;

import java.util.Set;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.UsuarioRol;

public interface IUsuarioServiceinterface {
	
	public Usuario registrarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
	
	Usuario actualizarUsuario(Usuario usuario);
	
	Set<Usuario> obtenerUsuarios();
	
	public Usuario obtenerUsuario(String dniu);
	
	public void eliminarUsuario(Long usuarioId);
}
