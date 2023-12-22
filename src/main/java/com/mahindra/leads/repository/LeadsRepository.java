package com.mahindra.leads.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mahindra.leads.entity.LeadEntity;

public interface LeadsRepository extends JpaRepository<LeadEntity, Long> {

	boolean existsByLeadId(Integer leadId);

	List<LeadEntity> findByMobileNumber(String mobileNumber);

}
