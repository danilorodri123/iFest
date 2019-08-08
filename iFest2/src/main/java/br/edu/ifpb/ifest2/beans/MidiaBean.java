package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Midia;
import br.edu.ifpb.ifest2.services.MidiaService;

@ViewScoped
@Named
public class MidiaBean implements Serializable {

	@Inject
	private MidiaService midia;

	protected Midia entidade;

	protected Collection<Midia> entidades;

	public MidiaBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Midia entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Midia getEntidade() {
		return entidade;
	}

	public void setEntidade(Midia entidade) {
		this.entidade = entidade;
	}

	public Collection<Midia> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Midia> entidades) {
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

	protected Midia newEntidade() {
		return new Midia();
	}

	public MidiaService getService() {
		return midia;
	}

}
