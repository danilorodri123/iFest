package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Endereco;
import br.edu.ifpb.ifest2.services.EnderecoService;

@ViewScoped
@Named
public class EnderecoBean implements Serializable {

	@Inject
	private EnderecoService endereco;

	protected Endereco entidade;

	protected Collection<Endereco> entidades;

	public EnderecoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Endereco entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Endereco getEntidade() {
		return entidade;
	}

	public void setEntidade(Endereco entidade) {
		this.entidade = entidade;
	}

	public Collection<Endereco> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Endereco> entidades) {
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

	protected Endereco newEntidade() {
		return new Endereco();
	}

	public EnderecoService getService() {
		return endereco;
	}

}
