package br.edu.ifpb.ifest2.interfaces;

import br.edu.ifpb.ifest2.entities.Cliente;
import br.edu.ifpb.ifest2.entities.Fornecedor;
import br.edu.ifpb.ifest2.entities.Post;

public interface IfestInt {

	Cliente cadastrarCliente(Cliente cliente);
	
	Fornecedor cadastrarFornecedor(Fornecedor fornecedor);

	Post publicar(Post post);

}
