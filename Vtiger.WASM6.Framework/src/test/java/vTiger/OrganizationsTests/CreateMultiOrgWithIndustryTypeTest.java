package vTiger.OrganizationsTests;

import java.io.IOException;

import javax.swing.JLabel;

import org.apache.hc.core5.http2.hpack.HPackDecoder;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.BaseClass;
import vTiger.GenericLibrary.ExcelFileLibrary;
import vTiger.GenericLibrary.JavaLibrary;
import vTiger.GenericLibrary.PropertyFileLibrary;
import vTiger.GenericLibrary.WebDriverLibrary;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationinfoPage;
import vTiger.ObjectRepository.OrganizationsPage;

public class CreateMultiOrgWithIndustryTypeTest extends BaseClass {
	//Step 1: Create Object of all the libraries
	JavaLibrary jLib=new JavaLibrary();
	PropertyFileLibrary pLib=new PropertyFileLibrary();
	ExcelFileLibrary eLib=new ExcelFileLibrary();
	WebDriverLibrary wLib=new WebDriverLibrary();
	
@Test(dataProvider = "mulorg")
public void createMulorgWithIndType(String orgname,String indtype) throws Exception {
	//read the data from propertyfile
	String BROWSER=pLib.readDataFromPropertyFile("browser");
	String URL=pLib.readDataFromPropertyFile("url");
	String USERNAME=pLib.readDataFromPropertyFile("username");
	String PASSWORD=pLib.readDataFromPropertyFile("password");
	String org = orgname+jLib.getRandomNumber();
	//step 4 :launch the browser
	WebDriver driver=null;
	if(BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("--invlid browser---");
	}
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
lp.loginToApp(USERNAME, PASSWORD);
	HomePage hp=new HomePage(driver);
hp.clickOnOrganizationsLnk();

OrganizationsPage op=new OrganizationsPage(driver);
op.clickonCreateOrgnizationLookUpImg();

	
	CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
	cnop.createNewOrganization(org,indtype);
	OrganizationinfoPage oip=new OrganizationinfoPage(driver);
	String orgHeader=oip.getHeaderText();
	if(orgHeader.contains(orgname)) {
		System.out.println(orgHeader);
		System.out.println("pass");
	}
	else {System.out.println("fail");}
	hp.signOutApp(driver);
	driver.quit();
	
}
@DataProvider(name="mulorg")
public Object[][] getData() throws EncryptedDocumentException, IOException {
	 Object[][] data = eLib.readMultipleData("MulltipleOrg");
	return data;
}

}
