package pe.edu.upc.serviceinterface;

import java.util.Set;

import pe.edu.upc.entities.Rol;

public interface IRolServiceInterface {
	
	Rol registrarRol(Rol rol);
	
	Set<Rol> obtenerRoles();

}
