package pe.edu.upc.serviceimpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Area;
import pe.edu.upc.repositories.IAreaRepository;
import pe.edu.upc.serviceinterface.IAreaServiceInterface;

@Service
public class AreaServiceImpl implements IAreaServiceInterface{
	
	@Autowired
	private IAreaRepository areaRepository;

	/*@Override
	public Area registrarArea(Area area) {
		// TODO Auto-generated method stub
		return areaRepository.save(area);
	}*/

	@Override
	public Integer registrarArea(Area area) {
		// TODO Auto-generated method stub
		int rpta = areaRepository.areaExistente(area.getNombreArea());
		if (rpta == 0) {
			areaRepository.save(area);
		}
		return rpta;
	}
	
	/*@Override
	public Area actualizarArea(Area area) {
		// TODO Auto-generated method stub
		return areaRepository.save(area);
	}*/

	@Override
	public Integer actualizarArea(Area area) {
		// TODO Auto-generated method stub
		int rpta = areaRepository.areaExistente(area.getNombreArea());
		if (rpta == 0) {
			areaRepository.save(area);
		}
		return rpta;
	}
	
	@Override
	public Set<Area> obtenerAreas() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(areaRepository.findAll());
	}

	@Override
	public Area obtenerArea(Long id) {
		// TODO Auto-generated method stub
		return areaRepository.findById(id).get();
	}

	@Override
	public void eliminarArea(Long id) {
		// TODO Auto-generated method stub
		Area area = new Area();
		area.setId(id);
		
		areaRepository.delete(area);
	}

}
