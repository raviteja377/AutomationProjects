package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorInfopage {
	//declaration
@FindBy(className = "lvtHeaderText")
private WebElement vendorHeaderTxt;
//initialization
public  VendorInfopage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getvendorHeaderTxt() {
	return vendorHeaderTxt;
}
//bussiness logic
public String getHeaderText()
{
	return vendorHeaderTxt.getText();}
}
