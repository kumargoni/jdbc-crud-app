package com.policy.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.policy.dao.LICOperations;
import com.policy.entity.Policy;

public class TestPolicy {

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

		assertEquals(1, licOperations.deletePolicy(policy));
	}

}
