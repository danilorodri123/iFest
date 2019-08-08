package br.edu.ifpb.ifest2.services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.edu.ifpb.ifest2.dao.PessoaDAO;
import br.edu.ifpb.ifest2.entities.Pessoa;
import br.edu.ifpb.ifest2.util.TransacionalCdi;

@ApplicationScoped
public class PessoaService implements Serializable, Service<Pessoa> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7803325791425670859L;
	
	@Inject
	private PessoaDAO pessoaDAO;
	
	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#save(br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario)
	 */
	@Override
	@TransacionalCdi
	public void save(Pessoa pessoa) {
		pessoaDAO.save(pessoa);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#update(br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario, boolean)
	 */
	@Override
	@TransacionalCdi
	public void update(Pessoa pessoa)  {
		pessoaDAO.update(pessoa);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#delete(br.edu.ifpb.esperanca.daw2.ifoto.entities.Usuario)
	 */
	@Override
	@TransacionalCdi
	public void remove(Pessoa pessoa) {
		pessoaDAO.remove(pessoa);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getByID(long)
	 */
	@Override
	public Pessoa getByID(long pessoaId)  {
			return pessoaDAO.getByID(pessoaId);
	}

	/* (non-Javadoc)
	 * @see br.edu.ifpb.esperanca.daw2.services.Service#getAll()
	 */
	@Override
	public List<Pessoa> getAll() {
			return pessoaDAO.getAll();
	}
		
}
