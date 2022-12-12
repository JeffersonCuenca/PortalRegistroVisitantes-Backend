package pe.gob.regioncallao.serviceimpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import pe.gob.regioncallao.commons.JasperReportManager;
import pe.gob.regioncallao.entities.ReporteJasperVisitantes;
import pe.gob.regioncallao.entities.Visitante;
import pe.gob.regioncallao.enums.TipoReporteEnum;
import pe.gob.regioncallao.repositories.IVisitanteRepository;
import pe.gob.regioncallao.serviceinterface.IVisitanteServiceInterface;

@Service
public class VisitanteServiceImpl implements IVisitanteServiceInterface{
	
	@Autowired
	private JasperReportManager reportManager;

	@Autowired
	private DataSource dataSource;
	
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

	@Override
	public ReporteJasperVisitantes reporteJasperVisitantes(Map<String, Object> params)
			throws JRException, IOException, SQLException {
		// TODO Auto-generated method stub
		String fileName = "ReporteVisitantesPorFechas";
		ReporteJasperVisitantes dto = new ReporteJasperVisitantes();
		String extension = params.get("tipo").toString().equalsIgnoreCase(TipoReporteEnum.EXCEL.name()) ? ".xlsx"
				: ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				dataSource.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);

		return dto;
	}

}
