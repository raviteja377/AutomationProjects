package vTiger.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage;

public class PomClassPractice {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		LoginPage lp= new LoginPage(driver);
		lp.loginToApp("admin", "admin");
		
		

	}

}
