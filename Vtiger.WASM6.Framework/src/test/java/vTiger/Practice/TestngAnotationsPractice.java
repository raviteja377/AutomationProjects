package vTiger.Practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestngAnotationsPractice {
	@BeforeSuite
	public void bsConfig() {
		System.out.println("open database");
	}
	@AfterSuite
	public void asConfig() {
		System.out.println("database closed");
	}
	@AfterClass
	public void acConfig() {
		System.out.println("browser closed");
	}
	@AfterMethod
	public void amConfig()
	{
		System.out.println("logout the Aplliction");
	}	@BeforeClass
	public void bcConfig() {
		System.out.println("lanching browser");
	}
	@Test
	public void mainTask() {
		System.out.println("main task is performed");
	}
	@BeforeMethod
	public void bmConfig() {
		System.out.println("login into application");
	}

}
