package br.edu.ifpb.ifest2.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MIDIA")
public class Midia implements Identificavel{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany
	@JoinColumn(name="midia_foto")
	private Set<Foto>possui;
	
	@OneToMany
	@JoinColumn(name="midia_video")
	private Set<Video>tem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Foto> getPossui() {
		return possui;
	}
	public void setPossui(Set<Foto> possui) {
		this.possui = possui;
	}
	public Set<Video> getTem() {
		return tem;
	}
	public void setTem(Set<Video> tem) {
		this.tem = tem;
	}
	
	@Override
	public String toString() {
		return "Midia [id=" + id + ", possui=" + possui + ", tem=" + tem + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((possui == null) ? 0 : possui.hashCode());
		result = prime * result + ((tem == null) ? 0 : tem.hashCode());
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
		Midia other = (Midia) obj;
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
		if (tem == null) {
			if (other.tem != null)
				return false;
		} else if (!tem.equals(other.tem))
			return false;
		return true;
	}
	

}
