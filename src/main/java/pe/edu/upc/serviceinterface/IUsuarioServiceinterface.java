package pe.edu.upc.serviceinterface;

import java.util.Set;

import pe.edu.upc.entities.Usuario;

public interface IUsuarioServiceinterface {
	
	public Usuario registrarUsuario(Usuario usuario) throws Exception;
	
	Usuario actualizarUsuario(Usuario usuario);
	
	Set<Usuario> obtenerUsuarios();
	
	public Usuario obtenerUsuario(String dniu);
	
	public void eliminarUsuario(Long usuarioId);
}
