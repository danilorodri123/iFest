package br.edu.ifpb.ifest2.entities;

import java.util.Set;

public class Post {
	
	private Long id;
	private String descricao;
	private String comenterio;
	private Long curtidas;
	
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
		return comenterio;
	}

	public void setComenterio(String comenterio) {
		this.comenterio = comenterio;
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

	public Post(Long id, String descricao, String comenterio, Long curtidas, Set<Midia> possui) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.comenterio = comenterio;
		this.curtidas = curtidas;
		this.possui = possui;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", descricao=" + descricao + ", comenterio=" + comenterio + ", curtidas=" + curtidas
				+ ", possui=" + possui + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comenterio == null) ? 0 : comenterio.hashCode());
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
		if (comenterio == null) {
			if (other.comenterio != null)
				return false;
		} else if (!comenterio.equals(other.comenterio))
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
