package br.edu.ifpb.ifest2.webservices;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

import br.edu.ifpb.ifest2.entities.Pessoa;
import br.edu.ifpb.ifest2.services.PessoaService;

@Path("/pessoa")
public class PessoaServiceRS {
	
	@Inject
	private PessoaService pessoaService;
	
	// http://localhost:8080/ifest2/rest/cli/nome/1
		@GET
		@Path("/nome/{id}")
		@Produces("text/html")
		public String getNome(@PathParam("id") Long id) {
			return "<h1>"+pessoaService.getByID(id).getNome()+"</h1>";
		}

	// http://localhost:8080/ifest2/rest/user/list
		@GET
		@Path("/list")
		@Produces("text/html")
		public String list() {
			String retorno = "<ul>";
			List<Pessoa> pessoas = pessoaService.getAll();
			for(Pessoa p: pessoas) {
				retorno += "<li>"+p.getNome()+"</li>";
			}
			return retorno + "</ul>";
		}
		
	// http://localhost:8080/ifest2/rest/user/add/pessoa;nome=Hugo%20Feitosa;password=123;id=3;email=hg@hg.com;username=hugoff
		@GET
		@Path("/add/{user}")
		public String add(@PathParam("user") PathSegment atributos) {
			MultivaluedMap<String, String> matrixParameters = atributos.getMatrixParameters();
			String nome = matrixParameters.getFirst("nome");
			String email = matrixParameters.getFirst("email");
			String id = matrixParameters.getFirst("id");
			String password = matrixParameters.getFirst("password");
			String username = matrixParameters.getFirst("username");
			Pessoa p = new Pessoa();
			p.setEmail(email);
			p.setGrupo("OUTROS");
			p.setId(Long.parseLong(id));
			p.setNome(nome);
			p.setSenha(password);
			p.setEmail(username);
			pessoaService.save(p);
			return "Salvo com sucesso";
		}
		
		public PessoaService getPessoaService() {
			return pessoaService;
		}
		
		public void setUserService(PessoaService pessoaService) {
			this.pessoaService = pessoaService;
		}	
}
