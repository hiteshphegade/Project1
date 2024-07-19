package SSquareIT2.NewSeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCartPage {
	WebDriver driver;
	
	@FindBy(xpath = "//strong[text()='Total']/../following-sibling::td")
	private WebElement totalPrice;
	
	@FindBy(xpath = "//strong[text()='Checkout']")
	private WebElement checkOutButton;
		
	public NewCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		String netPrice = totalPrice.getText();
		return netPrice;
	}
	
	public NewCheckOutPage goToCheckOutPage() {
		checkOutButton.click();	
		NewCheckOutPage checkOutPage = new NewCheckOutPage(driver);
		return checkOutPage;
		
	}
}
