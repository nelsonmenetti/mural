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

import br.com.mural.dao.EnterpriseDAO;
import br.com.mural.entity.Address;
import br.com.mural.entity.Enterprise;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/enterprise")
@Api(value = "/mural/enterprise", description = "Enterprise Management")
public class EnterpriseServices extends Service {

	EnterpriseDAO dao = new EnterpriseDAO();
	final static Logger logger = LoggerFactory.getLogger(EnterpriseServices.class);
	
	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "POST", nickname = "createEnterprise", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response createEnterprise(String name, List<Address> addresses, String cnpj,
			String startingDate, List<String> keywords, String serviceSummary,
			String site, String portfolio){
		UUID requestid = UUID.randomUUID();
		Enterprise object = new Enterprise( name, addresses,  cnpj,
				 startingDate, keywords,  serviceSummary,
				 site,  portfolio);
		try {			
			dao.saveOrUpdate(object);
		} catch (UnknownHostException e) {
			return this.generateResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), requestid.toString(), null, "createEnterprise", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(), requestid.toString(), object, "createEnterprise", null, logger);			
	}

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "PUT", nickname = "updateEnterprise", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response updateEnterprise(String id,String name, List<Address> addresses, String cnpj,
			String startingDate, List<String> keywords, String serviceSummary,
			String site, String portfolio){
		UUID requestid = UUID.randomUUID();
		Enterprise object = new Enterprise( name, addresses,  cnpj,
				 startingDate, keywords,  serviceSummary,
				 site,  portfolio);
		object.setId(id);
		try {		
			if (dao.find(id) != null){
				dao.saveOrUpdate(object);
			}else{
				return this.generateResponse(Status.NOT_FOUND.getStatusCode(), requestid.toString(), null, "updateEnterprise", null, logger);
			}
		} catch (UnknownHostException e) {
			return this.generateResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), requestid.toString(), null, "updateEnterprise", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(), requestid.toString(), object, "updateEnterprise", null, logger);			
	}
	
	@DELETE
	@PathParam("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "DELETE", nickname = "deleteEnterprise", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response deleteEnterprise(@PathParam(value="id") String id){
		UUID requestid = UUID.randomUUID();
		try {		
			if (dao.find(id) != null){
				dao.delete(id);
			}else{
				return this.generateResponse(Status.NOT_FOUND.getStatusCode(), requestid.toString(), null, "deleteEnterprise", null, logger);
			}
		} catch (UnknownHostException e) {
			return this.generateResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), requestid.toString(), null, "deleteEnterprise", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(), requestid.toString(), null, "deleteEnterprise", null, logger);			
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "GET", nickname = "searchEnterprise", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response searchEnterprise(List<String> searchParameters){
		UUID requestid = UUID.randomUUID();
		return this.generateResponse(Status.NOT_IMPLEMENTED.getStatusCode(), requestid.toString(), null, "deleteEnterprise", null, logger);						
	}
}
