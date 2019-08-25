package br.edu.ifpb.ifest2.testes;

import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpb.ifest2.entities.Cliente;
import br.edu.ifpb.ifest2.entities.Fornecedor;
import br.edu.ifpb.ifest2.services.FornecedorService;

public class FornecedorTeste {
	
	@Test
	@DisplayName("Teste classe Fornecedor")
	public void adicionarFornecedor() {
		FornecedorService service = new FornecedorService();
		Fornecedor f = new Fornecedor();
		f.setNome("b");
		service.save(f);
		
		assertNotNull(f.getId());
		
		Fornecedor f2 = service.getByID(f.getId());
		assertEquals(f, f2);
		service.update(f);
		
		Fornecedor f3 = service.getByID(0);
		assertEquals("Bruno", f3.getNome());
		service.remove(f2);
		
		Fornecedor f4 = service.getByID(0);
		assertNull(f4);
	}

}
