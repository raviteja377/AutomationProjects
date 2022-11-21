package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericLibrary.WebDriverLibrary;

public class CreateNewProductPage extends WebDriverLibrary {
	//declaration
	@FindBy(name="productname")
	private WebElement productnameEdt;
	@FindBy(xpath="//input[@name='vendor_name']/following-sibling::img[@title='Select']")
    private WebElement venImg;

@FindBy(id="search_txt")
private WebElement searchEdt;

@FindBy(name="search")
private WebElement searchNowBtn;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
//initialization
public	CreateNewProductPage(WebDriver driver) {
	PageFactory.initElements( driver,this);
}
//utilization
public WebElement getProductnameEdt() {
	return productnameEdt;
}
public WebElement getVenImg() {
	return venImg;
}	public WebElement getSearchEdt() {
	return searchEdt;
}
public WebElement getSearchNowBtn() {
	return searchNowBtn;
}
public WebElement getSaveBtn() {
	return saveBtn;
}
//bussiness logic
/**
 * this method will create new product and save
 * @param productname
 */
public void createProduct(String productname) {
	productnameEdt.sendKeys(productname);
	saveBtn.click();
}
public void createProduct(WebDriver driver,String productname,String vendorname) {
	productnameEdt.sendKeys(productname);
	venImg.click();
 switchToWindow(driver, "Vendors");
 searchEdt.sendKeys(vendorname);
 searchNowBtn.click();
 driver.findElement(By.xpath("//a[.='"+vendorname+"']")).click();
 switchToWindow(driver, "Products");
 saveBtn.click();
 
}

}
