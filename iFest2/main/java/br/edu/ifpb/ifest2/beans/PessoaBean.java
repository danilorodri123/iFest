package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Pessoa;
import br.edu.ifpb.ifest2.services.PessoaService;

@ViewScoped
@Named
public class PessoaBean implements Serializable {

	@Inject
	private PessoaService pessoa;

	protected Pessoa entidade;

	protected Collection<Pessoa> entidades;

	public PessoaBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Pessoa entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Pessoa getEntidade() {
		return entidade;
	}

	public void setEntidade(Pessoa entidade) {
		this.entidade = entidade;
	}

	public Collection<Pessoa> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Pessoa> entidades) {
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

	protected Pessoa newEntidade() {
		return new Pessoa();
	}

	public PessoaService getService() {
		return pessoa;
	}

}
