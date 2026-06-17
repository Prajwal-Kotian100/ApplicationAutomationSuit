package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorsAdminPage {

	WebDriver driver;

	public LocatorsAdminPage(WebDriver driver) {
		this.driver = driver;
	}

	// ✅ Locators
	By sideSearch = By.xpath("//button[@type='button']/preceding-sibling::input");
	By clickAdm = By.xpath("//span[text()='Admin']");
	By usernameField = By.xpath("//label[text()='Username']/ancestor::div[contains(@class,'oxd-input-group')]//input");
	By role = By.xpath("//label[text()='User Role']/parent::div/following-sibling::div/div/div/descendant::i");
	By empName = By.xpath("//label[text()='Employee Name']/parent::div/following-sibling::div/div/div/descendant::input");
	By stat = By.xpath("//label[text()='Status']/parent::div/following-sibling::div/div/div/descendant::i");
	By searchBtn = By.xpath("//button[normalize-space()='Search']");
	By resetBtn = By.xpath("//button[normalize-space()='Reset']");
	By resultTable = //span[contains(normalize-space(), 'Found')];

	// ✅ Actions

	public void openAdmin() {
		driver.findElement(sideSearch).sendKeys("Admin");
		driver.findElement(sideSearch).sendKeys(Keys.ENTER);
		driver.findElement(clickAdm).click();
	}

	public void enterDetails(String username, String userRole, String employeeName, String status) {
		driver.findElement(usernameField).clear();
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(role).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='listbox']//div[@role='option' and normalize-space()='" + userRole + "']"))).click();

		if (employeeName != null && !employeeName.isEmpty()) {
			driver.findElement(empName).sendKeys(employeeName);
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + employeeName + "']")))
					.click();
		}
		driver.findElement(stat).click();
		driver.findElement(By.xpath("//span[text()='" + status + "']")).click();

	}

	public void clickSearch() {
		driver.findElement(searchBtn).click();
	}

	public void clickReset() {
		driver.findElement(resetBtn).click();
	}

	public boolean isResultDisplayed() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(resultTable));
		    return driver.findElement(resultTable).isDisplayed();
	}

	public boolean isFieldsCleared() {
		String value = driver.findElement(usernameField).getAttribute("value");
		return value == null || value.isEmpty();
	}


}
