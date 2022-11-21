  package vTiger.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * this class contains all the generic methods related to webdriver actions
 * @author ADMIN
 *
 */
public class WebDriverLibrary {
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();

	}
	/**
	 * this method will minimize the window
	 * @param driver
	 */
	public void manimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	
	
	/**
	 *this method will wait for 20sec to load the page 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	}
	/**
	 * this method will wait for 10 seconds for element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * this method will wait  10 seconds for the element to be clickable 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this is a custom wait which is used to wait for element and perform click action
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClickOnElement(WebElement element) throws InterruptedException {
		int count=0;
		while(count<10) {
			try {
				element.click();

			}catch (Exception e) {
				Thread.sleep(2000);
				count++;
			}
		}	

	}
	/**
	 * this method will handle dropdown through select class by index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
/**
 * this method will handle dropdown through select class by value
 * @param element
 * @param value
 */
	public void handleDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method will handle dropdown through select class by visibleText
	 * @param text
	 * @param element
	 */
public void handleDropDown(String text,WebElement element) {
Select s=new Select(element);
s.selectByVisibleText(text);}
/**
 * this method will perform mousehover action
 * @param driver
 * @param element
 */
public void mouseHoverOn(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver) ;
		act.moveToElement(element).perform();
	 
} 
/**
 * this method will perform right click on webpage
 * @param driver
 */
public void rightClickOn(WebDriver driver) {
	Actions act=new Actions(driver);
	act.contextClick().perform();
}
/**
 * this method will perform rightClickon particular Webelement
 * @param driver
 * @param element
 */
public void rightClickOn(WebDriver driver,WebElement element) {
	Actions act=new Actions(driver);
	act.contextClick(element).perform();
} 
/**
 * this method will perform doubleclickon webpage
 * @param driver
 * 
 */
public void doubleClickOn(WebDriver driver) {
	Actions act=new Actions(driver);
	act.doubleClick().perform();
}
/**
 * this method will perform doubleclickon particular webelement
 * @param element
 * @param driver
 */
public void doubleClickOn(WebElement element,WebDriver driver) {
Actions act=new Actions(driver);
act.doubleClick(element).perform();
}
/**
 * this method will drag and drop from source elemernt to dstination element
 * @param driver
 * @param srcelement
 * @param dstelement
 */
public void dragAndDropOn(WebDriver driver,WebElement srcElement,WebElement dstElement) {
	Actions act=new Actions(driver);
	act.dragAndDrop(srcElement, dstElement).perform();
}
/**
 * this is method will mouse hover using offset value for x and y coordinates 
 * @param driver
 * @param xOff
 * @param yOff
 */
public void mouseHoverOn(WebDriver driver,int xOff,int yOff) {
	Actions act=new Actions(driver);
	act.moveByOffset(xOff, yOff).perform();
}
/**
 * this method will switch to frame based on index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index) {
driver.switchTo().frame(index);	
}
/**
 * this method will switch to frame based on nameOrId
 * @param driver
 * @param nameOrId
 */
public void switchToFrame(WebDriver driver,String nameOrId) {
	driver.switchTo().frame(nameOrId);
}
/**
 * this method will switch to frame based on webelement
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
}
/**
 * this method will switch to frame from current frame to immidiate parentframe
 * @param driver
 */
public void switchToParentFrame(WebDriver driver) {
	driver.switchTo().parentFrame();
}
/**
 * this method will switch to frame based on defaultcontent
 * @param driver
 */
public void switchToDefaultContent(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * this method will click on accept in alert popup
 * @param driver
 */
public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();;
}
/**
 * this method will click mon dismiss in alert popup
 * @param driver
 */
public void dismissAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();
}
/**
 * this method will return text of alert popup  to caller
 * @param driver
 * @return 
 * @return
 */
public String getAlertText(WebDriver driver) {
	String alerttext=driver.switchTo().alert().getText();
	return alerttext;
} 
/**
 * this method will press enter key
 * @throws AWTException
 */
public void pressEnter() throws AWTException{
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);}
/**
 * This method will switch from parent window to any child window or from any child window
 * to parent window based on the partial window title.
 * @param driver
 * @param partialWindowTitle
 */
	public void switchToWindow(WebDriver driver, String partialWindowTitle)
{
	//Step 1: get all the window handles
	Set<String> windowIds = driver.getWindowHandles();
	
	//Step 2: iterate through all the window ids --- similar to foreach loop
	Iterator<String> it = windowIds.iterator();
	
	//Step 3: navigate to each window and check the title
	while(it.hasNext())
	{
		//Step  4: capture the individual window id
		String winID = it.next();
		
		//Step 5: switch to that window and capture the title
		String currentTitle = driver.switchTo().window(winID).getTitle();
		
		//Step 6: compare current title with partial title
		if(currentTitle.contains(partialWindowTitle))
		{
			break;
		}
	}
	
}

/**
 * This method will take the screen shot 
 * @param driver
 * @param screenshotName
 * @return
 * @throws IOException
 */
public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException 
{
	TakesScreenshot ts=(TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	     String path = ".\\Screenshots\\"+screenshotName+".png";
	File dest = new File(path);
	FileUtils.copyFile(src, dest);//form commons io
	//Files.copy(src, dest);
	return    dest.getAbsolutePath();//used for extents reports
	}
/**
 * this method will Scroll Down for 500 units
 * @param driver
 */
public void scrollAction(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.ScrollBy(0,500)", "");
}
/**
 * this method will scroll until specified element is found
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver,WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	int y = element.getLocation().getY();
	js.executeScript("window.ScrollBy(0,"+y+")", element);
}
}

