package com.main.demo.insurance.entity;
import java.util.Date;

public class Customer {
//	Customer properties
	private Date dob; // Date of birth of the customer
	private String gender; // Gender of the customer
	private int annualIncome; // Annual income of the customer
	private String medicalCondition; // Medical condition of the customer(Yes or No)

	public Customer() {
		super();

	}

	public Customer(Date dob, String gender, int annualIncome, String medicalCondition) {
		super();
		this.dob = dob;
		this.gender = gender;
		this.annualIncome = annualIncome;
		this.medicalCondition = medicalCondition;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAnnualIncome() {
		return annualIncome;
	}

	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}

	public String getMedicalCondition() {
		return medicalCondition;
	}

	public void setMedicalCondition(String medicalCondition) {
		this.medicalCondition = medicalCondition;
	}

	@Override
	public String toString() {
		return "Customer [dob=" + dob + ", gender=" + gender + ", annualIncome=" + annualIncome + ", medicalCondition="
				+ medicalCondition + "]";
	}

}