package hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.LocatorLoginPage;

public class Hooks{
	public static WebDriver driver;
	public static Properties prop;
	
	@Before
	public void setup() throws IOException {
		 prop = new Properties();
         FileInputStream fis = new FileInputStream("src/test/resources/configfile/config.properties");
         prop.load(fis);
         String browser = prop.getProperty("browser");
         if(browser.equalsIgnoreCase("Chrome")) {
        	 driver = new ChromeDriver();
         }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get(prop.getProperty("url"));
         LocatorLoginPage login = new LocatorLoginPage(driver);
         login.loginToApp(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@After
	public void tearDown() {
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
}