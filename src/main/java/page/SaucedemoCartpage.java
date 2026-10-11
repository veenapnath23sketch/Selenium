package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SaucedemoCartpage {

	WebDriver driver;
	By yourcarttext = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
	By continuebtn = By.xpath("//*[@id=\"continue-shopping\"]");
	By checkoutbtn = By.xpath("//*[@id=\"checkout\"]");

	public SaucedemoCartpage(WebDriver driver) {
		this.driver = driver;
		
	}

	public String yourCartText() 
	{
		return driver.findElement(yourcarttext).getText();
	}

	public void continueBtnEnabled() 
	{
		driver.findElement(continuebtn).isEnabled();
	}

	public void checkoutBtnEnabled() 
	{
		driver.findElement(checkoutbtn).isEnabled();
	}

	public void clickCheckout() 
	{
		driver.findElement(checkoutbtn).click();
	}
}
