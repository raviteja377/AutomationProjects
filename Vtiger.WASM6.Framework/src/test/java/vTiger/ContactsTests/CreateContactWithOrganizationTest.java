package vTiger.ContactsTests;

import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

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
import vTiger.ObjectRepository.ContactInfoPage;
import vTiger.ObjectRepository.ContactsPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationinfoPage;
import vTiger.ObjectRepository.OrganizationsPage;
@Listeners(vTiger.GenericLibrary.ListnerImplementationLibrary.class)
public class CreateContactWithOrganizationTest extends BaseClass {
@Test(groups = "regressionSuite")
	public void createContactWithOrganizationTest() throws Exception {
		//Step1:create  the object of all the libraries 
	//	JavaLibrary jLib=new JavaLibrary();
	//	PropertyFileLibrary pLib=new PropertyFileLibrary();
	//	ExcelFileLibrary eLib=new ExcelFileLibrary();
		//WebDriverLibrary wLib=new WebDriverLibrary();

		//sTEP 2:Read all the required data from propertyfile and excel file
	//	String BROWSER=pLib.readDataFromPropertyFile("browser");
	//	String URL=pLib.readDataFromPropertyFile("url");
	//	String USERNAME=pLib.readDataFromPropertyFile("username");
	//	String PASSWORD=pLib.readDataFromPropertyFile("password");
		//FROM EXCEL FILE
		String LASTNAME = eLib.redaDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();
		String ORGNAME=eLib.redaDataFromExcel("Contacts", 4, 3)+jLib.getRandomNumber(); 
		//step 3 :launch the browser
	//	WebDriver driver=null;
	//	if(BROWSER.equalsIgnoreCase("chrome")) {
	//		WebDriverManager.chromedriver().setup();
	//		driver=new ChromeDriver();
	//	}
	//	else if(BROWSER.equalsIgnoreCase("firefox")) {
	//		WebDriverManager.firefoxdriver().setup();
	//		driver=new FirefoxDriver();
	//	}
	//	else {
	//		System.out.println("--invlid browser---");
	//	}
	//	wLib.maximizeWindow(driver);
	//	wLib.waitForPageLoad(driver);
	//	driver.get(URL);

		//Step 4:login to application
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		//driver.findElement(By.id("submitButton")).click();
    //  LoginPage lp=new LoginPage(driver);
    //  lp.loginToApp(USERNAME, PASSWORD);
		//Step4: navigate into organization link 
	//	driver.findElement(By.linkText("Organizations")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
      HomePage hp=new HomePage(driver);
      hp.clickOnOrganizationsLnk();
      OrganizationsPage op=new OrganizationsPage(driver);
      op.clickonCreateOrgnizationLookUpImg();
		//Step5:create new Ogrganization with mandatory feilds
	//	driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

CreateNewOrganizationPage cnop=new CreateNewOrganizationPage (driver);
cnop.createNewOrganization(ORGNAME);
		//Step6:save
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step7: validate
		
	//String orgHeader = driver.findElement(By.className("dvHeaderText")).getText(); 
OrganizationinfoPage oip=new OrganizationinfoPage(driver);
String orgHeader=oip.getHeaderText();
Assert.assertTrue(orgHeader.contains(ORGNAME));


		//Step8:navigate to contacts
		//driver.findElement(By.linkText("Contacts")).click();
hp.clickOnContactsLnk();
ContactsPage cp=new ContactsPage(driver);
cp.clickonCreateContactImg();

		//Step9:create contact with mandatory feilds
		//driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createnewContact(driver, LASTNAME, ORGNAME);;

		//Step 10: Select the Organization created in org window
	//	driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@title='Select']")).click();
	//	wLib.switchToWindow(driver, "Accounts");
	//	driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
	//	driver.findElement(By.name("search")).click();
	//	driver.findElement(By.linkText(ORGNAME)).click();
	//	wLib.switchToWindow(driver, "Contacts");
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Step11:validate
	//	String contactHeader=driver.findElement(By.className("dvHeaderText")).getText();
		ContactInfoPage cip=new ContactInfoPage(driver);
	String contactHeader=cip.getHeaderText();
	Assert.assertTrue(contactHeader.contains(LASTNAME));
		//Step 12:logout the application
		//WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wLib.mouseHoverOn(driver, AdminImg);
		//driver.findElement(By.linkText("Sign Out")).click();
//hp.signOutApp(driver);



	}

} 

