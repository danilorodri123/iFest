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
import javax.persistence.Table;

@Entity
@Table(name="FORNECEDOR")
@Inheritance(strategy=InheritanceType.JOINED)

public class Fornecedor extends Pessoa{
	
	public Fornecedor(Long id, String nome, Long telefone, String email, String senha) {
		super(id, nome, telefone, email, senha);
	}
	
	@Id
	@GeneratedValue
	@Column(name="fornecedor_id")
	private Long id;

	@Column(name="fornecedor_nomeemp")
	private String nomeemp;
	
	@Column(name="fornecedor_cnpj")
	private Long CNPJ;	
	
	@Column(name="fornecedor_posta")
	private Set<Post> posta;
	
	@OneToMany
	@JoinColumn(name="fornecedor_servico")
	private Set<Servico> oferece;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeemp() {
		return nomeemp;
	}
	public void setNomeemp(String nomeemp) {
		this.nomeemp = nomeemp;
	}
	public Long getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(Long cNPJ) {
		CNPJ = cNPJ;
	}
	public Set<Post> getPosta() {
		return posta;
	}
	public void setPosta(Set<Post> posta) {
		this.posta = posta;
	}
	public Set<Servico> getOferece() {
		return oferece;
	}
	public void setOferece(Set<Servico> oferece) {
		this.oferece = oferece;
	}
	public Fornecedor(Long id, String nome, Long telefone, String email, String senha, Long id2, String nomeemp,
			Long cNPJ, Set<Post> posta, Set<Servico> oferece) {
		super(id, nome, telefone, email, senha);
		id = id2;
		this.nomeemp = nomeemp;
		CNPJ = cNPJ;
		this.posta = posta;
		this.oferece = oferece;
	}
	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", nomeemp=" + nomeemp + ", CNPJ=" + CNPJ + ", posta=" + posta + ", oferece="
				+ oferece + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((CNPJ == null) ? 0 : CNPJ.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeemp == null) ? 0 : nomeemp.hashCode());
		result = prime * result + ((oferece == null) ? 0 : oferece.hashCode());
		result = prime * result + ((posta == null) ? 0 : posta.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (CNPJ == null) {
			if (other.CNPJ != null)
				return false;
		} else if (!CNPJ.equals(other.CNPJ))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeemp == null) {
			if (other.nomeemp != null)
				return false;
		} else if (!nomeemp.equals(other.nomeemp))
			return false;
		if (oferece == null) {
			if (other.oferece != null)
				return false;
		} else if (!oferece.equals(other.oferece))
			return false;
		if (posta == null) {
			if (other.posta != null)
				return false;
		} else if (!posta.equals(other.posta))
			return false;
		return true;
	}

	
}
