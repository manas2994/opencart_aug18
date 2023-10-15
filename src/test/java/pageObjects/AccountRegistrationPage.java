package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name= "firstname")
	WebElement txtFirstname;
	
	@FindBy(name= "lastname")
	WebElement txtLastname;
	
	@FindBy(name="email")
	WebElement txtEmail;
	
	@FindBy(name="password")
	WebElement textPassword;
	
	  
	
	//@FindBy(xpath="/html/body/main/div[2]/div/div/form/div/div/div/input") 
	
	//WebElement chkdPolicy;
	
	//@FindBy(xpath ="/html/body/main/div[2]/div/div/form/div/div/button")
	
	// WebElement btnContinue;
	
	@FindBy(xpath ="//*[@id=\"common-success\"]/ul/li[3]/a")
	
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname) {
	 txtFirstname.sendKeys(fname);}
	
	public void setLastName(String lname) {
		 txtLastname.sendKeys(lname);}
	
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String pwd) {
		textPassword.sendKeys(pwd);
	}
	public void setPrivacyPolicy() {
		
		WebElement chkdPolicy = driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/div/input"));
	//	Actions action = new Actions(driver);
		//action.moveToElement(chkdPolicy).click().build().perform();
		//chkdPolicy.click();
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", chkdPolicy);
	}
		public void clickContinue() {
			WebElement btnContinue = driver.findElement(By.xpath("//*[@id=\"form-register\"]/div/button"));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", btnContinue);
			
			//btnContinue.click();
		}
		
		public String getConfirmationMsg() {
			
			 return msgConfirmation.getText();
			
		}
	
	
	/*
	  
	 * 
	 * @FindBy() WebElement
	 * 
	 * @FindBy() WebElement
	 */
	
}
