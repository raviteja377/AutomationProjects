package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class HomePage extends WebDriverLibrary {
//declaration
	@FindBy(linkText = "Organizations")
	private WebElement OrganizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement ProductsLnk;
	@FindBy(linkText="More")
	private WebElement moreLnk;

	@FindBy(linkText="Vendors")
	private WebElement VendorsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
//utilization
	public WebElement getOrganizationLnk() {
		return OrganizationLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return ProductsLnk;
	}
	public WebElement getMoreLnk() {
		return moreLnk;
	}
	public WebElement getVendorssLnk() {
		return VendorsLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	//bussiness logic
	/**
	 * this method will click on organizations link
	 */
	public void clickOnOrganizationsLnk() {
		OrganizationLnk.click();
	}
	/**
	 * this method will click on contacts link
	 */
	public void clickOnContactsLnk() {
		ContactsLnk.click();
	}
	/**
	 * this method wii click on products link
	 */
	public void clickOnProductsLnk() {
		ProductsLnk.click();
	}
	/**
	 * this method will click on vendors link
	 * @param driver
	 */
	public void clickOnVendorsLnk(WebDriver driver) {
		mouseHoverOn(driver, moreLnk);
		VendorsLnk.click();
	}
	/**
	 * this method will perform mousehover and clickon signout link 
	 * @param driver
	 */
	public void signOutApp(WebDriver driver) {
		mouseHoverOn(driver, AdministratorImg);
		SignOutLnk.click();
	}
	}
