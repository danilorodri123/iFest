package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.ClienteFiltro;
import br.edu.ifpb.ifest2.entities.Cliente;

public class ClienteDAO extends DAO<Cliente> {
	
	public ClienteDAO() {
		super(Cliente.class);
	}

	public List<Cliente> findBy(ClienteFiltro filtro) {
		return null;
	}
	
}
