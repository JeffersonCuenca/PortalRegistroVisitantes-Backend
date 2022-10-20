package pe.edu.upc.serviceimpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entities.Visitante;
import pe.edu.upc.repositories.IVisitanteRepository;
import pe.edu.upc.serviceinterface.IVisitanteServiceInterface;

@Service
public class VisitanteServiceImpl implements IVisitanteServiceInterface{
	
	@Autowired
	private IVisitanteRepository visitanteRepository;

	@Override
	public Visitante registrarVisitante(Visitante visitante) {
		// TODO Auto-generated method stub
		return visitanteRepository.save(visitante);
	}

	@Override
	public Visitante actualizarVisitante(Visitante visitante) {
		// TODO Auto-generated method stub
		return visitanteRepository.save(visitante);
	}

	@Override
	public Set<Visitante> obtenerVisitantes() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(visitanteRepository.findAll());
	}

	@Override
	public Visitante obtenerVisitante(Long id) {
		// TODO Auto-generated method stub
		return visitanteRepository.findById(id).get();
	}

	@Override
	public void eliminarVisitante(Long id) {
		// TODO Auto-generated method stub
		Visitante visitante = new Visitante();
		visitante.setId(id);
		
		visitanteRepository.delete(visitante);
	}

}
