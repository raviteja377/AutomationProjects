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
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.ProductInfoPage;
import vTiger.ObjectRepository.ProductsPage;
@Listeners(vTiger.GenericLibrary.ListnerImplementationLibrary.class)
public class CreateProductTest extends BaseClass {
@Test(groups = "SmokeSuite")
	public void cretaeProductTest() throws Exception {
//		//Step 1: Create Object of all the libraries
//		JavaLibrary jLib=new JavaLibrary();
//		ExcelFileLibrary eLib=new ExcelFileLibrary();
//		PropertyFileLibrary pLib=new  PropertyFileLibrary();
//		WebDriverLibrary wLib=new WebDriverLibrary();
//		//sTEP 2:Read all the required data from propertyfile and excel file
//		String BROWSER=pLib.readDataFromPropertyFile("browser");
//		String URL=pLib.readDataFromPropertyFile("url");
//		String USERNAME=pLib.readDataFromPropertyFile("username");
//		String PASSWORD=pLib.readDataFromPropertyFile("password");
//		//FROM EXCEL FILE
		String PRODUCTNAME = eLib.redaDataFromExcel("Products", 1, 2)+jLib.getRandomNumber();
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
		//Step5:navigate to products link
	HomePage hp=new HomePage(driver);
	//	driver.findElement(By.linkText("Products")).click();
hp.clickOnProductsLnk();
	ProductsPage pp=new ProductsPage(driver);
	pp.clickOnCreateProductLookUpImg();
		//Step6:create new prooduct with mandatory feilds
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
	//	driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
CreateNewProductPage cnp=new CreateNewProductPage(driver);
cnp.createProduct(PRODUCTNAME);
		//Step7:Save
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step8:validate
	//	String productHeader=driver.findElement(By.className("lvtHeaderText")).getText();
ProductInfoPage pip=new ProductInfoPage(driver);
String productHeader=pip.getHeaderText();


if(productHeader.contains(PRODUCTNAME)) {
			System.out.println("product created");
		}
		else {
			System.out.println("product is not created");
		}
		//Step 9:logout the application
	//	WebElement AdminImg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	//	wLib.mouseHoverOn(driver, AdminImg);
	//	driver.findElement(By.linkText("Sign Out")).click();
	}

}
