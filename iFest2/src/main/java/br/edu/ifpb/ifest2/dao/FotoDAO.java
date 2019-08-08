package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.FotoFiltro;
import br.edu.ifpb.ifest2.entities.Foto;

public class FotoDAO extends DAO<Foto> {
	
	public FotoDAO() {
		super(Foto.class);
	}

	public List<Foto> findBy(FotoFiltro filtro) {
		return null;
	}
	
}
