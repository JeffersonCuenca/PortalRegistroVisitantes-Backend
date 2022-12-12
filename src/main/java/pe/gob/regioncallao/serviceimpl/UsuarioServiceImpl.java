package pe.gob.regioncallao.serviceimpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.regioncallao.entities.Usuario;
import pe.gob.regioncallao.exceptions.UsuarioFoundException;
import pe.gob.regioncallao.repositories.IUsuarioRepository;
import pe.gob.regioncallao.serviceinterface.IUsuarioServiceinterface;

@Service
public class UsuarioServiceImpl implements IUsuarioServiceinterface{

	@Autowired
	private IUsuarioRepository UsuarioRepository;
	
	@Override
	public Usuario registrarUsuario(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		Usuario usuarioLocal = UsuarioRepository.findByUsername(usuario.getUsername());
		if(usuarioLocal != null) {
			System.out.println("El usuario ya existe");
			throw new UsuarioFoundException("El usuario ya esta presente");
		}
		else {
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

	@Override
	public Usuario actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return UsuarioRepository.save(usuario);
	}

	@Override
	public Set<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(UsuarioRepository.findAll());
	}

}
