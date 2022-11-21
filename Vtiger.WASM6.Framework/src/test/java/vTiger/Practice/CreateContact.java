package vTiger.Practice;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

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

public class CreateContact {

	public static void main(String[] args) throws Exception {
	        	//step1:read the data from properties file
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
				Properties pobj=new Properties();
				pobj.load(fis);
				String BROWSER = pobj.getProperty("browser");
				String URL = pobj.getProperty("url");
				String USERNAME = pobj.getProperty("username");
				String PASSWORD = pobj.getProperty("password");
				
				//Step2:read the data  from excel sheet(contacts)
				FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TextData.xlsx");
				Workbook wb = WorkbookFactory.create(fis1);
				Sheet sh=wb.getSheet("Contacts");
				String LASTNAME=sh.getRow(1).getCell(2).getStringCellValue();
			
				
			 
				//Step3:launch browser Runtme polmorphisam
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//Step4:load the application
		driver.get("http://localhost:8888");

		//Step5:login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//Step6:navigate to contacts
		driver.findElement(By.linkText("Contacts")).click();

		//Step7:create contact with mandatory feilds
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		//Step8:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step9:logout the application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element)
		.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
		//step10:close the browser
		driver.close();

	}

}
