package SSquareIT2.NewSeleniumFramework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import testComponents.BaseTest;

public class VerifyInvalidLogin extends BaseTest {
	
	@Test
	public void verifyLoginWithInvalidCreds() throws IOException {
	
	WebDriver driver = initBrowser();
	NewLandingPage newLP = new NewLandingPage(driver);
	NewLoginPage login = newLP.NavigateToLoginPage1();
	NewHomePage hp = login.LoginAction("veerat_cohli22@irmail.com", "Veerat_21");
	
	SoftAssert sa = new SoftAssert();
	String actual = driver.getCurrentUrl();
	String expected = "https://tutorialsninja.com/demo/index.php?route=account/account";
	sa.assertEquals(actual, expected);
	
	sa.assertAll();
	tearDown();
	}
}
