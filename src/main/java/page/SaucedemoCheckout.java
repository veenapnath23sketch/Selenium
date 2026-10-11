package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaucedemoCheckout {

	WebDriver driver;
	WebDriverWait wait;

	By informationtxt = By.xpath("//span[@class='title']");
	By firstname = By.id("first-name");
	By lastname = By.id("last-name");
	By zipcode = By.id("postal-code");
	By continuebutton = By.name("continue");

	public SaucedemoCheckout(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public String informationText() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(informationtxt)).getText();
	}

	public void setForm(String fname, String lname, String zip) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys(fname);

		wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys(lname);

		wait.until(ExpectedConditions.visibilityOfElementLocated(zipcode)).sendKeys(zip);
	}

	public void formSubmit() {

		wait.until(ExpectedConditions.elementToBeClickable(continuebutton)).click();
	}
}