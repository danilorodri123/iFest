package br.edu.ifpb.ifest2.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTE")
@Inheritance(strategy=InheritanceType.JOINED)
public class Cliente extends Pessoa{
	
	@Id
	@GeneratedValue
	@Column(name="cliente_id")
	private Long id;
	
	@Column(name="cliente_cpf")
	private Long CPF;
	
	@Column(name="cliente_rg")
	private Long RG;
	
	@OneToMany
	@JoinColumn(name="cliente_contrata")
	private Set<Servico>contrata;
	
	@OneToMany
	@JoinColumn(name="cliente_endereco")
	private Set<Endereco> residencia;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCPF() {
		return CPF;
	}
	public void setCPF(Long cPF) {
		CPF = cPF;
	}
	public Long getRG() {
		return RG;
	}
	public void setRG(Long rG) {
		RG = rG;
	}
	public Set<Servico> getContrata() {
		return contrata;
	}
	public void setContrata(Set<Servico> contrata) {
		this.contrata = contrata;
	}
	public Set<Endereco> getResidencia() {
		return residencia;
	}
	public void setResidencia(Set<Endereco> residencia) {
		this.residencia = residencia;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", CPF=" + CPF + ", RG=" + RG + ", contrata=" + contrata + ", residencia="
				+ residencia + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
		result = prime * result + ((RG == null) ? 0 : RG.hashCode());
		result = prime * result + ((contrata == null) ? 0 : contrata.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((residencia == null) ? 0 : residencia.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (CPF == null) {
			if (other.CPF != null)
				return false;
		} else if (!CPF.equals(other.CPF))
			return false;
		if (RG == null) {
			if (other.RG != null)
				return false;
		} else if (!RG.equals(other.RG))
			return false;
		if (contrata == null) {
			if (other.contrata != null)
				return false;
		} else if (!contrata.equals(other.contrata))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (residencia == null) {
			if (other.residencia != null)
				return false;
		} else if (!residencia.equals(other.residencia))
			return false;
		return true;
	}

}
