package vTiger.Practice;

import org.testng.annotations.Test;

public class RuntimeParametersPracticeTest {
	@Test
	public void runTimeparametersTest() { 
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
	}

}
