package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocatorLoginPage {

	public WebDriver driver;

	public LocatorLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.name("username");
	By password = By.name("password");
	By loginBtn = By.xpath("//button[@type='submit']");

	public void loginToApp(String user, String pass) {
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}

}