package pe.edu.upc.serviceimpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Rol;
import pe.edu.upc.repositories.IRolRepository;
import pe.edu.upc.serviceinterface.IRolServiceInterface;

@Service
public class RolServiceImpl implements IRolServiceInterface{
	
	@Autowired
	private IRolRepository rolRepository;

	@Override
	public Rol registrarRol(Rol rol) {
		// TODO Auto-generated method stub
		return rolRepository.save(rol);
	}

	@Override
	public Set<Rol> obtenerRoles() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(rolRepository.findAll());
	}

}
