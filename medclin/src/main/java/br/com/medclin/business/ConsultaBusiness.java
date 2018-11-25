/*
 * 
 */
package br.com.medclin.business;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.business.interfaces.IConsultaBusiness;
import br.com.medclin.common.AuditoriaUtil;
import br.com.medclin.common.CloneUtil;
import br.com.medclin.dao.ConsultaDAO;
import br.com.medclin.model.Consulta;
import br.com.medclin.repository.ConsultaRepository;

@Configuration
public class ConsultaBusiness implements IConsultaBusiness {

	@Autowired
	private ConsultaRepository consultaRep;
	
	@Autowired
	private ConsultaDAO consultaDAO;

	@Autowired
	private CloneUtil cloneUtil;

	@Autowired
	private AuditoriaUtil auditoriaUtil;

	@Override
	public Consulta atualizarConsulta(final Consulta consulta) {
		auditoriaUtil.setDadosAuditoriaAtualizacao(consulta, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneConsulta(consultaRep.saveAndFlush(consulta));
	}

	@Override
	public Consulta buscarConsultaPorCodigo(final BigInteger codigoConsulta) {
		return cloneUtil.cloneConsulta(consultaRep.buscarConsultaPorCodigo(codigoConsulta));
	}
	
	@Override
	public Page<Consulta> buscarConsulta(final PageRequest pageable, final String nomePaciente, final String dataConsulta, final String mesConsulta) {
				
		final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date dataConsultaFormatada = null;
		if(dataConsulta != null) {
			try {
				dataConsultaFormatada = df.parse(dataConsulta);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		Date mesConsultaFormatada = null;
		if(mesConsulta != null) {
			try {
				mesConsultaFormatada = df.parse(mesConsulta);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return cloneUtil.cloneListaConsulta(consultaDAO.buscarConsulta(pageable, nomePaciente, dataConsultaFormatada, mesConsultaFormatada));
	}

	@Override
	public Consulta criarConsulta(final Consulta consulta) {
		auditoriaUtil.setDadosAuditoriaCriacao(consulta, "MOCK_MATRICULA - " + Math.random());
		return cloneUtil.cloneConsulta(consultaRep.save(consulta));
	}

	@Override
	public void deletarConsulta(final BigInteger codigoConsulta) {
		consultaRep.deleteById(codigoConsulta);
	}

	@Override
	public Page<Consulta> listarConsulta(final PageRequest pageable) {
		return cloneUtil.cloneListaConsulta(consultaRep.findAll(pageable));
	}

}
