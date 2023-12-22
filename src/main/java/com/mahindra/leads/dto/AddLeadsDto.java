package com.mahindra.leads.dto;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class AddLeadsDto {
	@NotBlank(message = "Lead ID is mandatory")
	@Positive(message = "Lead Id should be a number")
	private Integer leadId;
	
	@NotBlank(message = "First Name is mandatory")
	private String firstName;
	
	@NotBlank(message = "Last Name is mandatory")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name should contain only alphabets")
	private String lastName;
	
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Middle Name should contain only alphabets")
	private String middleName;
	
	@NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile Number should contain 10 digits and start with a digit between 6 and 9")
	private String mobileNumber;
	
	@NotBlank(message = "Gender is mandatory")
    @Pattern(regexp = "^(Male|Female|Others)$", message = "Gender should be Male, Female, or Others")
	private String gender;
	
	@NotBlank(message = "Date of birth is mandatory")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dob;
	
	@Email(message = "Enter a valid email address.")
	private String email;

	public Integer getLeadId() {
		return leadId;
	}

	public void setLeadId(Integer leadId) {
		this.leadId = leadId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
