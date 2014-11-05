/*
 * Pearson All Rights Reserved
 * Nelson Fernando da Silva Menetti - Developer 
 */
package br.com.mural.util;

import java.io.Serializable;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * The Class RestResponseWrapper.
 */
@ApiModel( value = "ResponseWrapper", description = "Wrapper of the Response" )
public class RestResponseWrapper implements Serializable{
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 13323432L;
	
	/** The code. */
	@ApiModelProperty( value = "HTTP return code of this request", required = true )
	private Integer code;
	
	/** The request id. */
	@ApiModelProperty( value = "Auto Generated Request Id - For Logging and Debbuging", required = true )
	private String requestId;
	
	/** The status. */
	@ApiModelProperty( value = "Status of this request (Sucess/Error/Fail)", required = true )
	private String status;	
	
	/** The data. */
	@ApiModelProperty( value = "Actual Data of this response", required = true )
	private Object data;
	
	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	
	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	
	/**
	 * Gets the request id.
	 *
	 * @return the request id
	 */
	public String getRequestId() {
		return requestId;
	}
	
	/**
	 * Sets the request id.
	 *
	 * @param requestId the new request id
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	
	/**
	 * Sets the data.
	 *
	 * @param data the new data
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RestResponseWrapper other = (RestResponseWrapper) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RestResponseWrapper [code=" + code + ", requestId=" + requestId
				+ ", status=" + status + ", data=" + data + "]";
	}


	

}
