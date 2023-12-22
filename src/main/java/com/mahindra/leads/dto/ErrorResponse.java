package com.mahindra.leads.dto;

import java.util.List;

public class ErrorResponse {
	private String code;
	private List<String> messages;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	

}
