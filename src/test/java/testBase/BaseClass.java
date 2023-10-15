package testBase;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;

import java.util.Date;
import java.util.ResourceBundle;

//import org.slf4j.LogManager;

import java.util.logging.Level;

public class BaseClass {

	public static  WebDriver driver;
	public ResourceBundle rb;

	public org.apache.logging.log4j.Logger logger;

	@BeforeClass(groups= {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup(String br) {

		rb = ResourceBundle.getBundle("config");// Load config.properties files
		logger = LogManager.getLogger(this.getClass());

		// ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("excludeSwitches", new String[]
		// {"enable-automation"});

		// WebDriverManager.chromedriver().setup();
		if (br.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("http://localhost/opencart/upload/index.php");
		driver.get(rb.getString("appURL1"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups= {"Master","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}

	public String randomeString() {

		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeNumber() {

		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return generatedString2;
	}

	public String randomAlphaNumeric() {

		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		return (st + "@" + num);
	}

	public String captureScreen(String tname) {

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
       Date dt = new Date();
       String timeStamp = df.format(dt);
       
       TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
       File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
       String destination=System.getProperty("user.dir")+ "\\screenshots\\" + tname + "_" +timeStamp + ".png";
       
       try {
       FileUtils.copyFile(source, new File(destination));
       } catch(Exception e)
       {
        e.getMessage();
       }
       

		return destination;
	}
}
