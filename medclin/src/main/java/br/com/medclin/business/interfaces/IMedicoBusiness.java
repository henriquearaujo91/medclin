package br.com.medclin.business.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.medclin.model.Medico;

public interface IMedicoBusiness {

	public Medico atualizarMedico(final Medico medico);

	public Page<Medico> buscarMedicoPorNome(final PageRequest pageable, final String nomeMedico);

	public Medico buscarMedicoPorCodigo(final Long codigoMedico);

	public Medico criarMedico(final Medico medico);

	public void deletarMedico(final Long codigoMedico);

	public Page<Medico> listarMedico(final PageRequest pageable);

}
