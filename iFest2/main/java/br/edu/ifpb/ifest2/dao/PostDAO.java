package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.PostFiltro;
import br.edu.ifpb.ifest2.entities.Post;

public class PostDAO extends DAO<Post> {
	
	public PostDAO() {
		super(Post.class);
	}

	public List<Post> findBy(PostFiltro filtro) {
		return null;
	}
	
}
