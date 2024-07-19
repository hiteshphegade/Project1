package SSquareIT2.NewSeleniumFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewHomePage {
	WebDriver driver;
	@FindBy(xpath = "//li//a[text()=\"Cameras\"]")
	private WebElement cameraTab;
	
	public NewHomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public NewProductPage clickOnCameraTab() {
		cameraTab.click();
		NewProductPage pp = new NewProductPage(driver);
		return pp;
		
	}

}
