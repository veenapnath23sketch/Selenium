package test;
import org.testng.annotations.Test;
import base.SaucedemoBase;

public class SaucedemoFinalTest extends SaucedemoBase {

	@Test(priority = 10)
	
	public void finish()
	{
		ETest = EReports.createTest("finish");
		shp3.clickFinish();
		System.out.println("Purchases completed");
	}
}