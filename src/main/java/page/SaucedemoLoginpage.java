package page;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaucedemoLoginpage {

	WebDriver driver;
	WebDriverWait wait;

	By usernamefield = By.id("user-name");
	By passwordfield = By.id("password");
	By loginbutton = By.id("login-button");

	public SaucedemoLoginpage(WebDriver driver) 
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	}

	public void setValues(String username, String password) 
	{
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernamefield)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordfield)).sendKeys(password);
	}

	public void loginClick() 
	{

		wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();
	}
}