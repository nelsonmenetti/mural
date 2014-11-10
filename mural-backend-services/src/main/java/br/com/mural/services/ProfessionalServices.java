package br.com.mural.services;

import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.mural.dao.ProfessionalDAO;
import br.com.mural.entity.Address;
import br.com.mural.entity.Professional;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/professional")
@Api(value = "/mural/professional", description = "Professional Management")
public class ProfessionalServices extends Service{

	ProfessionalDAO dao = new ProfessionalDAO();
	final static Logger logger = LoggerFactory.getLogger(ProfessionalServices.class);
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "POST", nickname = "createProfessional", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response createProfessional(String name, List<Address> addresses, String cpf,
			String birthDate, List<String> keywords, String serviceSummary,
			String site, String portfolio){
		UUID requestid = UUID.randomUUID();
		Professional object = new Professional( name,  addresses,  cpf,
				 birthDate, keywords,  serviceSummary,
				 site,  portfolio);
		try {			
			dao.saveOrUpdate(object);
		} catch (UnknownHostException e) {
			return this.generateResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), requestid.toString(), null, "createProfessional", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(), requestid.toString(), object, "createProfessional", null, logger);			
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "PUT", nickname = "updateProfessional", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response updateProfessional(String id ,String name, List<Address> addresses, String cpf,
			String birthDate, List<String> keywords, String serviceSummary,
			String site, String portfolio){
		UUID requestid = UUID.randomUUID();
		Professional object = new Professional( name,  addresses,  cpf,
				 birthDate, keywords,  serviceSummary,
				 site,  portfolio);
		object.setId(id);
		try {		
			if (dao.find(id) != null){
				dao.saveOrUpdate(object);
			}else{
				return this.generateResponse(Status.NOT_FOUND.getStatusCode(), requestid.toString(), null, "updateProfessional", null, logger);
			}
		} catch (UnknownHostException e) {
			return this.generateResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), requestid.toString(), null, "updateProfessional", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(), requestid.toString(), object, "updateProfessional", null, logger);			
	}
	
	@DELETE
	@PathParam("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "DELETE", nickname = "deleteProfessional", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response deleteProfessional(@PathParam(value="id")String id){
		UUID requestid = UUID.randomUUID();
		try {		
			if (dao.find(id) != null){
				dao.delete(id);
			}else{
				return this.generateResponse(Status.NOT_FOUND.getStatusCode(), requestid.toString(), null, "deleteProfessional", null, logger);
			}
		} catch (UnknownHostException e) {
			return this.generateResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), requestid.toString(), null, "deleteProfessional", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(), requestid.toString(), null, "deleteProfessional", null, logger);			
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "GET", nickname = "searchProfessional", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response searchProfessional(){
		UUID requestid = UUID.randomUUID();
		return this.generateResponse(Status.NOT_IMPLEMENTED.getStatusCode(), requestid.toString(), null, "searchProfessional", null, logger);						
	}

}
