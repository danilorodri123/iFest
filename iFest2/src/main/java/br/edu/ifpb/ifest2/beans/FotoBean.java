package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Foto;
import br.edu.ifpb.ifest2.services.FotoService;

@ViewScoped
@Named
public class FotoBean implements Serializable {

	@Inject
	private FotoService foto;

	protected Foto entidade;

	protected Collection<Foto> entidades;

	public FotoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Foto entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Foto getEntidade() {
		return entidade;
	}

	public void setEntidade(Foto entidade) {
		this.entidade = entidade;
	}

	public Collection<Foto> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Foto> entidades) {
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

	protected Foto newEntidade() {
		return new Foto();
	}

	public FotoService getService() {
		return foto;
	}

}
