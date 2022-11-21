package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	//declaration
	@FindBy(xpath="//img[@title='Create Vendor...']")
private WebElement CreateVendorLookUpImg;
	//initialization
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getCreateVendorLookUpImg() {
		return CreateVendorLookUpImg;
	}
	//bussiness logic
	/**
	 * this method will click on create new vendor look up img
	 */
	public void clickonCreateVendorLookUpImg() {
		CreateVendorLookUpImg.click();
	}
}
