package SSquareIT2.NewSeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLandingPage {
	static WebDriver driver;
	@FindBy(xpath = "//span[normalize-space()='My Account']" )
	private WebElement myAccount;
	 
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']" )
	private WebElement LoginButton;
	
	public NewLandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
public NewLoginPage NavigateToLoginPage1() {
		myAccount.click();
		LoginButton.click();
		NewLoginPage login = new NewLoginPage(driver);
		return login;
}
	
}
