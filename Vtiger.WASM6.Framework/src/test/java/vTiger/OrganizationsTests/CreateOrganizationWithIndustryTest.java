package vTiger.OrganizationsTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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
@Listeners(vTiger.GenericLibrary.ListnerImplementationLibrary.class)
public class CreateOrganizationWithIndustryTest extends BaseClass {
	@Test(groups = "SmokeSuite")
	public void createOrganizationWithIndustryTest() throws Exception {
		//Step1:create objects of all the libraries 
	//	JavaLibrary jLib=new JavaLibrary();
	//	PropertyFileLibrary pLib=new PropertyFileLibrary();
	//	ExcelFileLibrary eLib=new ExcelFileLibrary();
	//	WebDriverLibrary wLib=new WebDriverLibrary();
		//sTEP 2:Read all the required data from propertyfile and excel file
			//	String BROWSER=pLib.readDataFromPropertyFile("browser");
			//	String URL=pLib.readDataFromPropertyFile("url");
			//	String USERNAME=pLib.readDataFromPropertyFile("username");
			//	String PASSWORD=pLib.readDataFromPropertyFile("password");
				
				//Step3:FROM EXCEL FILE
				String ORGNAME=eLib.redaDataFromExcel("Organization", 4, 2)+jLib.getRandomNumber();
				String Industry=eLib.redaDataFromExcel("Organization", 4, 3);
				
				//step 4 :launch the browser
			//	WebDriver driver=null;
			//	if(BROWSER.equalsIgnoreCase("chrome")) {
				//	WebDriverManager.chromedriver().setup();
			//		driver=new ChromeDriver();
			//	}
			//	else if(BROWSER.equalsIgnoreCase("firefox")) {
			//		WebDriverManager.firefoxdriver().setup();
			//		driver=new FirefoxDriver();
				//}
			//	else {
			//		System.out.println("--invlid browser---");
			//	}
			//	wLib.maximizeWindow(driver);
			//	wLib.waitForPageLoad(driver);
			//	driver.get(URL);
			
				//Step 5:login to application
				//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			//	driver.findElement(By.id("submitButton")).click();
		//		LoginPage lp=new LoginPage(driver);
		//		lp.loginToApp(USERNAME, PASSWORD);
				
			//Step6: navigate into organization link 
			//	driver.findElement(By.linkText("Organizations")).click();
			//	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
              //click on org link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationsLnk();
				//click on new org lookup icon
				OrganizationsPage op=new OrganizationsPage(driver);
				op.clickonCreateOrgnizationLookUpImg();
				//Step7:create new Ogrganization with mandatory feilds
				//driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
			CreateNewOrganizationPage cnp=new CreateNewOrganizationPage(driver);
			cnp.createNewOrganization(ORGNAME, Industry);
				//	Step 8:Select industry dropdown
			//	WebElement industry=driver.findElement(By.name("industry"));
			//	wLib.handleDropDown(industry,Industrydd);


				//Step9:save
			//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step10:validate
			OrganizationinfoPage cip=new OrganizationinfoPage(driver);
				String orgHeader =cip.getHeaderText();
				System.out.println(orgHeader);
				Assert.assertTrue(orgHeader.contains(ORGNAME));
						// driver.findElement(By.className("dvHeaderText")).getText();
			//	if(orgHeader.contains(ORGNAME)) {
			//		System.out.println("Orgnaization Created");
			//	}
			//	else {
				//	System.out.println("Organization not Created");
				//}
				//Step 11:logout the application
				//  WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			//	wLib.mouseHoverOn(driver, AdminImg);
			//	driver.findElement(By.linkText("Sign Out")).click();
			//	hp.signOutApp(driver);

	}

}
