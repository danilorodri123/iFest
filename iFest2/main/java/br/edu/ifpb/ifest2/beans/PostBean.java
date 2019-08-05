package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Post;
import br.edu.ifpb.ifest2.services.PostService;

@ViewScoped
@Named
public class PostBean implements Serializable {

	@Inject
	private PostService post;

	protected Post entidade;

	protected Collection<Post> entidades;

	public PostBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Post entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Post getEntidade() {
		return entidade;
	}

	public void setEntidade(Post entidade) {
		this.entidade = entidade;
	}

	public Collection<Post> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Post> entidades) {
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

	protected Post newEntidade() {
		return new Post();
	}

	public PostService getService() {
		return post;
	}

}
