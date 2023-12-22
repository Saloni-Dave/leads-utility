package com.mahindra.leads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mahindra.leads.entity.LeadEntity;
import com.mahindra.leads.service.LeadsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leads")
public class LeadsController {

	@Autowired
	LeadsService service;

	@GetMapping("/fetch/{mobileNumber}")
	public String fetchLeadsByMobileNumber(@PathVariable String mobileNumber) throws JsonProcessingException {
		String jsonResponse = service.getLeadsByMobileNumber(mobileNumber);
		return jsonResponse;
	}

	@PostMapping("/create")
	public String createLead(@RequestBody @Valid LeadEntity lead) throws JsonProcessingException {
		String jsonResponse = service.saveLeadIfNotExists(lead);
		return jsonResponse;

	}

}
