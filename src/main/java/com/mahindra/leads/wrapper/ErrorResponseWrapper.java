package com.mahindra.leads.wrapper;

import com.mahindra.leads.dto.ErrorResponse;

public class ErrorResponseWrapper {
	private String status;
	private ErrorResponse errorResponse;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse errorResponse) {
		this.errorResponse = errorResponse;
	}

}
