package com.mahindra.leads.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mahindra.leads.dto.AddLeadsResponseDto;
import com.mahindra.leads.dto.ErrorResponse;
import com.mahindra.leads.entity.LeadEntity;
import com.mahindra.leads.repository.LeadsRepository;
import com.mahindra.leads.wrapper.ErrorResponseWrapper;
import com.mahindra.leads.wrapper.GetLeadsResponseWrapper;

@Service
public class LeadsService {
	private static final ObjectMapper mapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	@Autowired
	LeadsRepository leadRepository;
	private AddLeadsResponseDto addResponseDto = new AddLeadsResponseDto() ;
	private ErrorResponseWrapper errorResponseWrapper = new ErrorResponseWrapper();
	private ErrorResponse errorResponse = new ErrorResponse();
	private GetLeadsResponseWrapper getLeadsResponseWrapper = new GetLeadsResponseWrapper() ;

	public String saveLeadIfNotExists(LeadEntity lead) throws JsonProcessingException {
		Integer leadId = lead.getLeadId();

		if (!leadRepository.existsByLeadId(leadId)) {
			leadRepository.save(lead);
			addResponseDto.setData("Created Lead Successfully");
			addResponseDto.setStatus("success");
			return mapper.writeValueAsString(addResponseDto);
		} else {
			List<String> msgList = new ArrayList<>();
			msgList.add("Lead Already Exists in the database with the lead id");
			errorResponse.setCode("E10010");
			errorResponse.setMessages(msgList);
			errorResponseWrapper.setStatus("error");
			errorResponseWrapper.setErrorResponse(errorResponse);
			return mapper.writeValueAsString(errorResponseWrapper);
		}

	}

	public String getLeadsByMobileNumber(String mobileNumber) throws JsonProcessingException {
		List<LeadEntity> entityList = leadRepository.findByMobileNumber(mobileNumber);
		if (entityList.isEmpty()) {
			List<String> msgList = new ArrayList<>();
			msgList.add("No Lead found with the Mobile Number ");
			errorResponse.setCode("E10011");
			errorResponse.setMessages(msgList);
			errorResponseWrapper.setStatus("error");
			errorResponseWrapper.setErrorResponse(errorResponse);
			return mapper.writeValueAsString(errorResponseWrapper);
		} else {
			getLeadsResponseWrapper.setStatus("success");
			getLeadsResponseWrapper.setData(entityList);
			return mapper.writeValueAsString(getLeadsResponseWrapper);

		}

	}

}
