package br.com.medclin.model;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EnderecoPessoaPK implements Serializable {

	private static final long SerialVersionUID = 1L;

	@Column(name = "codigo_pessoa", nullable = false, updatable = false, precision = 22, scale = 0)
	private BigInteger codigoPessoa;

	@Column(name = "codigo_endereco_pessoa")
	private Integer codigoEnderecoPessoa;

	public BigInteger getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(BigInteger codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Integer getCodigoEnderecoPessoa() {
		return codigoEnderecoPessoa;
	}

	public void setCodigoEnderecoPessoa(Integer codigoEnderecoPessoa) {
		this.codigoEnderecoPessoa = codigoEnderecoPessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoEnderecoPessoa == null) ? 0 : codigoEnderecoPessoa.hashCode());
		result = prime * result + ((codigoPessoa == null) ? 0 : codigoPessoa.hashCode());
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
		EnderecoPessoaPK other = (EnderecoPessoaPK) obj;
		if (codigoEnderecoPessoa == null) {
			if (other.codigoEnderecoPessoa != null)
				return false;
		} else if (!codigoEnderecoPessoa.equals(other.codigoEnderecoPessoa))
			return false;
		if (codigoPessoa == null) {
			if (other.codigoPessoa != null)
				return false;
		} else if (!codigoPessoa.equals(other.codigoPessoa))
			return false;
		return true;
	}

}
