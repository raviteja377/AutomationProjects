package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {//rule1:create a separate java class for every web page
	//rule2:identify  identify locators by using @FindBy,@FindBys,@FINDAll
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passWordEdt;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	//rule3:to create a constructor to initialize the variables
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
//rule 4:provide getter method to access these variables
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getLogInBtn() {
		return loginBtn;
	}
	//Business library
	/**
	 * this method will perform login operation
	 * @param username
	 * @param password
	 */
	public void loginToApp(String username,String password)
	{
		userNameEdt.sendKeys(username);
		passWordEdt.sendKeys(password);
		loginBtn.click();
	}	
}
