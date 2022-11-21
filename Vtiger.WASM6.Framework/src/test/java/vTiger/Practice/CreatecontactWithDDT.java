package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactWithDDT {

	public static void main(String[] args) throws Exception {
		
		//Step1:reda the required data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		//read the data  from excel sheet
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TextData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("Contacts");
	 String LASTNAME = sh.getRow(1).getCell(2).getStringCellValue();
	 
	WebDriver driver=null;
	
		//Step2:launch the browser -RunTime-polymorphisam
		if(BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		 System.out.println("---"+BROWSER+" is launched"+"---");
		}
		else if(BROWSER.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
			 System.out.println("---"+BROWSER+" is launched"+"---");
			
		}
		else {
			System.out.println("----"+"invalid browser name"+"----");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		//Step3:login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//Step4:navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();

		//Step5:create contact with mandatory feilds
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		//Step6:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step7:logout the application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element)
		.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
		//step8:close the browser
		driver.quit();
	}

}
