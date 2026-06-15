package stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;

public class Login {
	
		WebDriver driver;
		@Given("User launches the browser")
		public void User_launches_the_browser() {
			driver = new ChromeDriver();
		}
		
		@When("User opens the login page")
		public void User_opens_the_login_page(){
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		@And("User enters username and password")
		public void User_enters_username_and_password(){
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		}
		@Then("User should login successfully")
		public void User_should_login_successfully() {
			  System.out.println("Login successful");
	}

}