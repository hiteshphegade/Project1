package SSquareIT2.NewSeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NewUtilities.NewBasePageClass;

public class NewProductPage extends NewBasePageClass{
		WebDriver driver;
		
	@FindBy(css = "div.product-grid")
	private List<WebElement> products;
	
	By productLocation = By.cssSelector("div h4");
	By addToCart = By.cssSelector("a");
	
	public NewProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> getProducts(){
		visibilityOfElementLocated(productLocation);
		return products;
	}
	
	public WebElement getProductByName(String prodName) {
		WebElement prodCamera = null;
		for(WebElement product:products) {
			WebElement targetProduct = product.findElement(productLocation);
			String productName = targetProduct.getText();
			//System.out.println(productName);
			if(productName.equalsIgnoreCase(prodName)) {
				prodCamera = targetProduct.findElement(addToCart);
				return prodCamera;
			}
			
		}
		return prodCamera;
	}
	
	public NewProductDetails addProductToCart(String prodName) {
		WebElement prod = getProductByName(prodName);
		prod.click();
		NewProductDetails productDetails = new NewProductDetails(driver);
		return productDetails;
	}

}
