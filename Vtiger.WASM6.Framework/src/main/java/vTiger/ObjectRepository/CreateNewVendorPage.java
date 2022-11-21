package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage{
@FindBy(name="vendorname")
private WebElement vendorNameEdt;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;
public CreateNewVendorPage(WebDriver driver) {
	PageFactory.initElements( driver,this);
}
public WebElement getVendorNameEdt() {
	return vendorNameEdt;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
//bussiness logic
public void createNewVendor(String vendorname) {
	vendorNameEdt.sendKeys(vendorname);
	saveBtn.click();
}
}
