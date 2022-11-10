package pe.edu.upc.serviceimpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.UsuarioRol;
import pe.edu.upc.exceptions.UsuarioFoundException;
import pe.edu.upc.repositories.IUsuarioRolRepository;
import pe.edu.upc.serviceinterface.IUsuarioRolServiceInterface;

@Service
public class UsuarioRolServiceImpl implements IUsuarioRolServiceInterface {
	
	@Autowired
	private IUsuarioRolRepository usuarioRolRepository;

	@Override
	public UsuarioRol registrarUsuarioRol(UsuarioRol usuarioRol) throws UsuarioFoundException {
		// TODO Auto-generated method stub
		UsuarioRol usuarioLocal = usuarioRolRepository.findByUsuarioRolId(usuarioRol.getUsuario().getId());
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
	public Set<UsuarioRol> obtenerUsuariosRoles() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(usuarioRolRepository.findAll());
	}	
}
