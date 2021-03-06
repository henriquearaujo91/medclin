package br.com.medclin.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PlanoSaudePaciente implements Serializable {

	private static final long SerialVersionUID = 1L;

	@EmbeddedId
	private PlanoSaudePacientePK planoSaudePacientePK;

	private String numeroCartao;

	private String nomeTitular;

	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-03:00")
	private Date validadeCartao;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_operadora")
	private Operadora operadora;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "codigo_tipo_plano")
	private TipoPlanoSaude tipoPlanoSaude;

	@ManyToOne
	@JoinColumn(name = "codigo_pessoa", referencedColumnName = "codigo_pessoa", insertable = false, updatable = false)
	private Paciente paciente;

	private String flagAtivo;

	private String usuarioUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataUltimaAlteracao;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCriacao;

	public PlanoSaudePacientePK getPlanoSaudePacientePK() {
		return planoSaudePacientePK;
	}

	public void setPlanoSaudePacientePK(PlanoSaudePacientePK planoSaudePacientePK) {
		this.planoSaudePacientePK = planoSaudePacientePK;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public Date getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(Date validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public Operadora getOperadora() {
		return operadora;
	}

	public void setOperadora(Operadora operadora) {
		this.operadora = operadora;
	}

	public TipoPlanoSaude getTipoPlanoSaude() {
		return tipoPlanoSaude;
	}

	public void setTipoPlanoSaude(TipoPlanoSaude tipoPlanoSaude) {
		this.tipoPlanoSaude = tipoPlanoSaude;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String getFlagAtivo() {
		return flagAtivo;
	}

	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}

	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}

	public Date getDataUltimaAlteracao() {
		return dataUltimaAlteracao;
	}

	public void setDataUltimaAlteracao(Date dataUltimaAlteracao) {
		this.dataUltimaAlteracao = dataUltimaAlteracao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataUltimaAlteracao == null) ? 0 : dataUltimaAlteracao.hashCode());
		result = prime * result + ((flagAtivo == null) ? 0 : flagAtivo.hashCode());
		result = prime * result + ((nomeTitular == null) ? 0 : nomeTitular.hashCode());
		result = prime * result + ((numeroCartao == null) ? 0 : numeroCartao.hashCode());
		result = prime * result + ((operadora == null) ? 0 : operadora.hashCode());
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
		result = prime * result + ((planoSaudePacientePK == null) ? 0 : planoSaudePacientePK.hashCode());
		result = prime * result + ((tipoPlanoSaude == null) ? 0 : tipoPlanoSaude.hashCode());
		result = prime * result + ((usuarioUltimaAlteracao == null) ? 0 : usuarioUltimaAlteracao.hashCode());
		result = prime * result + ((validadeCartao == null) ? 0 : validadeCartao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanoSaudePaciente other = (PlanoSaudePaciente) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataUltimaAlteracao == null) {
			if (other.dataUltimaAlteracao != null)
				return false;
		} else if (!dataUltimaAlteracao.equals(other.dataUltimaAlteracao))
			return false;
		if (flagAtivo == null) {
			if (other.flagAtivo != null)
				return false;
		} else if (!flagAtivo.equals(other.flagAtivo))
			return false;
		if (nomeTitular == null) {
			if (other.nomeTitular != null)
				return false;
		} else if (!nomeTitular.equals(other.nomeTitular))
			return false;
		if (numeroCartao == null) {
			if (other.numeroCartao != null)
				return false;
		} else if (!numeroCartao.equals(other.numeroCartao))
			return false;
		if (operadora == null) {
			if (other.operadora != null)
				return false;
		} else if (!operadora.equals(other.operadora))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		if (planoSaudePacientePK == null) {
			if (other.planoSaudePacientePK != null)
				return false;
		} else if (!planoSaudePacientePK.equals(other.planoSaudePacientePK))
			return false;
		if (tipoPlanoSaude == null) {
			if (other.tipoPlanoSaude != null)
				return false;
		} else if (!tipoPlanoSaude.equals(other.tipoPlanoSaude))
			return false;
		if (usuarioUltimaAlteracao == null) {
			if (other.usuarioUltimaAlteracao != null)
				return false;
		} else if (!usuarioUltimaAlteracao.equals(other.usuarioUltimaAlteracao))
			return false;
		if (validadeCartao == null) {
			if (other.validadeCartao != null)
				return false;
		} else if (!validadeCartao.equals(other.validadeCartao))
			return false;
		return true;
	}

}
