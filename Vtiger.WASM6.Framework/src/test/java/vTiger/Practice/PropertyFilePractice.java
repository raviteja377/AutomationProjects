package vTiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class PropertyFilePractice {

	public static void main(String[] args) throws Exception {
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
Properties pobj=new Properties();
pobj.load(fis);
String BROWSER = pobj.getProperty("browser");
String URL = pobj.getProperty("url");
String USERNAME = pobj.getProperty("username");
String PASSWORD = pobj.getProperty("password");
System.out.println(BROWSER);
System.out.println(URL);
System.out.println(USERNAME);
System.out.println(PASSWORD);
WebDriver driver=new ChromeDriver();
driver.switchTo().newWindow(WindowType.TAB);
   

	}

}
