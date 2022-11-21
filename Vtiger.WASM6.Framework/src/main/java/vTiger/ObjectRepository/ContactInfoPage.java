package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	//declaration
@FindBy(className = "dvHeaderText")
private WebElement contactHeaderTxt;
//initialization
public  ContactInfoPage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
}
//utilization
public WebElement getContactHeaderTxt() {
	return contactHeaderTxt;
}
//bussiness logic
public String getHeaderText()
{
	return contactHeaderTxt.getText();}}
