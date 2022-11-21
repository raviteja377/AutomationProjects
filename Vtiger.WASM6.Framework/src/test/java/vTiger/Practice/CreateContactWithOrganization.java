package vTiger.Practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithOrganization {

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
		String ORGNAME=sh.getRow(1).getCell(2).getStringCellValue();
		
		Sheet sh1 = wb.getSheet("Contacts");
	 String LASTNAME = sh1.getRow(1).getCell(2).getStringCellValue();
	 
		//Step3:launch browser-Run-Time polymoorphisam
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
			 System.out.println("---invalid browser name");
		 }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step2:load the application
		
		driver.get(URL);

		//Step3:login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//Step4: navigate into organization link 
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//Step5:create new Ogrganization with mandatory feilds
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);


		//Step6:save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step7:navigate to contacts
		Thread.sleep(1000);
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step8:create contact with mandatory feilds
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();

		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		for(String childs:child) {
			if(!parent.equalsIgnoreCase(childs)) {
				driver.switchTo().window(childs);
				WebElement sea = driver.findElement(By.id("search_txt"));
				sea.sendKeys(ORGNAME);
				sea.submit();
				driver.findElement(By.linkText(ORGNAME)).click();

			}
		}
		driver.switchTo().window(parent);
		//step6: save
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
		//Step7:logout 
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element)

		.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();

		//Step8:close the browser
		driver.close();

	}

}
