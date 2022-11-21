package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	//declaration
	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement CreateProductLookUpImg;
	//initialization
public  ProductsPage(WebDriver driver) {
	PageFactory.initElements( driver,this);
}
//utilization
public WebElement getCreateProductLookUpImg() {
	return CreateProductLookUpImg;
}
//bussiness logic
/**
 * this method will click on new product Look Up Img
 */
public void clickOnCreateProductLookUpImg() {
	CreateProductLookUpImg.click();
}

}
