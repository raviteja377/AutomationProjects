package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationinfoPage {
	@FindBy(className = "dvHeaderText")
	private WebElement orgHeaderTxt;
	public  OrganizationinfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	public WebElement getorgHeaderTxt() {
		return orgHeaderTxt;
	}
	/**
	 * this method will return the header text
	 * @return
	 */
	public String getHeaderText()
	{
		return orgHeaderTxt.getText();}

}
