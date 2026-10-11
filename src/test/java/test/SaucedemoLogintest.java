package test;

import org.testng.annotations.Test;
import base.SaucedemoBase;
import page.SaucedemoLoginpage;
public class SaucedemoLogintest extends SaucedemoBase{
	
	@Test
	public void login()
	{
		ETest = EReports.createTest("login");
		SaucedemoLoginpage obj = new SaucedemoLoginpage(driver);
		obj.setValues("standard_user", "secret_sauce");
		obj.loginClick();
		System.out.println("login success");
	}

}
