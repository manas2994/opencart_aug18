package testCases;

import static org.testng.Assert.assertTrue;

import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)// becoz DataProvider is present in different class so we use dataproviderclass parameter
	public void  test_LoginDDT(String email, String password,String exp) {
 	
		logger.info(" Starting TC03");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account");
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		logger.info("Provide Login details");
		
		lp.setEmail(email); // valid email,get it from config properties
		lp.setPassword(password);// valid password,get it from config properties
		lp.clickButton();
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		if(exp.equals("Valid")) {
			
			if(targetPage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equals("Invlid"))
		{
			if(targetPage==true) {
				
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
  
  logger.info("TC_03 Finished");
	}
	}

