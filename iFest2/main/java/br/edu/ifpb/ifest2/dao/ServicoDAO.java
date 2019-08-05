package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.ServicoFiltro;
import br.edu.ifpb.ifest2.entities.Servico;

public class ServicoDAO extends DAO<Servico> {
	
	public ServicoDAO() {
		super(Servico.class);
	}

	public List<Servico> findBy(ServicoFiltro filtro) {
		return null;
	}
	
}
