package vTiger.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

/**
 * this is a generic class which consits of basic  configuration annotations
 * @author ADMIN
 *
 */
public class BaseClass {
	 public JavaLibrary jLib=new JavaLibrary();
	public PropertyFileLibrary pLib=new PropertyFileLibrary();
	public ExcelFileLibrary eLib=new ExcelFileLibrary();
	public WebDriverLibrary wLib=new WebDriverLibrary();
	public WebDriver driver=null;
	public static WebDriver sDriver=null;
	
	@BeforeSuite(groups = {"SmokeSuite","regressionSuite"})
	public void bsConfig() {
		System.out.println("--data base connected successfully--");
	}
	//@BeforeTest
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeSuite","regressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws Exception {
		String BROWSER=pLib.readDataFromPropertyFile("browser");
		String URL=pLib.readDataFromPropertyFile("url");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("<--browser lanched successfully -->"+BROWSER);
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("<--browser lanched successfully -->"+BROWSER);
		}
		else {System.out.println("<----invalid browser---->");}
		sDriver=driver;
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
	}
	@BeforeMethod(groups = {"SmokeSuite","regressionSuite"})
	public void bmConfig() throws Exception {
		String USERNAME=pLib.readDataFromPropertyFile("username");
		String PASSWORD=pLib.readDataFromPropertyFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("<---login Successfully---->");
		
		
	}
	@AfterMethod(groups ={"SmokeSuite","regressionSuite"})
	public void amConfig() {
		HomePage hp=new HomePage(driver);
		hp.signOutApp(driver);
		System.out.println("<---logout successfully--->");}
	//@AfterTest
	@AfterClass(groups = {"SmokeSuite","regressionSuite"})
	public void acConfig() {
		driver.quit();
		System.out.println("<---browser  successfully closed---> ");
	}
	@AfterSuite(groups = {"SmokeSuite","regressionSuite"})
	public void asConfig() {
		System.out.println("<---data base is successfully closed--->");
	}

}
