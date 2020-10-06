package com.policy.entity;

public class Policy {
	private int PolicyNumber;
	private String PolicyName, PolicyHolderName, PolicyStartDate, PremiumType;
	private float PremiumAmt;

	public Policy(int PolicyNumber, String PolicyName, String PolicyHolderName, String PolicyStartDate,
			String PremiumType, float PremiumAmt) {
		super();
		this.PolicyNumber = PolicyNumber;
		this.PolicyName = PolicyName;
		this.PolicyHolderName = PolicyHolderName;
		this.PolicyStartDate = PolicyStartDate;
		this.PremiumType = PremiumType;
		this.PremiumAmt = PremiumAmt;
	}

	public Policy() {
		// TODO constructor
	}

	public int getPolicyNumber() {
		return PolicyNumber;
	}

	public void setPolicyNumber(int PolicyNumber) {
		this.PolicyNumber = PolicyNumber;
	}

	public String getPolicyName() {
		return PolicyName;
	}

	public void setPolicyName(String PolicyName) {
		this.PolicyName = PolicyName;
	}

	public String getPolicyHolderName() {
		return PolicyHolderName;
	}

	public void setPolicyHolderName(String PolicyHolderName) {
		this.PolicyHolderName = PolicyHolderName;
	}

	public String getPolicyStartDate() {
		return PolicyStartDate;
	}

	public void setPolicyStartDate(String PolicyStartDate) {
		this.PolicyStartDate = PolicyStartDate;
	}

	public String getPremiumType() {
		return PremiumType;
	}

	public void setPremiumType(String PremiumType) {
		this.PremiumType = PremiumType;
	}

	public float getPremiumAmt() {
		return PremiumAmt;
	}

	public void setPremiumAmt(float PremiumAmt) {
		this.PremiumAmt = PremiumAmt;
	}
}
