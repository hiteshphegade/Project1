package SSquareIT2.NewSeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLoginPage {
	WebDriver driver;
	@FindBy(id = "input-email")
	private WebElement username;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement submitButton;
	
	public NewLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public NewHomePage LoginAction(String userEmail, String userPassword) {
		username.sendKeys(userEmail);
		password.sendKeys(userPassword);
		submitButton.click();
		NewHomePage hp = new NewHomePage(driver);
		return hp;
	}


}
