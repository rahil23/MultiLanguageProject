package tests;

import org.testng.annotations.Test;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import configReader.ConfigPropertiesReader;
import configReader.DriverFactory;

import pages.HomePage;

public class HomePageTests extends DriverFactory {
	
	DriverFactory driverFactory;
	ConfigPropertiesReader cp;
	Properties prop;
	WebDriver driver;
	HomePage homePage;
	ExtentTest test;

	/***
	 * This is setup method for tests which is responsible for the driver, properties file, extent reports initialization
	 */
	@BeforeTest
	public void setup()
	{
		cp = new ConfigPropertiesReader();
		//prop = cp.initLanguageProp("english");
		prop = cp.initLanguageProp();
		driverFactory = new DriverFactory();
		driver = driverFactory.initDriver("chrome", prop);
		initializeReport(prop);
		homePage = new HomePage(driver);
	
	}
	
/***
 * This is one of the test method responsible for validating the 'get Involved' text on the home page
 * of the website , clicking on the 'get Involved' text.
 * and validating the title of the page in multiple language
 */

@Test(priority=3)
public void clickGetInvolved()
{
	test = extent.createTest("CLicking on get involved and verfying page title");
	test.log(Status.INFO, "open the UN Page and verify the disply of get Involve link test");
	test.assignCategory("smoke test");
	String value = prop.getProperty("getInvolvedText");
	boolean result = homePage.isDisplayGetInvolved(value);
	Assert.assertTrue(result);
	String expectedPageInvolvedTitle=prop.getProperty("getInvolvedTitle");
	
	test.log(Status.INFO, "click on  get Involve link test");
    String title = homePage.isDisplayGetInvolvedCLick(value,expectedPageInvolvedTitle);
    System.out.println(title);
    
	test.log(Status.INFO, "verify the title of get Involve link Page");
    Assert.assertEquals(title, prop.getProperty("getInvolvedTitle"));
    System.out.println("test is over");	
	
}

/***
 * This is one of the test method responsible for validating the first Article title on the home page
 */
@Test(priority=1)
public void firstArticleValue()
{
	test = extent.createTest("Opening the browser and verfy the first article on home page");
	test.log(Status.INFO, "Opening the browser and verfy the first article on home page");
	test.assignCategory("smoke test");
	Assert.assertEquals(homePage.getFirstArticleTitle(),prop.getProperty("firstArticle"));	
}

/***
 * This is one of the test method responsible for validating the title of the home page in multiple language
 */
@Test(priority=2)
public void verifyPageTitle()
{
	test = extent.createTest("Opening the browser and the Home page Title");
	test.log(Status.INFO, "Opening the browser and the Home page Title");
	test.assignCategory("smoke test");
	System.out.println(prop.getProperty("expectedPageTitle"));
	System.out.println(prop.getProperty("title"));
	Assert.assertEquals(driver.getTitle(),prop.getProperty("expectedPageTitle"));

}
/***
 * This method is responsible for the task which will execute after finishing the tests like 
 * saving the test result into automation report , and closing the webdriver instance
 */
@AfterTest
public void quitbrowser()
{
	extent.flush();
	driver.close();
	driver.quit();
}
}
