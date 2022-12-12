package pe.gob.regioncallao.serviceinterface;

import java.util.Set;

import pe.gob.regioncallao.entities.Usuario;

public interface IUsuarioServiceinterface {
	
	public Usuario registrarUsuario(Usuario usuario) throws Exception;
	
	Usuario actualizarUsuario(Usuario usuario);
	
	Set<Usuario> obtenerUsuarios();
	
	public Usuario obtenerUsuario(String dniu);
	
	public void eliminarUsuario(Long usuarioId);
}
