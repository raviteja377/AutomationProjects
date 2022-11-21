package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewOrganizationPage extends WebDriverLibrary {
	//declaration
@FindBy(name="accountname")
private WebElement OrgnameEdt;
@FindBy(name="industry")
private WebElement industryDropdown;
@FindBy(name="accounttype")
private WebElement typeDropdown;
@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;



//initialization
public  CreateNewOrganizationPage(WebDriver driver) {
	PageFactory.initElements( driver,this);
}
//utilization
public WebElement getOrgnameEdt() {
	return OrgnameEdt;
}

public WebElement getIndustryDropdown() {
	return industryDropdown;
}

public WebElement getTypeDropdown() {
	return typeDropdown;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
//bussiness logic
/**
 * this method will create new organization and save
 * @param Orgname
 */
public void createNewOrganization(String Orgname) {
	OrgnameEdt.sendKeys(Orgname);
	saveBtn.click();
}
/**
 * this method will create new organization with industry
 * @param Orgname
 * @param industry
 */
public void createNewOrganization(String Orgname,String industry) {
	OrgnameEdt.sendKeys(Orgname);
	handleDropDown(industryDropdown, industry);
	saveBtn.click();
}
/**
 * this method will create new organization with industry and type
 * @param Orgname
 * @param industry
 * @param type
 */
public void createNewOrganization(String Orgname,String industry,String type) {
	OrgnameEdt.sendKeys(Orgname);
	handleDropDown(industryDropdown, industry);
	handleDropDown(typeDropdown, type);
	saveBtn.click();
}

}
