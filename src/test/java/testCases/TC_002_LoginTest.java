package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {
   
	@Test(groups= {"Sanity","Master"})
	public void test_Login() {
       
		try {
		logger.info("Starting TC_002_Logontest ****");

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		hp.clickLogin();
		logger.info("Clicked on Login link");

		LoginPage lp = new LoginPage(driver);
		logger.info("Provide Login details");
		
		lp.setEmail(rb.getString("email")); // valid email,get it from config properties
		lp.setPassword(rb.getString("password"));// valid password,get it from config properties
		lp.clickButton();

		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true);
		}
		catch(Exception e )
		{
			Assert.fail();
		}
		
		logger.info(" *** Finished TC_002_LoginTest****");
	}

}
