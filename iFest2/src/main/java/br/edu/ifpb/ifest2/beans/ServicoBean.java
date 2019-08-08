package br.edu.ifpb.ifest2.beans;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.edu.ifpb.ifest2.entities.Servico;
import br.edu.ifpb.ifest2.services.ServicoService;

@ViewScoped
@Named
public class ServicoBean implements Serializable {

	@Inject
	private ServicoService servico;

	protected Servico entidade;

	protected Collection<Servico> entidades;

	public ServicoBean() {
	}
	
	@PostConstruct
	public void init() {
		entidade = newEntidade();
		entidades = getService().getAll();
	}

	public void remove(Servico entidade) {
		getService().remove(entidade);
		limpar();
	}

	public Servico getEntidade() {
		return entidade;
	}

	public void setEntidade(Servico entidade) {
		this.entidade = entidade;
	}

	public Collection<Servico> getEntidades() {
		return entidades;
	}

	public void setEntidades(Collection<Servico> entidades) {
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

	protected Servico newEntidade() {
		return new Servico();
	}

	public ServicoService getService() {
		return servico;
	}

}
