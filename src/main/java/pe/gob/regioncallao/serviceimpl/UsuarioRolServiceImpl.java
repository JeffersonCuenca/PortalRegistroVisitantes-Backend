package pe.gob.regioncallao.serviceimpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.gob.regioncallao.entities.UsuarioRol;
import pe.gob.regioncallao.exceptions.UsuarioFoundException;
import pe.gob.regioncallao.repositories.IUsuarioRolRepository;
import pe.gob.regioncallao.serviceinterface.IUsuarioRolServiceInterface;

@Service
public class UsuarioRolServiceImpl implements IUsuarioRolServiceInterface {
	
	@Autowired
	private IUsuarioRolRepository usuarioRolRepository;

	@Override
	public UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol) throws UsuarioFoundException {
		// TODO Auto-generated method stub
		UsuarioRol usuarioLocal = usuarioRolRepository.findByUsuarioYaAsignado(usuarioRol.getUsuarioYaAsignado());
		if(usuarioLocal != null) {
			System.out.println("El usuario ya tiene asignado un rol");
			throw new UsuarioFoundException("El usuario ya tiene asignado un rol");
		}
		else {
			usuarioLocal = usuarioRolRepository.save(usuarioRol);
		}
		return usuarioLocal;
	}

	@Override
	public UsuarioRol actualizarUsuarioRol(UsuarioRol usuarioRol) {
		// TODO Auto-generated method stub
		return usuarioRolRepository.save(usuarioRol);
	}
	
	@Override
	public Set<UsuarioRol> obtenerUsuariosRoles() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(usuarioRolRepository.findAll());
	}
	
	@Override
	public UsuarioRol obtenerUsuarioRol(Long id) {
		// TODO Auto-generated method stub
		return usuarioRolRepository.findById(id).get();
	}

	@Override
	public void eliminarUsuarioRol(Long id) {
		// TODO Auto-generated method stub
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setId(id);
		
		usuarioRolRepository.delete(usuarioRol);
	}	
}
