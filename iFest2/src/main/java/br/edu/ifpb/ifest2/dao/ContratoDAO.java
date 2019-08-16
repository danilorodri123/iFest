package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.entities.Contrato;
import br.edu.ifpb.ifest2.filtros.ContratoFiltro;

public class ContratoDAO extends DAO<Contrato> {
	
	public ContratoDAO() {
		super(Contrato.class);
	}

	public List<Contrato> findBy(ContratoFiltro filtro) {
		return null;
	}
	
}
