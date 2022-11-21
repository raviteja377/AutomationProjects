package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//declaration
	@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement CreateContactLookUpImg;
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getCreateContactLookUpImg() {
		return CreateContactLookUpImg;
	}
	//bussiness logic
	/**
	 * this method will click on create new contact look up img
	 */
	public void clickonCreateContactImg() {
		CreateContactLookUpImg.click();
	}
}
