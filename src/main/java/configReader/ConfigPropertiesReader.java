package configReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;


public class ConfigPropertiesReader {
	private Properties prop;
	
	private FileInputStream ip;

	/***
	 * This is a util method responsible for loading the properties(configuration) file
	 * and read the configured values from multiple properties file.
	 * @return property values
	 */
	public Properties initLanguageProp()
	{
		String language=System.getProperty("lang");
		prop = new Properties();
		try {
		switch(language.toLowerCase())
		{
		case "english":
			
			ip = new FileInputStream("./src/main/resources/english.properties");
			break;
		case "french":
			ip = new FileInputStream("./src/main/resources/french.properties");
			break;
		case "russian":
			ip = new FileInputStream("./src/main/resources/russian.properties");
			break;
			
			default:
				break;
			
		}
		prop.load(new InputStreamReader(ip, Charset.forName("UTF-8")));
	
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
