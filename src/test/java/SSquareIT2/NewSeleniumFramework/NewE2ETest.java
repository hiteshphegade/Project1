package SSquareIT2.NewSeleniumFramework;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testComponents.BaseTest;

public class NewE2ETest extends BaseTest{
	
		@Test(dataProvider = "getData")
		public void newEndToEndTest(String username, String password) throws IOException {
			WebDriver driver = initBrowser();
			NewLandingPage newLP = new NewLandingPage(driver);
			NewLoginPage login = newLP.NavigateToLoginPage1();
			NewHomePage hp = login.LoginAction(username, password);
			NewProductPage pp = hp.clickOnCameraTab();
			List<WebElement> products = pp.getProducts();
			NewProductDetails productDetails = pp.addProductToCart("Nikon D300");
			Assert.assertEquals(productDetails.getPrice(), "$98.00");
			NewCartPage cartPage = productDetails.setQuantity("2");
			Assert.assertEquals(cartPage.getPrice(), "$196.00");
			NewCheckOutPage checkOutPage = cartPage.goToCheckOutPage();
			checkOutPage.clickToCheckOut();
			checkOutPage.closeErrorMessage();
			boolean isSuccess = checkOutPage.getSuccessMessage().equalsIgnoreCase("***");
			Assert.assertTrue(isSuccess);
			
			tearDown();
			}
		
		@DataProvider(name = "getData")
		public Object[][] getData() {
			return new Object[][] {{"veerat_cohli22@irmail.com", "Veerat_22"},{"veerat_cohli22@irmail.com", "Veerat_21"}};
			
		}
	
	

}
