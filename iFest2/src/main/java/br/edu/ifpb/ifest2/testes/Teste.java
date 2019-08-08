package br.edu.ifpb.ifest2.testes;

import static  org.junit.jupiter.api.Assertions.assertEquals ;
import static  org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import br.edu.ifpb.ifest2.entities.Cliente;
import br.edu.ifpb.ifest2.entities.Fornecedor;
import br.edu.ifpb.ifest2.entities.Post;
import br.edu.ifpb.ifest2.interfaces.IfestInt;

public class Teste {
	
	@Test
	void cadastrarCliente() {
		IfestInt a =  null;
		Cliente cliente =  new Cliente();
		Cliente c = a . cadastrarCliente(cliente);
		assertNotNull (c);
		assertEquals ( " " , c . getId());
	}
	
	@Test
	void cadastrarFornecedor () {
		IfestInt a = null;
		Fornecedor fornecedor = new Fornecedor();
		Fornecedor f = a . cadastrarFornecedor(fornecedor);
		assertNull(f);
		assertEquals(" " , f . getId());
	}
	
	@Test
	void publicar() {
		IfestInt a = null;
		Post post = new Post();
		Post p = a . publicar(post);
		assertNull(p);
		assertEquals("" , p . getId());
	}
	
	

}
