package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {
	
	
	private WebDriver driver;
	
	/***
	 * This is constructor of ElementUtility class which is initializing the driver
	 * @param driver getting the driver value from called refreence class methods
	 */
	public ElementUtil(WebDriver driver) {
		this.driver=driver;
	}

	 /***
	 * This method is responsible for the fetching the webElement using only passing the locator type
	 * @param locator pass the locator type
	 * @return
	 */
	/*public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	} */
	
	/***
	 * This method is responsible for the fetching the webelement using locator type and value 
	 * @param locatorType locator type can be id,name,class,linktext
	 * @param locatorValue this can be xpath value,is value and other locator value too
	 * @return webelement reference 
	 */
	public WebElement getElement(String locatorType,String locatorValue)
	{
		return driver.findElement(getBy(locatorType,locatorValue));
	}

	/***
	 * This is common method responsible to construct the WebElement statement on basis of 
	 * different locator stratergy
	 * @param locatorType  locator type can be id,name,class,linktext
	 * @param locatorValue this can be xpath value,is value and other locator value too
	 * @return by reference for the webelement
	 */
	public By getBy(String locatorType,String locatorValue)
	{
		By locator = null;
		switch(locatorType.toLowerCase())
		{
		case "id":
			locator=By.id(locatorValue);
			break;
		case "xpath":
			locator=By.xpath(locatorValue);
			break;
		case "classname":
			locator=By.className(locatorValue);
			break;
		case "cssselector":
			locator=By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator=By.linkText(locatorValue);
			break; 
			default : 
				System.out.println("this is not valid locator"+locatorValue);
		}
		return locator;
	}
}
