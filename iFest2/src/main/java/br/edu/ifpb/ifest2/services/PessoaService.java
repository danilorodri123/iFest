package br.edu.ifpb.ifest2.services;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
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
		pessoa.setPassword(hash(pessoa.getPassword()));
		pessoaDAO.save(pessoa);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.ifpb.esperanca.daw2.services.Service#save(br.edu.ifpb.esperanca.daw2.
	 * ifoto.entities.Usuario)
	 */
	
	private String hash(String password) {
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes("UTF-8"));
			byte[] digest = md.digest();
			String output = Base64.getEncoder().encodeToString(digest);
			return output;
		} catch (Exception e) {
			return password;
		}
	}
	
	@Override
	@TransacionalCdi
	public void update(Pessoa pessoa)  {
		pessoaDAO.update(pessoa);
	}

	
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
