package TestPakage;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import BasePakage.Base;
import PomClasses.fbHomepagePOM;
import PomClasses.fbloginPom;
import Utilities.Utility;




public class fbTest extends Base {

	WebDriver driver;
	fbloginPom facebookPomlogin;
	fbHomepagePOM HP;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters ("browser")
	
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browser.equalsIgnoreCase("chrome")) {
			driver=openChromeBrowser();
		}
		else
		{
			if(browser.equalsIgnoreCase("firefox")) {
				driver=openFirefoxBrowser();
			}
			else
			{
				if(browser.equalsIgnoreCase("edge")){
				driver=openEdgeBrowser();
			}
			}
		}
		driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void launchApplication() {
		driver.get("https://www.facebook.com/");
		}
	@BeforeMethod
	public void createObjects() {
		facebookPomlogin=new fbloginPom(driver);
		HP=new fbHomepagePOM(driver);
	}
	
	@Test (priority=1)
	public void testOfloginFuctionality() {
		testID=100;
		facebookPomlogin.SendUN();
        facebookPomlogin.Sendpwd();
        facebookPomlogin.ClickLogin();
        String url=driver.getCurrentUrl();
        Assert.assertEquals(url , "https://www.facebook.com/","url is wrong");
        String title=driver.getTitle();
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(title, "Facebook");
        soft.assertAll();
        
	}
	@Test (priority=2)
	public void testOfMarketButton()  {
		testID=101;
		HP.clickmkt();
		HP.clicknotification();
		// utils.captureScreenshot(12,"sad");
	}
	
	@Test (priority=3)
	public void testOflogOutFunctionality() {
		testID=102;
		HP.clickAccount();
		HP.clicklogOut();
	} 
	
	@AfterMethod
	public void logoutAccount(ITestResult result) throws InterruptedException, IOException {
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenshot(driver, testID);
		}
	}
	@AfterClass
	public void clearAllPomObjects() {
		facebookPomlogin=null;
		HP=null;
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
		System.gc();
	}
	
}
