package br.edu.ifpb.ifest2.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CONTRATO")
public class Contrato implements Identificavel{
	
	@Id
	@GeneratedValue
	@Column(name="contrato_id")
	private Long id;
	
	@Column(name="contrato_dataInicio")
	private Date dataInicio;
	
	@Column(name="contrato_dataTermino")
	private Date dataTermino;
	
	@Column(name="contrato_prorrogacaoContrato")
	private Date prorrogacaoContrato;
	
	@Column(name="contrato_indenizacao")
	private String indenizacao;	
	
	@OneToMany
	@JoinColumn(name="contrato_entrega")
	private Set<Servico> entrega;
	
	@OneToMany
	@JoinColumn(name="contrato_criaContrato")
	private Set<Fornecedor> criaContrato;
	
	@OneToMany
	@JoinColumn(name="contrato_assinaContrato")
	private Set<Cliente> assinaContrato;
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Date getProrrogacaoContrato() {
		return prorrogacaoContrato;
	}
	public void setProrrogacaoContrato(Date prorrogacaoContrato) {
		this.prorrogacaoContrato = prorrogacaoContrato;
	}
	public String getIndenizacao() {
		return indenizacao;
	}
	public void setIndenizacao(String indenizacao) {
		this.indenizacao = indenizacao;
	}
	public Set<Servico> getEntrega() {
		return entrega;
	}
	public void setEntrega(Set<Servico> entrega) {
		this.entrega = entrega;
	}
	public Set<Fornecedor> getCriaContrato() {
		return criaContrato;
	}
	public void setCriaContrato(Set<Fornecedor> criaContrato) {
		this.criaContrato = criaContrato;
	}
	public Set<Cliente> getAssinaContrato() {
		return assinaContrato;
	}
	public void setAssinaContrato(Set<Cliente> assinaContrato) {
		this.assinaContrato = assinaContrato;
	}

	@Override
	public String toString() {
		return "Contrato [id=" + id + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino
				+ ", prorrogacaoContrato=" + prorrogacaoContrato + ", indenizacao=" + indenizacao + ", entrega="
				+ entrega + ", criaContrato=" + criaContrato + ", assinaContrato=" + assinaContrato + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assinaContrato == null) ? 0 : assinaContrato.hashCode());
		result = prime * result + ((criaContrato == null) ? 0 : criaContrato.hashCode());
		result = prime * result + ((dataInicio == null) ? 0 : dataInicio.hashCode());
		result = prime * result + ((dataTermino == null) ? 0 : dataTermino.hashCode());
		result = prime * result + ((entrega == null) ? 0 : entrega.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((indenizacao == null) ? 0 : indenizacao.hashCode());
		result = prime * result + ((prorrogacaoContrato == null) ? 0 : prorrogacaoContrato.hashCode());
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
		Contrato other = (Contrato) obj;
		if (assinaContrato == null) {
			if (other.assinaContrato != null)
				return false;
		} else if (!assinaContrato.equals(other.assinaContrato))
			return false;
		if (criaContrato == null) {
			if (other.criaContrato != null)
				return false;
		} else if (!criaContrato.equals(other.criaContrato))
			return false;
		if (dataInicio == null) {
			if (other.dataInicio != null)
				return false;
		} else if (!dataInicio.equals(other.dataInicio))
			return false;
		if (dataTermino == null) {
			if (other.dataTermino != null)
				return false;
		} else if (!dataTermino.equals(other.dataTermino))
			return false;
		if (entrega == null) {
			if (other.entrega != null)
				return false;
		} else if (!entrega.equals(other.entrega))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (indenizacao == null) {
			if (other.indenizacao != null)
				return false;
		} else if (!indenizacao.equals(other.indenizacao))
			return false;
		if (prorrogacaoContrato == null) {
			if (other.prorrogacaoContrato != null)
				return false;
		} else if (!prorrogacaoContrato.equals(other.prorrogacaoContrato))
			return false;
		return true;
	}
	
}
