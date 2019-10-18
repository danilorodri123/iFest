package br.edu.ifpb.ifest2.beans;

import java.io.IOException;
import java.security.Principal;
import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	public String getUserLogin() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		Principal userPrincipal = externalContext.getUserPrincipal();
		if (userPrincipal == null) {
			return "";
		}
		return userPrincipal.getName();
	}

	public void efetuarLogout() throws IOException, ServletException {
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();
		HttpSession session = (HttpSession) ec.getSession(false);
		session.invalidate();
		HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.logout();
		ec.redirect(ec.getApplicationContextPath());
	}

	public boolean isUserInRole(String role) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		return externalContext.isUserInRole(role);
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
