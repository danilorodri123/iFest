package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Fornecedor;
import br.edu.ifpb.ifest2.services.FornecedorService;

@ViewScoped
@Named
public class FornecedorBean implements Serializable {

	@Inject
	private FornecedorService fornecedor;

	protected Fornecedor entidade;

	protected Collection<Fornecedor> entidades;

	public FornecedorBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Fornecedor entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Fornecedor getEntidade() {
		return entidade;
	}

	public void setEntidade(Fornecedor entidade) {
		this.entidade = entidade;
	}

	public Collection<Fornecedor> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Fornecedor> entidades) {
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

	protected Fornecedor newEntidade() {
		return new Fornecedor();
	}

	public FornecedorService getService() {
		return fornecedor;
	}

}
