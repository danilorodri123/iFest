package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.EnderecoFiltro;
import br.edu.ifpb.ifest2.entities.Endereco;

public class EnderecoDAO extends DAO<Endereco> {
	
	public EnderecoDAO() {
		super(Endereco.class);
	}

	public List<Endereco> findBy(EnderecoFiltro filtro) {
		return null;
	}
	
}
