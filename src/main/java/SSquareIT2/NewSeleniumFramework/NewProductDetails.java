package SSquareIT2.NewSeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NewUtilities.NewBasePageClass;

public class NewProductDetails extends NewBasePageClass{
	WebDriver driver;
	
	@FindBy(xpath = "//h1[text()='Nikon D300']/..//following-sibling::ul[@class='list-unstyled'][2]//h2") 
	private WebElement price;
	
	@FindBy(xpath="//input[@name='quantity']")
	private WebElement qty;
	
	@FindBy(id = "input-quantity")
	private WebElement setQuantityButton;
		
	public NewProductDetails(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getPrice() {
		String prodPrice = price.getText();
		return prodPrice;
	}
	
	public NewCartPage setQuantity(String quantity) {
		qty.clear();
		qty.sendKeys(quantity);
		setQuantityButton.click();
		clickOnCart();
		NewCartPage cartPage = new NewCartPage(driver);
		return cartPage;
	}

}
