package com.mahindra.leads.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mahindra.leads.entity.LeadEntity;
import com.mahindra.leads.repository.LeadsRepository;

@SpringBootTest
public class LeadsServiceTest {
	@Mock
	private LeadsRepository leadRepository;

	@InjectMocks
	private LeadsService leadService;

	@Test
	public void testGetLeadsByMobileNumber_NoLeadsFound() throws JsonProcessingException {
		when(leadRepository.findByMobileNumber(anyString())).thenReturn(new ArrayList<>());

		String result = leadService.getLeadsByMobileNumber("1234567890");

		assertTrue(result.contains("No Lead found with the Mobile Number "));
		assertTrue(result.contains("\"status\":\"error\""));
	}

	@Test
	public void testGetLeadsByMobileNumber_LeadsFound() throws JsonProcessingException {
		List<LeadEntity> mockEntityList = new ArrayList<>();

		when(leadRepository.findByMobileNumber(anyString())).thenReturn(mockEntityList);

		String result = leadService.getLeadsByMobileNumber("1234567890");
		assertTrue(result.contains("\"status\":\"success\""));
	}

	@Test
	public void testSaveLeadIfNotExists_LeadNotExists() throws JsonProcessingException {
		LeadEntity lead = new LeadEntity();
		lead.setLeadId(123);

		when(leadRepository.existsByLeadId(any(Integer.class))).thenReturn(false);

		String result = leadService.saveLeadIfNotExists(lead);

		assertTrue(result.contains("\"status\":\"success\""));
		assertTrue(result.contains("\"data\":\"Created Lead Successfully\""));
	}

	@Test
	public void testSaveLeadIfNotExists_LeadExists() throws JsonProcessingException {
		LeadEntity lead = new LeadEntity();
		lead.setLeadId(123);

		when(leadRepository.existsByLeadId(any(Integer.class))).thenReturn(true);

		String result = leadService.saveLeadIfNotExists(lead);

		assertTrue(result.contains("\"status\":\"error\""));
		assertTrue(result.contains("\"code\":\"E10010\""));
	}

}
