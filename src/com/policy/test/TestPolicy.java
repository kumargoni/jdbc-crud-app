package com.policy.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.Test;
import com.policy.dao.LICOperations;
import com.policy.entity.Policy;

public class TestPolicy {
	@Test
	public void testCreatePolicyConstructor() {
		Policy policy = new Policy(0, "LIC", "Kumar", "2020-12-12", "Yearly", 899.00F);
		LICOperations licOperations = new LICOperations();
		assertEquals(1, licOperations.createPolicy(policy));
	}

	@Test
	// test insert functionality
	public void testCreatePolicy() {
		Policy policy = new Policy();
		LICOperations licOperations = new LICOperations();
		policy.setPolicyName("LIC");
		policy.setPolicyHolderName("Kumar");
		policy.setPolicyStartDate("2020-01-01");
		policy.setPremiumType("Yearly");
		policy.setPremiumAmt(10000);
		assertEquals(1, licOperations.createPolicy(policy));
	}

	@Test
	public void testCreatePolicyWhenPolicyObjectIsNull() {
		Policy policy = new Policy();
		LICOperations licOperations = new LICOperations();
		assertEquals(0, licOperations.createPolicy(policy));
	}

	@Test
	// test update functionality
	public void testUpdatePolicy() {
		Policy policy = new Policy();
		LICOperations licOperations = new LICOperations();
		policy.setPolicyNumber(4);
		policy.setPolicyName("LIC Jeevan");
		policy.setPolicyHolderName("Kumar");
		policy.setPolicyStartDate("2020-01-01");
		policy.setPremiumType("Yearly");
		policy.setPremiumAmt(10000);
		assertEquals(1, licOperations.updatePolicy(policy));
	}

	@Test
	// test delete functionality
	public void testDeletePolicy() {
		Policy policy = new Policy();
		LICOperations licOperations = new LICOperations();
		policy.setPolicyNumber(3);
		assertEquals(0, licOperations.deletePolicy(policy));
	}
}
