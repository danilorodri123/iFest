package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.FornecedorFiltro;
import br.edu.ifpb.ifest2.entities.Fornecedor;

public class FornecedorDAO extends DAO<Fornecedor> {
	
	public FornecedorDAO() {
		super(Fornecedor.class);
	}

	public List<Fornecedor> findBy(FornecedorFiltro filtro) {
		return null;
	}
	
}
