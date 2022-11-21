
package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewContactPage extends WebDriverLibrary {
	//decleration
@FindBy(name="lastname")
private WebElement lastnameEdt;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img[@alt='Select']")
private WebElement orgImg;

@FindBy(id="search_txt")
private WebElement searchEdt;

@FindBy(name="search")
private WebElement searchNowBtn;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(name="leadsource")
private WebElement leadSourceDrpdown;
//inialization
public CreateNewContactPage(WebDriver driver)
{
	PageFactory.initElements( driver,this);
	}

public WebElement getLastnameEdt() {
	return lastnameEdt;
}

public WebElement getOrgImg() {
	return orgImg;
}

public WebElement getSearchEdt() {
	return searchEdt;
}

public WebElement getSearchNowBtn() {
	return searchNowBtn;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

public WebElement getLeadSourceDrpdown() {
	return leadSourceDrpdown;
}
//bussiness logic
/**
 * this method will create contact and save
 * @param lastname
 */
public void cretaeNewContact(String lastname) {
	lastnameEdt.sendKeys(lastname);
	saveBtn.click();
}
/**this method will create contact with leadsource
 * this method
 * @param lastname
 * @param leadsource
 */
public void cretaeNewContact(String lastname,String leadsource) {
	lastnameEdt.sendKeys(lastname);
	handleDropDown(leadSourceDrpdown, leadsource);
	saveBtn.click();
}
/**
 * this method will create contact with organization
 * @param driver
 * @param lastname
 * @param orgname
 */
public void createnewContact(WebDriver driver,String lastname,String orgname) {
	lastnameEdt.sendKeys(lastname);
	orgImg.click();
	switchToWindow(driver, "Accounts");
	searchEdt.sendKeys(orgname);
	searchNowBtn.click();
	driver.findElement(By.linkText(orgname)).click();
	//driver.findElement(By.xpath("//a[.='"+orgname+"']")).click();
	switchToWindow(driver, "Contacts");
	saveBtn.click();
}
}
