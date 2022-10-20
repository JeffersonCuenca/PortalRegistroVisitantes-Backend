package pe.edu.upc.serviceinterface;

import java.util.Set;

import pe.edu.upc.entities.Visitante;

public interface IVisitanteServiceInterface {
	
	Visitante registrarVisitante(Visitante visitante);
	
	Visitante actualizarVisitante(Visitante visitante);
	
	Set<Visitante> obtenerVisitantes();
	
	Visitante obtenerVisitante(Long id);
	
	void eliminarVisitante(Long id);

}
