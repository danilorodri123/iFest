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

import br.edu.ifpb.ifest2.entities.Servico;
import br.edu.ifpb.ifest2.services.ServicoService;

@Path("/servico")
public class ServicoServiceRS {
	
	@Inject
	private ServicoService servicoService;
	
	// http://localhost:8080/ifest2/rest/cli/nome/1
		@GET
		@Path("/nome/{id}")
		@Produces("text/html")
		public String getNome(@PathParam("id") Long id) {
			return "<h1>"+servicoService.getByID(id).getTipoServico()+"</h1>";
		}

	// http://localhost:8080/ifest2/rest/user/list
		@GET
		@Path("/list")
		@Produces("text/html")
		public String list() {
			String retorno = "<ul>";
			List<Servico> servicos = servicoService.getAll();
			for(Servico s: servicos) {
				retorno += "<li>"+s.getTipoServico()+"</li>";
			}
			return retorno + "</ul>";
		}
		
		
		public ServicoService getServicoService() {
			return servicoService;
		}
		
		public void setUserService(ServicoService servicoService) {
			this.servicoService = servicoService;
		}	
}
