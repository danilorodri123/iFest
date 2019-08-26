package br.edu.ifpb.ifest2.testes;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.ifest2.entities.Post;
import br.edu.ifpb.ifest2.services.PostService;

public class PublicarTeste {
	
	@Test
	@DisplayName("Teste classe Post")
	public void adicionaCliente() {
		PostService service = new PostService();
		Post p = new Post();
		p.setDescricao("d");
		service.save(p);
		
		assertNotNull(p.getId());
		
		Post p2 = service.getByID(p.getId());
		assertEquals(p,p2);
		service.update(p);
		
		Post p3 = service.getByID(0);
		assertEquals("descricao",p3.getDescricao());
		service.remove(p2);
		
		Post p4 = service.getByID(0);
		assertNull(p4);
	}

}
