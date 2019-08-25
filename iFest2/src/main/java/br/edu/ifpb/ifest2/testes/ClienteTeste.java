package br.edu.ifpb.ifest2.testes;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.ifest2.entities.Cliente;
import br.edu.ifpb.ifest2.services.ClienteService;

public class ClienteTeste {
	
	@Test
	@DisplayName("Teste classe Cliente")
	public void adicionaCliente() {
		ClienteService service = new ClienteService();
		Cliente c = new Cliente();
		c.setNome("a");
		service.save(c);
		
		assertNotNull(c.getId());
		
		Cliente c2 = service.getByID(c.getId());
		assertEquals(c,c2);
		service.update(c);
		
		Cliente c3 = service.getByID(0);
		assertEquals("Ana",c3.getNome());
		service.remove(c2);
		
		Cliente c4 = service.getByID(0);
		assertNull(c4);
	}

}
