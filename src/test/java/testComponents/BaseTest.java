package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class BaseTest {
	
	static WebDriver driver;
	public WebDriver initBrowser() throws IOException {
		
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hites\\eclipse-workspace\\NewSeleniumFramework3\\src\\main\\java\\resources\\Properties.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		String baseUrl = prop.getProperty("baseUrl");
		driver.get(baseUrl);
		return driver;
	}
	
	public void tearDown() {
		driver.close();
	}
	
	public static String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File(path);
		FileHandler.copy(sourceFile, targetFile);
		return path;
		
	}

}
