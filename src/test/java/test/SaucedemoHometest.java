package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.SaucedemoBase;

public class SaucedemoHometest extends SaucedemoBase {
	
	@Test (priority = 0)
	public void products()
	{
		ETest = EReports.createTest("products");
		String actual = shp.verifyProductText();
		String expected = "Products";
		Assert.assertEquals(actual, expected, " Matching");
		System.out.println("product text verified");
	}
	
	@Test (priority =1)
	public void dropdownSorting()
	{
		ETest = EReports.createTest("dropdownSorting");
		shp.sort();
		System.out.println("sorting completed");
	}
	
	@Test (priority = 2)
	public void cart()
	{
	  ETest = EReports.createTest("cart");
		shp.addtoCart();
		System.out.println("products added");
	}
	
	@Test (priority = 3)
	
	public void iconCart()
	{
		ETest = EReports.createTest("iconCart");
		shp.cartIconClick();
		System.out.println("cart icon clicks");
	}
	
}
