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

import br.edu.ifpb.ifest2.entities.Contrato;
import br.edu.ifpb.ifest2.services.ContratoService;

@Path("/contrato")
public class ContratoServiceRS {
	
	@Inject
	private ContratoService contratoService;
	
	// http://localhost:8080/ifest2/rest/cli/nome/1
		@GET
		@Path("/nome/{id}")
		@Produces("text/html")
		public String getNome(@PathParam("id") Long id) {
			return "<h1>"+ Contrato.getByID(id).getNome()+"</h1>";
		}

	// http://localhost:8080/ifest2/rest/user/list
		@GET
		@Path("/list")
		@Produces("text/html")
		public String list() {
			String retorno = "<ul>";
			List<Contrato> contrato = contratoService.getAll();
			for(Contrato c: contrato) {
				retorno += "<li>"+c.getNome()+"</li>";
			}
			return retorno + "</ul>";
		}
		
	// http://localhost:8080/ifest2/rest/user/add/pessoa;nome=Hugo%20Feitosa;password=123;id=3;email=hg@hg.com;username=hugoff
		@GET
		@Path("/add/{contrato}")
		public String add(@PathParam("contrato") PathSegment atributos) {
			MultivaluedMap<String, String> matrixParameters = atributos.getMatrixParameters();
			String dataInicio = matrixParameters.getFirst("inicio");
			String dataTermino = matrixParameters.getFirst("termino");
			String id = matrixParameters.getFirst("id");
			String prorrogacaoContrato = matrixParameters.getFirst("prorrogacao");
			String indenizacao = matrixParameters.getFirst("indenizacao");
			Contrato c = new Contrato();
			c.setDataInicio(dataInicio);
			c.setId(Long.parseLong(id));
			c.setDataTermino(dataTermino);
			c.setProrrogacaoContrato(prorrogacaoContrato);
			c.setIndenizacao(indenizacao);
			contratoService.save(c);
			return "Salvo com sucesso";
		}
		
		public ContratoService getContratoService() {
			return contratoService;
		}
		
		public void setUserService(ContratoService contratoService) {
			this.contratoService = contratoService;
		}	
}
