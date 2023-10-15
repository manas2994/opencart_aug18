package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath= "//div[@id='content']/h2")
	WebElement msgHeading;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement LogoutBtn ;
	
	public boolean isMyAccountPageExists() {
		
		try {
		return msgHeading.isDisplayed();
		}
		catch(Exception e) {
			return (false);
		}
	}
	
	public void clickLogout()
	
	
	{
		  // Create a JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Use JavaScript Executor to click the element
        js.executeScript("arguments[0].click();", LogoutBtn);
		//LogoutBtn.click();
}
}