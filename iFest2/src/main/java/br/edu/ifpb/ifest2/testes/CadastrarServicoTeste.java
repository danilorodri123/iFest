package br.edu.ifpb.ifest2.testes;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.ifest2.entities.Servico;
import br.edu.ifpb.ifest2.services.ServicoService;

public class CadastrarServicoTeste {
	
	@Test
	@DisplayName("Teste classe Servico")
	public void adicionaCliente() {
		ServicoService service = new ServicoService();
		Servico s = new Servico();
		s.setTipoServico("b");
		service.save(s);
		
		assertNotNull(s.getId());
		
		Servico s2 = service.getByID(s.getId());
		assertEquals(s,s2);
		service.update(s);
		
		Servico s3 = service.getByID(0);
		assertEquals("buffet",s3.getTipoServico());
		service.remove(s2);
		
		Servico s4 = service.getByID(0);
		assertNull(s4);
	}

}
