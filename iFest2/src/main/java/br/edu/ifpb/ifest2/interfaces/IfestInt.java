package br.edu.ifpb.ifest2.interfaces;

import br.edu.ifpb.ifest2.entities.Cliente;
import br.edu.ifpb.ifest2.entities.Contrato;
import br.edu.ifpb.ifest2.entities.Fornecedor;
import br.edu.ifpb.ifest2.entities.Pessoa;
import br.edu.ifpb.ifest2.entities.Post;
import br.edu.ifpb.ifest2.entities.Servico;

public interface IfestInt {

	Fornecedor cadastrarFornecedor(Fornecedor fornecedor);

	Post publicar(Post post);

	Servico cadastrarServico(Servico servico);

	Contrato contratarServico(Contrato contrato);

	Cliente cadastrarCliente(Cliente cliente);

	Pessoa gerenciarPessoa(Pessoa pessoa);

}
