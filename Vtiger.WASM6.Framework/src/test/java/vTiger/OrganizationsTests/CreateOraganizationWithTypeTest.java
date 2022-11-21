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
public class CreateOraganizationWithTypeTest extends BaseClass {
@Test(groups = "SmokeSuite")
	public void createOrganizationWithTypeTest() throws Exception {
			
				String ORGNAME=eLib.redaDataFromExcel("Organization", 7, 2)+jLib.getRandomNumber();
				String Industry=eLib.redaDataFromExcel("Organization", 7, 3);
				String Type=eLib.redaDataFromExcel("Organization", 7, 4);
	

				HomePage hp=new HomePage(driver);
				hp.clickOnOrganizationsLnk();
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickonCreateOrgnizationLookUpImg();
				
		
				CreateNewOrganizationPage cno=new CreateNewOrganizationPage(driver);
				cno.createNewOrganization(ORGNAME, Industry, Type);
				
	
		OrganizationinfoPage oip=new OrganizationinfoPage(driver);
		String orgHeader=oip.getHeaderText();
		System.out.println(orgHeader);
	//	Assert.assertTrue(orgHeader.contains(ORGNAME));
		//		if(orgHeader.contains(Industry)) {
		//			System.out.println("Orgnaization Created");
		//		}
		//		else {
		//			System.out.println("Organization not Created");
		//		}
		
	
	}

}
