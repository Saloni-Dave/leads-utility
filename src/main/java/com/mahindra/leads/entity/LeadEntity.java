package com.mahindra.leads.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "lead")
public class LeadEntity {
	@Id
	@NotNull(message = "Lead ID is mandatory")
	@Min(1)
	@Column(name = "leadid")
	private Integer leadId;

	@NotBlank(message = "First Name is mandatory")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "First Name should contain only alphabets")
	@Column(name = "firstname")
	private String firstName;

	@NotBlank(message = "Last Name is mandatory")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Last Name should contain only alphabets")
	@Column(name = "lastname")
	private String lastName;

	@Pattern(regexp = "^$|[a-zA-Z]+$", message = "Middle Name should contain only alphabets")
	@Column(name = "middlename")
	private String middleName;

	@NotBlank(message = "Mobile number is mandatory")
	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile Number should contain 10 digits and start with a digit between 6 and 9")
	@Column(name = "mobilenumber")
	private String mobileNumber;

	@Pattern(regexp = "^(Male|Female|Others)$", message = "Gender should be Male, Female, or Others")
	@Column(name = "gender")
	private String gender;

	@Pattern(regexp = "\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}" , message = "Enter the correct date format")
	@Column(name = "dob")
	private String dob;

	@Email(message = "Enter a valid email address.")
	@Column(name = "email")
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
