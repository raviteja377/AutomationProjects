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
public class CreateOrganizationTest extends BaseClass{
@Test(groups = "SmokeSuite")
	public  void createOrganizationTest() throws Exception {
		
	
		//read data from excel

		String ORGNAME=eLib.redaDataFromExcel("Organization", 1, 2)+jLib.getRandomNumber();
		
		
		//Step4: navigate into organization link 
	HomePage hp=new HomePage(driver);
			hp.clickOnOrganizationsLnk();
		
		OrganizationsPage op=new  OrganizationsPage(driver);
		op.clickonCreateOrgnizationLookUpImg();
			

		//Step5:create new Ogrganization with mandatory feilds

CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
cno.createNewOrganization(ORGNAME);
 
		//Step7:validate
OrganizationinfoPage oip=new OrganizationinfoPage(driver);
		String orgHeader = oip.getHeaderText();
		System.out.println(orgHeader);
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		
	//	if(orgHeader.contains(ORGNAME)) {
		//	System.out.println("Orgnaization Created");
		//}
		//else {
		//	System.out.println("Organization not Created");
		//}

	}}