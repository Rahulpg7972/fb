package Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
		//screenshot method
		
		
	    public static void captureScreenshot(WebDriver driver,int testID ) throws IOException  {
	    	Date d=new Date();
		    File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    
		    FileHandler.copy(scr,new File("test-output\\testScreenshots\\Test"+testID+" "+" "+d.toString().replaceAll(":",".")+".jpeg") );
		    
	    }
	
		
		

}
