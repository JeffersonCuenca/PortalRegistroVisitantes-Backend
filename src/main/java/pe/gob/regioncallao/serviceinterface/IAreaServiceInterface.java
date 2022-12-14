package pe.gob.regioncallao.serviceinterface;

import java.util.Set;

import pe.gob.regioncallao.entities.Area;

public interface IAreaServiceInterface {
	
	//Area registrarArea(Area area);
	
	public Integer registrarArea(Area area);
	
	Area actualizarArea(Area area);
	
	//public Integer actualizarArea(Area area);
	
	Set<Area> obtenerAreas();
	
	Area obtenerArea(Long id);
	
	void eliminarArea(Long id);
	

}
