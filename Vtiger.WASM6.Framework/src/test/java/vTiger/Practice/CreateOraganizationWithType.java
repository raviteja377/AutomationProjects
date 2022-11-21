package vTiger.Practice;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOraganizationWithType {

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
		Sheet sh=wb.getSheet("Organization");
		String ORGNAME=sh.getRow(7).getCell(2).getStringCellValue();
		String INDUSTRY=sh.getRow(7).getCell(3).getStringCellValue();
		String TYPE=sh.getRow(7).getCell(4).getStringCellValue();
	 
		//Step3:launch browser Run-time polymorphisam
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
	   
		//Step4:load the application
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Step5:login to the Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
        driver.findElement(By.id("submitButton")).click();
        
        //Step6:navigate to the organization
        driver.findElement(By.linkText("Organizations")).click();
       driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
        
        //selct industry dropdown
        WebElement ele = driver.findElement(By.name("industry"));
        Select ddp=new Select(ele);
        ddp.selectByValue(INDUSTRY);
        
        //select type dropdown
        WebElement type = driver.findElement(By.name("accounttype"));
        Select dtype=new Select(type);
        dtype.selectByValue(TYPE);
       //Step7:Save 
        WebElement sav = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
        sav.click();
        Thread.sleep(3000);
        
        //Step8:Signout
        WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    	Actions act=new Actions(driver);
    	act.moveToElement(element)

    	.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
    	driver.close();

	}

}
