package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass  {
	


	@Test(groups= {"Regression","Master"})
	void test_account_Registration() 
	{
		
		
     logger.debug("application log....");
		
		logger.info("Starting TC_001_AccountRegistrationTest");
		
		HomePage hp=new HomePage(driver); 
		System.out.println("check data");
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Provding Customer Data ");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		
	//	regpage.setLastName(randomeString().toUpperCase());
	regpage.setEmail(randomeString()+"@gmail.com");
		
		String password =randomAlphaNumeric();
		regpage.setPassword(password);
		//System.out.println("password");
		regpage.setPrivacyPolicy();
		//System.out.println("policy");
		regpage.clickContinue();
	//	System.out.println("continue");
		
		logger.info("Click on continue");
		
		 String confmsg =regpage.getConfirmationMsg();
		 
		// System.out.println(confmsg);
		 logger.info("Validating expected message");
		 Assert.assertEquals(confmsg,"Your Account Has Been Created!","Not geeting expected message");
		 logger.info("Finished TC01");
	}
	
}