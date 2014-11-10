package br.com.mural.services;

import java.net.UnknownHostException;
import java.util.Date;
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

import br.com.mural.dao.EndUserDAO;
import br.com.mural.entity.Address;
import br.com.mural.entity.EndUser;

import com.sun.jersey.api.client.ClientResponse.Status;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@Path("/user")
@Api(value = "/mural/user", description = "User Management")
public class UserServices extends Service {

	EndUserDAO dao = new EndUserDAO();
	final static Logger logger = LoggerFactory
			.getLogger(ProfessionalServices.class);

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "POST", nickname = "createUser", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response createUser(String firstName, String lastName,
			List<Address> addresses, String cpf, Date birthDate, String email,
			String password) {

		UUID requestid = UUID.randomUUID();
		EndUser object = new EndUser(firstName, lastName, addresses, cpf,
				birthDate, email, password);
		try {
			dao.saveOrUpdate(object);
		} catch (UnknownHostException e) {
			return this.generateResponse(
					Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					requestid.toString(), null, "createUser", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(),
				requestid.toString(), object, "createUser", null, logger);
	}
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "PUT", nickname = "updateUser", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response updateUser(String id, String firstName, String lastName,
			List<Address> addresses, String cpf, Date birthDate, String email,
			String password) {
		UUID requestid = UUID.randomUUID();
		EndUser object = new EndUser(firstName, lastName, addresses, cpf,
				birthDate, email, password);
		object.setId(id);
		try {
			if (dao.find(id) != null) {
				dao.saveOrUpdate(object);
			} else {
				return this.generateResponse(Status.NOT_FOUND.getStatusCode(),
						requestid.toString(), null, "updateUser", null, logger);
			}
		} catch (UnknownHostException e) {
			return this.generateResponse(
					Status.INTERNAL_SERVER_ERROR.getStatusCode(),
					requestid.toString(), null, "updateUser", e, logger);
		}
		return this.generateResponse(Status.OK.getStatusCode(),
				requestid.toString(), object, "updateUser", null, logger);
	}

	@DELETE
	@PathParam("/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	@ApiOperation(httpMethod = "DELETE", nickname = "deleteUser", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response deleteUser(@PathParam(value="id") String id) {
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
	@ApiOperation(httpMethod = "GET", nickname = "searchUser", value = "", notes = "", produces = "application/json,application/xml", response = Response.class)
	public Response searchUser(List<String> searchParameters) {
		UUID requestid = UUID.randomUUID();
		return this.generateResponse(Status.NOT_IMPLEMENTED.getStatusCode(), requestid.toString(), null, "searchProfessional", null, logger);						
	}

}
