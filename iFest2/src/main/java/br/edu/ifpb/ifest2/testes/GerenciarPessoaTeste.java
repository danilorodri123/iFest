package br.edu.ifpb.ifest2.testes;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.ifest2.entities.Pessoa;
import br.edu.ifpb.ifest2.services.PessoaService;

public class GerenciarPessoaTeste {
	
	@Test
	@DisplayName("Teste classe Pessoa")
	public void gerenciarPessoa() {
		PessoaService service = new PessoaService();
		Pessoa ps = new Pessoa();
		ps.setNome("b");
		service.save(ps);
		
		assertNotNull(ps.getId());
		
		Pessoa ps2 = service.getByID(ps.getId());
		assertEquals(ps,ps2);
		service.update(ps);
		
		Pessoa ps3 = service.getByID(0);
		assertEquals("Breno",ps3.getNome());
		service.remove(ps2);
		
		Pessoa ps4 = service.getByID(0);
		assertNull(ps4);
	}

}
