package com.main.demo.insurance.entity;
import java.util.ArrayList;

public class Response {
	private ArrayList<Plan> eligiblePlan = new ArrayList<Plan>(); // List of eligible insurance packs

	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Response(ArrayList<Plan> eligiblePlan) {
		super();
		this.eligiblePlan = eligiblePlan;
	}

	public ArrayList<Plan> getEligiblePlan() {
		return eligiblePlan;
	}

	public void setEligiblePlan(ArrayList<Plan> eligiblePlan) {
		this.eligiblePlan = eligiblePlan;
	}

	@Override
	public String toString() {
		return "Response [eligiblePlan=" + eligiblePlan + "]";
	}

}