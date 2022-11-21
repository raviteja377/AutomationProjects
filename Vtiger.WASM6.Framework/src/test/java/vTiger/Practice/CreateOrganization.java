package vTiger.Practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericLibrary.WebDriverLibrary;


public class CreateOrganization {
@Test
	public void createOrganization() throws Exception {
	WebDriverLibrary wlib=new WebDriverLibrary();
		//step1:read the data from properties file
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
				Properties pobj=new Properties();
				pobj.load(fis);
				String BROWSER = pobj.getProperty("browser");
				String URL = pobj.getProperty("url");
				String USERNAME = pobj.getProperty("username");
				String PASSWORD = pobj.getProperty("password");
				
				//step2:read the data  from excel sheet(contacts)
				FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TextData.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh=wb.getSheet("Organization");
				String ORGNAME=sh.getRow(1).getCell(2).getStringCellValue();
			
				Random ran=new Random();
			int value = ran.nextInt(500);
			 String ORG = ORGNAME+value;
				//Step3:launch browser RunTime-polymorphisam
				WebDriver driver=null;
				if(BROWSER.equalsIgnoreCase("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					System.out.println("---"+BROWSER+" is launched"+"---");
				}else if(BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.chromedriver().setup();
				 driver=new FirefoxDriver();
				 System.out.println("---"+BROWSER+" is launched"+"---");
				 }else {
					 System.out.println("---invalid browser name---");
				 }
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		//Step4:load the application
		driver.get(URL);

		//Step5:login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		//Step6: navigate to organization link  
		driver.findElement(By.linkText("Organizations")).click();

		//Step7:create new Ogrganization with mandatory feilds
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(ORG);

wlib.takeScreenShot(driver, "pic");
System.out.println("screen shot success");
 Assert.fail();
		//Step8:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step9:logout 

		Thread.sleep(2000);
	
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		
		Actions act=new Actions(driver);
		act.moveToElement(element)
		.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
		//Step10:close the browser
		driver.close();

	}

}
