package BasePakage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
static WebDriver driver;
	public static WebDriver openChromeBrowser() {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("disable-notifications");
		System.setProperty("webdriver.chrome.driver","F:\\New folder\\latestChrome\\chromedriver.exe");
	    driver= new ChromeDriver(opt);
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","E:\\Ss\\geckodriver.exe");
		 driver= new FirefoxDriver();
		return driver;
	}
	public static WebDriver openEdgeBrowser() {
		
		System.setProperty("webdriver.edge.driver","F:\\New folder\\edge.exe\\msedgedriver.exe");
		 driver= new EdgeDriver();
		return driver;
	}
	
}
