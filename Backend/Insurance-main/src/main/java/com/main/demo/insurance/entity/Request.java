package com.main.demo.insurance.entity;

import java.util.ArrayList;

public class Request {
	private Customer customerDetail; // Customer details associated with the request
	private ArrayList<Plan> allPacks = new ArrayList<Plan>(); // List of insurance packs in the request
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(Customer customerDetail, ArrayList<Plan> allPacks) {
		super();
		this.customerDetail = customerDetail;
		this.allPacks = allPacks;
	}
	public Customer getCustomerDetail() {
		return customerDetail;
	}
	public void setCustomerDetail(Customer customerDetail) {
		this.customerDetail = customerDetail;
	}
	public ArrayList<Plan> getAllPacks() {
		return allPacks;
	}
	public void setAllPacks(ArrayList<Plan> allPacks) {
		this.allPacks = allPacks;
	}
	@Override
	public String toString() {
		return "Request [customerDetail=" + customerDetail + ", allPacks=" + allPacks + "]";
	}

}