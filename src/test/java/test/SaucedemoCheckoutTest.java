package test;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.SaucedemoBase;

public class SaucedemoCheckoutTest extends SaucedemoBase {
	
	@Test(priority = 8)
	public void textVerify()
	{
		ETest = EReports.createTest("textVerify");
		String txt1 = shp2.informationText();
		Assert.assertEquals(txt1, "Checkout: Your Information");
		System.out.println("Text verified");
	}
	
	@Test(priority = 9)
	public void submit()
	{
		ETest = EReports.createTest("submit");
		shp2.setForm("Veena", "P Nath", "690516");
		shp2.formSubmit();
		System.out.println("form submits");
	}
	
}
