package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains all reusable methods to perform operations on properties file
 * @author nayana
 *
 */
public class PropertiesFileUtility {
	Properties property;
	/**
	 * This method is used to initialize properties file
	 * @param filepath
	 */
	public void propertyFileInitialization(String filepath)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filepath);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
				
		}
		property = new Properties();
		try {
			property.load(fis);
			
		} catch (IOException e) {
		   e.printStackTrace();
		}
	}
	/**
	 * This method returns the data from properties file based on the key passed
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key)
	{
		return property.getProperty(key);
		
		
	}

}
