package NewUtilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewBasePageClass {
	WebDriver driver;
	
	@FindBy(xpath = "//span[@id='cart-total']/..")
	private static WebElement cartButton;
	
	public NewBasePageClass(WebDriver driver) {
		this.driver = driver;
	}
	
	public void visibilityOfElementLocated(By findBy) {
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(10));
		wb.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
		
	}
	public static void clickOnCart() {
		cartButton.click();
		
	}

}
