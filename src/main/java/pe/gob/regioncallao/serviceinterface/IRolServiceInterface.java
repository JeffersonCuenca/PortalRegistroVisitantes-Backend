package pe.gob.regioncallao.serviceinterface;

import java.util.Set;

import pe.gob.regioncallao.entities.Rol;

public interface IRolServiceInterface {
	
	Rol registrarRol(Rol rol);
	
	Set<Rol> obtenerRoles();

}
