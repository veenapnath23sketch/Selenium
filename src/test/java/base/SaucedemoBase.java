package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import page.SaucedemoCartpage;
import page.SaucedemoCheckout;
import page.SaucedemoFinalpage;
import page.SaucedemoHomepage;

public class SaucedemoBase {

	public static WebDriver driver;

	public static ExtentSparkReporter ESreporter;
	public static ExtentTest ETest;
	public static ExtentReports EReports;

	public SaucedemoHomepage shp;
	public SaucedemoCartpage shp1;
	public SaucedemoCheckout shp2;
	public SaucedemoFinalpage shp3;

	@BeforeTest
	public void set() {

		ESreporter = new ExtentSparkReporter("./Report/myreport.html");
        ESreporter.config().setDocumentTitle("Automation_Report");
		ESreporter.config().setReportName("Functional Test");
		ESreporter.config().setTheme(Theme.DARK);

		EReports = new ExtentReports();
		EReports.attachReporter(ESreporter);

		EReports.setSystemInfo("hostname", "localhost");
		EReports.setSystemInfo("os", "Windows 11");
		EReports.setSystemInfo("Tester Name", "Veena P Nath");
		EReports.setSystemInfo("Browser Name", "Google Chrome");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");

		driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        
	}

	@BeforeMethod
	public void object(Method method) {

		ETest = EReports.createTest(method.getName());

		shp  = new SaucedemoHomepage(driver);
		shp1 = new SaucedemoCartpage(driver);
		shp2 = new SaucedemoCheckout(driver);
		shp3 = new SaucedemoFinalpage(driver);
	}

	@AfterMethod
	public void browserclose(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			ETest.log(Status.FAIL, "Failed test case: " + result.getName());

			ETest.log(Status.FAIL, "Exception: " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {

			ETest.log(Status.SKIP, "Skipped test case: " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			ETest.log(Status.PASS, "Passed test case: " + result.getName());
		}
	}

	@AfterTest
	public void save() {

		EReports.flush();

		driver.quit();
	}
}