package pages;



import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil elementUtil; 
	
	/***
	 * This is Constructor of the class HomePage which is responsible to inilialize the driver and 
	 * util class 
	 * @param driver passing the driver reference form the test class file 
	 */
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		elementUtil = new ElementUtil(driver);
		
	}
	
	/***
	 * This Method is responsible for fetching the text from the header of home page
	 * @return the text of the header
	 */
	public String getHeaderElement()
	{	
		String headerValueXpath = "//a[@class='navbar-brand pull-left flip']";
		String value= elementUtil.getElement("xpath",headerValueXpath).getText();
		return value;
		
	}
	
	/***
	 * This method is responsible to validate the linkTech 'Get Involved'
	 * which is present in menu bar of page.
	 * @param linkText pass the name of the linkText
	 * @return the result whether the link exist of not
	 */
	public boolean isDisplayGetInvolved(String linkText )
	{
		 return elementUtil.getElement("linkText",linkText).isDisplayed();	
	}
	
	
	/***
	 * This method is responsible for the clicking the link text 'get Involved'
	 * @param linkText pass the link text which need to be click
	 * @param expectedTitle pass the expected title to satisy the webdriverwait
	 *         to avoid async page load filure
	 * @return returns the title of page after clicking on 'get involved' linktext
	 */
	public String isDisplayGetInvolvedCLick(String linkText, String expectedTitle )
	{
		  elementUtil.getElement("linkText",linkText).click();	
		  String actualTitle=driver.getTitle();
		  while(!actualTitle.equals(expectedTitle))
		  {
			  actualTitle=driver.getTitle();
			  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			  wait.until(ExpectedConditions.titleContains(expectedTitle));
			
		  }
		  return actualTitle;	 
	}


	/***
	 * This method is responsible for the fetching the first Article Title on the Home Page
	 * @return returns the Title present on first home page
	 */
	public String getFirstArticleTitle()
	{
		
		String articleXpath = "//h2[@class='field-content']/a";
		return elementUtil.getElement("xpath",articleXpath).getText();
		
		
	}
}
