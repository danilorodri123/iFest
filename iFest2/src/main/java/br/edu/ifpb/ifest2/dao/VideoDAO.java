package br.edu.ifpb.ifest2.dao;

import java.util.List;

import br.edu.ifpb.ifest2.filtros.VideoFiltro;
import br.edu.ifpb.ifest2.entities.Video;

public class VideoDAO extends DAO<Video> {
	
	public VideoDAO() {
		super(Video.class);
	}

	public List<Video> findBy(VideoFiltro filtro) {
		return null;
	}
	
}
