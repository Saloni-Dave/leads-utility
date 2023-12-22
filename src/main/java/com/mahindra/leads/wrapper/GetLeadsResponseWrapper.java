package com.mahindra.leads.wrapper;

import java.util.List;

import com.mahindra.leads.entity.LeadEntity;

public class GetLeadsResponseWrapper {
	private String status;
	private List<LeadEntity> data;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<LeadEntity> getData() {
		return data;
	}

	public void setData(List<LeadEntity> data) {
		this.data = data;
	}

}
