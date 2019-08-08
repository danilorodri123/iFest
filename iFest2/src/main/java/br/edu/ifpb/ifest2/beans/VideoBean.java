package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Video;
import br.edu.ifpb.ifest2.services.VideoService;

@ViewScoped
@Named
public class VideoBean implements Serializable {

	@Inject
	private VideoService video;

	protected Video entidade;

	protected Collection<Video> entidades;

	public VideoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Video entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Video getEntidade() {
		return entidade;
	}

	public void setEntidade(Video entidade) {
		this.entidade = entidade;
	}

	public Collection<Video> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Video> entidades) {
		this.entidades = entidades;
	}

	public void save() {
		getService().save(entidade);
		limpar();
	}

	public void editar(Long id) {
		this.getEntidade().setId(id);
		save();
	}

	public void limpar() {
		entidades = getService().getAll();
		entidade = newEntidade();
	}

	protected Video newEntidade() {
		return new Video();
	}

	public VideoService getService() {
		return video;
	}

}
