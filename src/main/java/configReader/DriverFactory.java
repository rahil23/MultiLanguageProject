package configReader;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentReports;	
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class DriverFactory {

	public WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	
/***
 * This is the base method which initiate the webdriver object to open the 
 * portal in multiple browsers. this method will also take care of waiting of page and adjusting the 
 * dimension of page mentioned in configuration files
 * @param browserName pass browser name on which user want to run the tests
 * @param prop passing the refrence of properties file to read the multiple configuration
 * @return object of driver which gets use in multiple classes
 */
	public WebDriver initDriver(String browserName,Properties prop)
	{
		
		switch(browserName.toLowerCase())
		{
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
			default:
				System.out.println("pass the correct browser name"+browserName);
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		
		//System.out.println("dimension is: "+ driver.manage().window().getSize());
		driver.manage().window().setSize(new Dimension(Integer.parseInt(prop.getProperty("height")),Integer.parseInt(prop.getProperty("width"))));	
		return driver;
	}
	
	/***
	 * This method is responsible to initiate the extent report which publishes the 
	 * automation report in graphical representation like pie chart format
	 * @param prop passing the refrence of properties file to read the multiple configuration
	 */
	public void initializeReport(Properties prop)
	{
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/AutomationTestReport.html");
		extent = new ExtentReports();
		
		extent.setSystemInfo("BrowserResolution", prop.getProperty("resolution"));
		extent.setSystemInfo("language", prop.getProperty("lang"));
		sparkReporter.config().setDocumentTitle("VISA Test Automation task");
		sparkReporter.config().setReportName("Test Report to validate multi language website");
		sparkReporter.config().setTheme(Theme.DARK);
		extent.attachReporter(sparkReporter);	 	
	}
	/*public static String captureScreenShot(WebDriver driver)
	{
		
		String fileSeperator = System.getProperty("file.seperator");
		String extentReportPath = "."+fileSeperator+"Reports";
		String screenshotPath = fileSeperator+extentReportPath+"screenshots";
		  //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination
                
                String screenShotname = "screenShot"+Math.random()+".png";
                String screenShotPath = screenshotPath+fileSeperator+screenShotname;

                

                //Copy file at destination

                try {
					FileUtils.copyFile(SrcFile, new File(screenshotPath));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return "."+fileSeperator+"screenshots"+fileSeperator+screenShotname;
		
	}*/
}
