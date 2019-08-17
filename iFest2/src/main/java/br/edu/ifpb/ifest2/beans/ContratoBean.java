package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Contrato;
import br.edu.ifpb.ifest2.services.ContratoService;

@ViewScoped
@Named
public class ContratoBean implements Serializable {

	@Inject
	private ContratoService contrato;

	protected Contrato entidade;

	protected Collection<Contrato> entidades;

	public ContratoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Contrato entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Contrato getEntidade() {
		return entidade;
	}

	public void setEntidade(Contrato entidade) {
		this.entidade = entidade;
	}

	public Collection<Contrato> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Contrato> entidades) {
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

	protected Contrato newEntidade() {
		return new Contrato();
	}

	public ContratoService getService() {
		return contrato;
	}

}
