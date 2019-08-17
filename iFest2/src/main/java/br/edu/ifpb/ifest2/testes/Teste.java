package br.edu.ifpb.ifest2.testes;

import static  org.junit.jupiter.api.Assertions.assertEquals ;
import static  org.junit.jupiter.api.Assertions.assertNotNull ;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Date;
import java.util.Set;

import org.junit.jupiter.api.Test;

import br.edu.ifpb.ifest2.entities.Cliente;
import br.edu.ifpb.ifest2.entities.Contrato;
import br.edu.ifpb.ifest2.entities.Fornecedor;
import br.edu.ifpb.ifest2.entities.Post;
import br.edu.ifpb.ifest2.entities.Servico;
import br.edu.ifpb.ifest2.interfaces.IfestInt;

public class Teste {
	
	@Test
	void cadastrarCliente() {
		IfestInt a =  null;
		Long id = null;
		String nome = null;
		Long telefone = null;
		String email = null;
		String senha = null;
		Cliente cliente = new Cliente(id, nome, telefone, email, senha);
		Cliente c = a . cadastrarCliente(cliente);
		assertNotNull (c);
		assertEquals ( " " , c . getId());
	}
	
	@Test
	void cadastrarFornecedor () {
		IfestInt a = null;
		Long id = null;
		String nome = null;
		Long telefone = null;
		String email = null;
		String senha = null;
		Fornecedor fornecedor= new Fornecedor(id, nome, telefone, email, senha);
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
		assertEquals(" " , p . getId());
	}
	  
	@Test
	void cadastrarServico() {
		IfestInt a = null;
		Long id = null;
		String descricao = null;
		String tipoServico = null;
		Date prazo = null;
		Servico servico = new Servico(id, descricao, tipoServico, prazo);
		Servico s = a.cadastrarServico(servico);
		assertNull(s);
		assertEquals(" " , s.getId());
	}
	
	@Test
	void contratarServico() {
		IfestInt a = null;
		Long id = null;
		Date dataInicio = null;
		Date dataTermino = null;
		Date prorrogacaoContrato = null;
		String indenizacao = null;
		Set<Servico> entrega = null;
		Set<Fornecedor> criaContrato = null;
		Set<Cliente> assinaContrato = null;
		Contrato contrato = new Contrato(id, dataInicio, dataTermino, prorrogacaoContrato, indenizacao, entrega, criaContrato, assinaContrato);
		Contrato cn = a.contratarServico(contrato);
		assertNull(cn);
		assertEquals(" ", cn.getId());
	}
	
}
