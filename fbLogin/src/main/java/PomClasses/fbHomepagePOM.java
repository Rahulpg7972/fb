package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class fbHomepagePOM {
	private WebDriver driver;
	private WebDriverWait wait;
@FindBy (xpath="(//span[@class='l9j0dhe7'])[3]")
private WebElement mkt;

@FindBy (xpath="//span[text()='Notifications']")
private WebElement notification;

@FindBy (xpath="//div[@aria-label='Account']//i")
private WebElement accounts;

@FindBy (xpath="//span[text()='Log Out']")
private WebElement logOut;

public fbHomepagePOM(WebDriver driver) {
	this.driver=driver;
	wait=new WebDriverWait(driver,20);
	PageFactory.initElements(driver, this);
}

public void clickmkt() {
	
	wait.until(ExpectedConditions.visibilityOf(mkt));
    mkt.click();	
}

public void clicknotification() {
	wait.until(ExpectedConditions.visibilityOf(notification));
	notification.click();	
}

public void clickAccount() {
	wait.until(ExpectedConditions.visibilityOf(accounts));
	accounts.click();	
}

public void clicklogOut() {
	wait.until(ExpectedConditions.visibilityOf(logOut));
	logOut.click();	
}

}
