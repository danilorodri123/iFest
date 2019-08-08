package br.edu.ifpb.ifest2.services;

import java.util.List;

import br.edu.ifpb.ifest2.entities.Identificavel;

public interface Service<E extends Identificavel> {

	void save(E e);

	void update(E e);

	void remove(E e);

	E getByID(long userId);

	List<E> getAll();

}