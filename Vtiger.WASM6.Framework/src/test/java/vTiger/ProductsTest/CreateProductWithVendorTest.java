 package vTiger.ProductsTest;

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
import vTiger.ObjectRepository.CreateNewProductPage;
import vTiger.ObjectRepository.CreateNewVendorPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.ProductInfoPage;
import vTiger.ObjectRepository.ProductsPage;
import vTiger.ObjectRepository.VendorInfopage;
import vTiger.ObjectRepository.VendorsPage;
@Listeners(vTiger.GenericLibrary.ListnerImplementationLibrary.class)
public class CreateProductWithVendorTest extends BaseClass {
@Test(groups = "regressionSuite")
	public void createProductWithvendorTest() throws Exception {
//		//Step1:create objects of all the libraries
//		JavaLibrary jLib=new JavaLibrary();
//		PropertyFileLibrary pLib=new PropertyFileLibrary();
//		ExcelFileLibrary eLib=new ExcelFileLibrary();
//		WebDriverLibrary wLib=new WebDriverLibrary();
//
//		//sTEP 2:Read all the required data from propertyfile and excel file
//		String BROWSER=pLib.readDataFromPropertyFile("browser");
//		String URL=pLib.readDataFromPropertyFile("url");
//		String USERNAME=pLib.readDataFromPropertyFile("username");
//		String PASSWORD=pLib.readDataFromPropertyFile("password");
//
		String PRODUCTNAME = eLib.redaDataFromExcel("Products", 4, 2)+jLib.getRandomNumber();
		String VENDORNAME=eLib.redaDataFromExcel("Products", 4, 3)+jLib.getRandomNumber() ; 
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

		//Step 4:login to application
		//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//	driver.findElement(By.id("submitButton")).click();
//LoginPage lp=new LoginPage(driver);
//lp.loginToApp(USERNAME, PASSWORD);
		//Step5:navigate to vendors link
	//	WebElement more=driver.findElement(By.linkText("More"));
	//	wLib.mouseHoverOn(driver, more);
	//	WebElement element=driver.findElement(By.linkText("Vendors"));
	//	wLib.mouseHoverOn(driver, element);
	//	element.click();
HomePage hp=new HomePage(driver);
hp.clickOnVendorsLnk(driver);
		//Step6:create vendor with mandaatory feilds
		//driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
		//driver.findElement(By.name("vendorname")).sendKeys(VENDORNAME);
VendorsPage vp=new VendorsPage(driver);
vp.clickonCreateVendorLookUpImg();
CreateNewVendorPage cnv=new CreateNewVendorPage(driver);
cnv.createNewVendor(VENDORNAME);
		//Step7:save
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step8:validate
		//String venHeader=driver.findElement(By.className("lvtHeaderText")).getText();
VendorInfopage vip=new VendorInfopage(driver);
String venHeader=vip.getHeaderText();
		if(venHeader.contains(VENDORNAME)) {
			System.out.println("vendor created");
		}
		else {
			System.out.println("vendor is not created ");
		}
		//Step9:navigate to products link
		//driver.findElement(By.linkText("Products")).click();

		//Step10:create product with manadatory feilds
	//	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		//driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
	//	driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@title='Select']")).click();
	//	wLib.switchToWindow(driver, "Vendors");
	//	driver.findElement(By.name("search_text")).sendKeys(VENDORNAME);
	//	driver.findElement(By.name("search")).click();
	//	driver.findElement(By.linkText(VENDORNAME)).click();
	//	wLib.switchToWindow(driver, "Products");

		//Step11:save
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
hp.clickOnProductsLnk();
ProductsPage pp=new ProductsPage(driver);
pp.clickOnCreateProductLookUpImg();
CreateNewProductPage cnp=new CreateNewProductPage(driver);
cnp.createProduct(driver, PRODUCTNAME, VENDORNAME);
		//Step12:validate
		//String productHeader=driver.findElement(By.className("lvtHeaderText")).getText();
	ProductInfoPage pip=new ProductInfoPage(driver);
	String productHeader=pip.getHeaderText();
if(productHeader.contains(PRODUCTNAME)) {
			System.out.println("product created");
		}
		else {
			System.out.println("product is not created");
		}
		//Step 9:logout the application
		//WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//wLib.mouseHoverOn(driver, AdminImg);
		//driver.findElement(By.linkText("Sign Out")).click();
//hp.signOutApp(driver);

	}

}
