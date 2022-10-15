package pe.edu.upc.serviceimpl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Usuario;
import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.repositories.IRolRepository;
import pe.edu.upc.repositories.IUsuarioRepository;
import pe.edu.upc.serviceinterface.IUsuarioServiceinterface;

@Service
public class UsuarioServiceImpl implements IUsuarioServiceinterface{

	@Autowired
	private IUsuarioRepository UsuarioRepository;
	
	@Autowired
	private IRolRepository RolRepository;
	
	@Override
	public Usuario registrarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioLocal = UsuarioRepository.findByUsername(usuario.getUsername());
		if(usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new Exception("El usuario ya esta presente");
		}
		else {
			for(UsuarioRol usuarioRol:usuarioRoles) {
				RolRepository.save(usuarioRol.getRol());
			}
			usuario.getUsuarioRoles().addAll(usuarioRoles);
			usuarioLocal = UsuarioRepository.save(usuario);
		}
		return usuarioLocal;
	}

	@Override
	public Usuario obtenerUsuario(String username) {
		// TODO Auto-generated method stub
		return UsuarioRepository.findByUsername(username);
	}

	@Override
	public void eliminarUsuario(Long usuarioId) {
		// TODO Auto-generated method stub
		UsuarioRepository.deleteById(usuarioId);
	}

}
