package Common;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigReader {
	private Properties properties;
	private final String propertyFilePath="\\CheckforTest\\ConfigurationProper\\ConfigProper.properties";
	
	public ConfigReader()
	{
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPath()
	{
		
		String driverpath=properties.getProperty("drverpath");
		
		if(driverpath!=null)
			return driverpath;
		else
			throw new RuntimeException("please specify driver path in config");
			
	}
	
	
	
	public String getApplicationUrl()
	{
		
		String appUrl=properties.getProperty("url");
		
		if(appUrl!=null)
			return appUrl;
		else
			throw new RuntimeException("please specify appUrl in config");
			
	}
	public String defaultBrowser()
	{
		 System.out.println("The browser does");
		String browserDef=properties.getProperty("defaultBrowser");
		
		if(browserDef!=null)
			return browserDef;
		else
			throw new RuntimeException("please specify browserDef in config");
			
	}
	
	
	
	
	

}
