package br.edu.ifpb.ifest2.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "POST")
public class Post implements Identificavel{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="post_descricao")
	private String descricao;
	
	@Column(name="post_comentario")
	private String comentario;
	
	@Column(name="post_curtidas")
	private Long curtidas;
	
	@OneToMany
	@JoinColumn(name="post_midia")
	private Set<Midia>possui;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getComenterio() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Long getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(Long curtidas) {
		this.curtidas = curtidas;
	}

	public Set<Midia> getPossui() {
		return possui;
	}

	public void setPossui(Set<Midia> possui) {
		this.possui = possui;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", descricao=" + descricao + ", comenterio=" + comentario + ", curtidas=" + curtidas
				+ ", possui=" + possui + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((curtidas == null) ? 0 : curtidas.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((possui == null) ? 0 : possui.hashCode());
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
		Post other = (Post) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (curtidas == null) {
			if (other.curtidas != null)
				return false;
		} else if (!curtidas.equals(other.curtidas))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (possui == null) {
			if (other.possui != null)
				return false;
		} else if (!possui.equals(other.possui))
			return false;
		return true;
	}
	
	
}
