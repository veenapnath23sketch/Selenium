package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SaucedemoBase;

public class SaucedemoCarttest extends SaucedemoBase {
	
	@Test (priority = 4)
	public void getCartTxt()
	{
		ETest = EReports.createTest("getCartTxt");
		String txt = shp1.yourCartText();
		Assert.assertEquals(txt, "Your Cart");
		System.out.println("Text verified");
	}
	
	@Test(priority = 5)
	public void enableBtnContinue()
	{
		ETest = EReports.createTest("enableBtnContinue");
		shp1.continueBtnEnabled();
		Assert.assertTrue(true,"Button is not enabled");
		System.out.println("continue button enabled");
	}
	@Test(priority = 6)
	
	public void enableBtnCheckout()
	{
		ETest = EReports.createTest("enableBtnCheckout");
		shp1.checkoutBtnEnabled();
		Assert.assertTrue(true,"Button is not enabled");
		System.out.println("checkout button enabled");
	}
	
	@Test(priority = 7)
	public void clickCheckoutbtn()
	{
		ETest = EReports.createTest("clickCheckoutBtn");
		shp1.clickCheckout();
		System.out.println("Checkout clicks");
	}
	
}