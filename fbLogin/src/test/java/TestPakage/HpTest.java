package TestPakage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePakage.Base;
import PomClasses.fbHomepagePOM;
import PomClasses.fbloginPom;

public class HpTest extends Base {
	WebDriver driver;
	fbloginPom facebookPomlogin;
	fbHomepagePOM HP;
	
	@BeforeTest
	@Parameters ("browser")
	public void launchBrowser(String browser) {
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
		driver.get("https://en-gb.facebook.com/");
		}
	@BeforeMethod
	public void createObjects() {
		facebookPomlogin=new fbloginPom(driver);
		HP=new fbHomepagePOM(driver);
	}
	

	@Test (priority=2)
	public void testOfMarketButton() {
		facebookPomlogin.SendUN();
        facebookPomlogin.Sendpwd();
        facebookPomlogin.ClickLogin();
		HP.clickmkt();
		HP.clicknotification();
	}
	
	@Test (priority=3)
	public void testOflogOutFunctionality() {
		HP.clickAccount();
		HP.clicklogOut();
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

