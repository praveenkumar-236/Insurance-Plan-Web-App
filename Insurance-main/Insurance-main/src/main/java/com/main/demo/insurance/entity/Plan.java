package com.main.demo.insurance.entity;

public class Plan {
	private int id;
	private String planName; // Name of the insurance plan
	private int price; // Price of the insurance plan
	public Plan() {
		super();
	}
	public Plan(int id, String planName, int price) {
		super();
		this.id = id;
		this.planName = planName;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Plan [id=" + id + ", planName=" + planName + ", price=" + price + "]";
	}
	
}
