package com.mahindra.leads.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mahindra.leads.entity.LeadEntity;
import com.mahindra.leads.service.LeadsService;

@ExtendWith(MockitoExtension.class)
public class LeadsControllerTest {
	@Mock
	private LeadsService leadService;

	@InjectMocks
	private LeadsController leadController;

	@Test
	public void testFetchLeadsByMobileNumber_Success() throws JsonProcessingException {
		String mobileNumber = "1234567890";
		String jsonResponse = "{\"status\": \"success\", \"data\": [{\"leadId\": \"1\", \"firstName\": \"John\", \"lastName\": \"Doe\"}]}";

		when(leadService.getLeadsByMobileNumber(mobileNumber)).thenReturn(jsonResponse);

		String response = leadController.fetchLeadsByMobileNumber(mobileNumber);

		assertEquals(jsonResponse, response);
	}

	@Test
	public void testFetchLeadsByMobileNumber_Exception() throws JsonProcessingException {
		String mobileNumber = "1234567890";
		when(leadService.getLeadsByMobileNumber(mobileNumber)).thenThrow(JsonProcessingException.class);
		assertThrows(JsonProcessingException.class, () -> leadController.fetchLeadsByMobileNumber(mobileNumber));
	}

	@Test
	public void testCreateLead_Success() throws JsonProcessingException {
		LeadEntity lead = new LeadEntity();
		String jsonResponse = "{\"status\": \"success\", \"data\": \"Created Leads Successfully\"}";

		when(leadService.saveLeadIfNotExists(lead)).thenReturn(jsonResponse);

		String response = leadController.createLead(lead);

		assertEquals(jsonResponse, response);
	}

	@Test
	public void testCreateLead_Exception() throws JsonProcessingException {
		LeadEntity lead = new LeadEntity();
		when(leadService.saveLeadIfNotExists(lead)).thenThrow(JsonProcessingException.class);
		assertThrows(JsonProcessingException.class, () -> leadController.createLead(lead));
	}
}
