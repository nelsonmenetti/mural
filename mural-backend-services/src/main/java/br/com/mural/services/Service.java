/*
 * Pearson All Rights Reserved
 * Nelson Fernando da Silva Menetti - Developer 
 */
package br.com.mural.services;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;

import br.com.mural.util.PropertiesUtil;
import br.com.mural.util.RestResponseWrapper;
import br.com.mural.util.ResultTypes;

/**
 * The Class Service.
 */
public class Service {

	

	/**
	 * Generate response.
	 *
	 * @param httpCode the http code
	 * @param requestId the request id
	 * @param data the data
	 * @param methodName the method name
	 * @param e the e
	 * @param logger the logger
	 * @return the response
	 */
	public Response generateResponse(int httpCode, String requestId,
			Object data, String methodName, Exception e, Logger logger) {
		RestResponseWrapper wrapper = new RestResponseWrapper();
		wrapper.setRequestId(requestId);
		wrapper.setCode(httpCode);
		wrapper.setData(data);
		if (httpCode == 404) {
			wrapper.setStatus(ResultTypes.Fail.getType());
			logger.info("Method : " + methodName + " |RequestId :" + requestId
					+ " |Result:" + wrapper);
			return Response.status(Response.Status.NOT_FOUND).entity(wrapper)
					.build();
		} else if (httpCode == 400) {
			wrapper.setStatus(ResultTypes.Fail.getType());
			logger.info("Method : " + methodName + " |RequestId :" + requestId
					+ " |Result:" + wrapper);
			return Response.status(Response.Status.BAD_REQUEST).entity(wrapper)
					.build();
		} else if (httpCode == 500) {
			wrapper.setStatus(ResultTypes.Error.getType());
			logger.error("Method : " + methodName + " |RequestId :" + requestId
					+ " |Result:" + wrapper, e);
			return Response.serverError().entity(wrapper).build();
		} else if (httpCode == 200 || httpCode == 201) {
			wrapper.setStatus(ResultTypes.Success.getType());
			logger.debug("Method : " + methodName + " |RequestId :" + requestId
					+ " |Result:" + wrapper);
			return Response.ok().entity(wrapper).build();
		} else {
			wrapper.setStatus(ResultTypes.Fail.getType());
			logger.info("Method : " + methodName + " |RequestId :" + requestId
					+ " |Result:" + wrapper);
			return Response.status(httpCode).entity(wrapper).build();
		}
	}


}
