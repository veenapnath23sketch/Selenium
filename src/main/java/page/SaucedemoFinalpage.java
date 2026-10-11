package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaucedemoFinalpage {

	WebDriver driver;
	WebDriverWait wait;

	By finishbtn = By.id("finish");

	public SaucedemoFinalpage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickFinish() {

		wait.until(ExpectedConditions.elementToBeClickable(finishbtn)).click();
	}
}