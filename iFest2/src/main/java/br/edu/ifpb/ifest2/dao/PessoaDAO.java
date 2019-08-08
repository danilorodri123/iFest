package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.PessoaFiltro;
import br.edu.ifpb.ifest2.entities.Pessoa;

public class PessoaDAO extends DAO<Pessoa> {
	
	public PessoaDAO() {
		super(Pessoa.class);
	}

	public List<Pessoa> findBy(PessoaFiltro filtro) {
		return null;
	}
	
}
