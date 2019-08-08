package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.MidiaFiltro;
import br.edu.ifpb.ifest2.entities.Midia;

public class MidiaDAO extends DAO<Midia> {
	
	public MidiaDAO() {
		super(Midia.class);
	}

	public List<Midia> findBy(MidiaFiltro filtro) {
		return null;
	}
	
}
