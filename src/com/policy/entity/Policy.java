package com.policy.entity;

public class Policy {
	private int policyNumber;
	private String policyName, policyHolderName, policyStartDate, premiumType;
	private float premiumAmt;

	public Policy(int policyNumber, String policyName, String policyHolderName, String policyStartDate,
			String premiumType, float premiumAmt) {
		super();
		this.policyNumber = policyNumber;
		this.policyName = policyName;
		this.policyHolderName = policyHolderName;
		this.policyStartDate = policyStartDate;
		this.premiumType = premiumType;
		this.premiumAmt = premiumAmt;
	}

	public Policy() {
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyHolderName() {
		return policyHolderName;
	}

	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}

	public String getPolicyStartDate() {
		return policyStartDate;
	}

	public void setPolicyStartDate(String policyStartDate) {
		this.policyStartDate = policyStartDate;
	}

	public String getPremiumType() {
		return premiumType;
	}

	public void setPremiumType(String premiumType) {
		this.premiumType = premiumType;
	}

	public float getPremiumAmt() {
		return premiumAmt;
	}

	public void setPremiumAmt(float premiumAmt) {
		this.premiumAmt = premiumAmt;
	}
}
