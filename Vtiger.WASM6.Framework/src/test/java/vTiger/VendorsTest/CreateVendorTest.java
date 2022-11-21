package vTiger.VendorsTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.CreateNewVendorPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.VendorInfopage;
import vTiger.ObjectRepository.VendorsPage;
@Listeners(vTiger.GenericLibrary.ListnerImplementationLibrary.class)
public class CreateVendorTest extends BaseClass {
@Test(groups = {"SmokeSuite","regressionSuite"})
	public void createVendorsTest() throws Exception {
//		//Step1:create objects of all the libraries
//		JavaLibrary jLib=new JavaLibrary();
//		PropertyFileLibrary pLib=new PropertyFileLibrary();
//		ExcelFileLibrary eLib=new ExcelFileLibrary();
//		WebDriverLibrary wLib=new WebDriverLibrary();
//		//sTEP 2:Read all the required data from propertyfile and excel file
//		String BROWSER=pLib.readDataFromPropertyFile("browser");
//		String URL=pLib.readDataFromPropertyFile("url");
//		String USERNAME=pLib.readDataFromPropertyFile("username");
//		String PASSWORD=pLib.readDataFromPropertyFile("password");
//		//FROM EXCEL FILE
		String VENDERNAME=eLib.redaDataFromExcel("Vendors", 1, 2)+jLib.getRandomNumber();
//
//		//step 3 :launch the browser
//		WebDriver driver=null;
//		if(BROWSER.equalsIgnoreCase("chrome")) {
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//		}
//		else if(BROWSER.equalsIgnoreCase("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			driver=new FirefoxDriver();
//		}
//		else {
//			System.out.println("--invlid browser---");
//		}
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLoad(driver);
//		driver.get(URL);
//
//		//Step 4:login to application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//
//		//Step5:navigate to vendors link
		
HomePage hp= new HomePage(driver);
hp.clickOnVendorsLnk(driver);
VendorsPage vp=new VendorsPage(driver);
vp.clickonCreateVendorLookUpImg();
		//create a vendor  with mandatory feilds
CreateNewVendorPage cnvp=new CreateNewVendorPage(driver);
cnvp.createNewVendor(VENDERNAME);
//validate
VendorInfopage vip=new VendorInfopage(driver);
String venHeader=vip.getHeaderText();
		if(venHeader.contains(VENDERNAME)) {
			System.out.println("vendor created");
		}
		else {
			System.out.println("vendor is not created ");
		}

	}

}
