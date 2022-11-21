package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	//declaration
		@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement CreateOrgnizationLookUpImg;
		//initialization
		public OrganizationsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	//utilization
		public WebElement getCreateOrgnizationLookUpImg() {
			return CreateOrgnizationLookUpImg;
		}
		//bussiness logic
		/**
		 * this method will click on create new Organization look up img
		 */
		public void clickonCreateOrgnizationLookUpImg() {
			CreateOrgnizationLookUpImg.click();
		}
}
