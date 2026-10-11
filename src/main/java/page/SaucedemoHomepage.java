package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SaucedemoHomepage {

	WebDriver driver;
	WebDriverWait wait;

	By product_text = By.xpath("//span[@class='title']");
	By dropdown = By.xpath("//select[@class='product_sort_container']");
	By addToCart = By.xpath("//button[contains(text(),'Add to cart')]");
	By clickCarticon = By.xpath("//a[@class='shopping_cart_link']");

	public SaucedemoHomepage(WebDriver driver) {

		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));

	}

	public String verifyProductText() {

		return wait.until(ExpectedConditions.visibilityOfElementLocated(product_text)).getText();
	}

	public void sort() {

		WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));

		Select sel = new Select(drop);

		sel.selectByVisibleText("Price (low to high)");
	}

	public void addtoCart() {

		List<WebElement> carts = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(addToCart));

		for (WebElement btn : carts) {

			wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
		}
	}

	public void cartIconClick() {

		wait.until(ExpectedConditions.elementToBeClickable(clickCarticon)).click();
	}
}