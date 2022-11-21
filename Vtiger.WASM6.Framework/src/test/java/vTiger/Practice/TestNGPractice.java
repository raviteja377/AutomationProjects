package vTiger.Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPractice {
	@Test
	public void createCustomer() {
		System.out.println("customer created");
	}
	
	@Test
	public void modifyCustomer() {
		System.out.println("modify created");
	}
	@Test
	public void deleteCustomer() {
		System.out.println("delete created");
	}
}
