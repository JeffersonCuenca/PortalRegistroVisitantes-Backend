package pe.edu.upc.serviceinterface;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import net.sf.jasperreports.engine.JRException;
import pe.edu.upc.entities.ReporteJasperVisitantes;
import pe.edu.upc.entities.Visitante;

public interface IVisitanteServiceInterface {
	
	Visitante registrarVisitante(Visitante visitante);
	
	Visitante actualizarVisitante(Visitante visitante);
	
	Set<Visitante> obtenerVisitantes();
	
	Visitante obtenerVisitante(Long id);
	
	void eliminarVisitante(Long id);
	
	ReporteJasperVisitantes reporteJasperVisitantes(Map<String, Object> params) throws JRException, IOException, SQLException;

}
