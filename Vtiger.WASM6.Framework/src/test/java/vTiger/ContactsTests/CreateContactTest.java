package vTiger.ContactsTests;

import static org.testng.Assert.fail;

import java.io.IOException;

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
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
@Listeners(vTiger.GenericLibrary.ListnerImplementationLibrary.class)
public class CreateContactTest extends BaseClass {
	
@Test(groups = "SmokeSuite")
	public void createContactTest() throws Exception {
		
		//FROM EXCEL FILE
		String LASTNAME = eLib.redaDataFromExcel("Contacts", 1, 2)+jLib.getRandomNumber();

	
			//Step 5:navigate to contacts
HomePage hp=new HomePage(driver);
hp.clickOnContactsLnk();

		//Step 6:create contact with mandatory feilds and save
ContactsPage cp=new ContactsPage(driver);
cp.clickonCreateContactImg();
		CreateNewContactPage cnc=new CreateNewContactPage(driver);
		cnc.cretaeNewContact(LASTNAME);


		
		
		//step 8:validate
ContactInfoPage cip=new ContactInfoPage(driver);
String contactHeader=cip.getHeaderText();
	System.out.println(contactHeader);
	Assert.assertTrue(contactHeader.contains(LASTNAME),"contact created");
	

}
@Test
public void createContactWithLeadSource() {

	System.out.println("lead Source created");
}
@Test
public void createContactWithLeadSourceAndOrg() {

	System.out.println("lead Source with Org");
}
}