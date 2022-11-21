package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	//declaration
	@FindBy(className = "lvtHeaderText")
	private WebElement productHeaderTxt;
	//initialization
	public  ProductInfoPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	//utilization
	public WebElement getproductHeaderTxt() {
		return productHeaderTxt;
	}
	//bussiness logic
	/**
	 * this method will return the header text
	 * @return
	 */
	public String getHeaderText()
	{
		return productHeaderTxt.getText();
		}



}
