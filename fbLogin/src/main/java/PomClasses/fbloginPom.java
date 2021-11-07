package PomClasses;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class fbloginPom {
    private WebDriver driver;///driver=new chromedriver;
	
	
	@FindBy (xpath="//input[@id='email']")
    private WebElement UN;
	
	@FindBy (xpath="//input[@id='pass']")
    private WebElement pwd;
	
	@FindBy (xpath="//button[@name='login']")
    private WebElement login;
	
	
	public fbloginPom(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	public void SendUN() {
		UN.sendKeys("8421528708");
		
	}
	
    public void Sendpwd() {
	pwd.sendKeys("vicky81");	
	}
    
    public void ClickLogin()  {
    	
	    login.click();
	    
	   
}
   
}
