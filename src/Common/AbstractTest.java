package Common;

//import org.testng.annotations.Test;
//import org.testng.AssertJUnit;
//import org.testng.annotations.Test;
//import org.testng.Assert;
//import org.testng.AssertJUnit;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeSuite;

//import com.cucumber.listener.Reporter;

public abstract class AbstractTest {
	protected WebDriver seleniumWebDriver;
	protected PLAZASITE plaza;
	
	ConfigReader configReader;
	public void HaiMethos()
	{
		System.out.println("hai methos");
	}
	
  //@Parameters("browser")
  //@BeforeSuite
	//public void ConnectToDeviceOrBrowser() throws MalformedURLException {
	public  void  ConnectToDeviceOrBrowser() throws MalformedURLException {	
	  try
	  {
		  configReader = new ConfigReader();
		  //System.out.println(ConfigReader.getReportConfigPath());
	  System.out.println("The browser doesnot support");
	  if(configReader.defaultBrowser().equals("IE")){
		  System.setProperty("webdriver.InternetExplorer.driver",configReader.getDriverPath());
		  this.seleniumWebDriver=SeleniumWebDriverBuilder.foIEDriverWebDriverWebDriverrDriver().withLink(new URL(configReader.getApplicationUrl())).withPlatform("").withVersion("").build();		  
		  
	  }
	  else if(configReader.defaultBrowser().equals("Chrome")){
	
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--disable-notifications");
		  options.addArguments("disable-infobars");
		  options.addArguments("--start-maximized");
		  //System.setProperty("webdriver.chrome.driver","F:\\supportsoftware\\chromedriver.exe");
		  System.setProperty("webdriver.chrome.driver",configReader.getDriverPath());
		  this.seleniumWebDriver=SeleniumWebDriverBuilder.foChromeDriverWebDriverWebDriverrDriver().withLink(new URL(configReader.getApplicationUrl())).withPlatform("").withVersion("").withOption(options).build();
		  
	  }
	  else if(configReader.defaultBrowser().equals("FireFox")){
		  FirefoxOptions options = new FirefoxOptions();
		  options.addArguments("--disable-notifications");		  
		  System.setProperty("webdriver.gecko.driver",configReader.getDriverPath());
		  this.seleniumWebDriver=SeleniumWebDriverBuilder.foFirefoxDriverWebDriverrDriver().withLink(new URL(configReader.getApplicationUrl())).withPlatform("").withVersion("").build();
		  
	  }
	  else
	  {
		 // System.out.println("The browser doesnot support");
	  }
	  seleniumWebDriver.get(configReader.getApplicationUrl());
	  seleniumWebDriver.manage().window().maximize();
	  plaza=new PLAZASITE(seleniumWebDriver);
	  }
	  catch(Exception e)
	  {
		  System.out.println("defr"+e.getMessage());
	  }
  }
	
	public void ExitingDriver() {
		  seleniumWebDriver.quit();
	  }
	
	/*public static void writeToExtendReport()
	{
		Reporter.loadXMLConfig(new File(ConfigReader.getReportConfigPath()));
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}*/
  
 /* @Test
	public void example_VerifyDownloadWithFileExtension()  {		
	  seleniumWebDriver.findElement(By.linkText("mailmerge.xls")).click();
	    Assert.assertTrue(isFileDownloaded_Ext("", ".xls"), "Failed to download document which has extension .xls");
	}*/
	
	
	
	
  protected boolean isFileDownloaded_Ext(String dirPath, String ext){
		boolean flag=false;
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        flag = false;
	    }
	    
	    for (int i = 1; i < files.length; i++) {
	    	if(files[i].getName().contains(ext)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
  /*
  @Test
	public void example_VerifyDownloadWithFileName()  {	 
	  seleniumWebDriver.findElement(By.linkText("mailmerge.xls")).click();
	  Assert.assertTrue(isFileDownloaded("", "mailmerge.xls"), "Failed to download Expected document");
	}
  
  */
  protected boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
	    File dir = new File(downloadPath);
	    File[] dir_contents = dir.listFiles();
	  	    
	    for (int i = 0; i < dir_contents.length; i++) {
	        if (dir_contents[i].getName().equals(fileName))
	            return flag=true;
	            }

	    return flag;
	}
  
   //Get the latest file from a specific directory
	private File getLatestFilefromDir(String dirPath){
	    File dir = new File(dirPath);
	    File[] files = dir.listFiles();
	    if (files == null || files.length == 0) {
	        return null;
	    }
	
	    File lastModifiedFile = files[0];
	    for (int i = 1; i < files.length; i++) {
	       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
	           lastModifiedFile = files[i];
	       }
	    }
	    return lastModifiedFile;
	}
	
	public static String getDownloadedDocumentName(String downloadDir, String fileExtension)
	{	
		String downloadedFileName = null;
		boolean valid = true;
		boolean found = false;
	
		//default timeout in seconds
		long timeOut = 20; 
		try 
		{					
			Path downloadFolderPath = Paths.get(downloadDir);
			WatchService watchService = FileSystems.getDefault().newWatchService();
			downloadFolderPath.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
			long startTime = System.currentTimeMillis();
			do 
			{
				WatchKey watchKey;
				watchKey = watchService.poll(timeOut,TimeUnit.SECONDS);
				long currentTime = (System.currentTimeMillis()-startTime)/1000;
				if(currentTime>timeOut)
				{
					System.out.println("Download operation timed out.. Expected file was not downloaded");
					return downloadedFileName;
				}
				
				for (WatchEvent<?> event : watchKey.pollEvents())
				{
					
					WatchEvent.Kind<?> kind = event.kind();
					if (kind.equals(StandardWatchEventKinds.ENTRY_CREATE)) 
					{
						String fileName = event.context().toString();
						System.out.println("New File Created:" + fileName);
						if(fileName.endsWith(fileExtension))
						{
							downloadedFileName = fileName;
							System.out.println("Downloaded file found with extension " + fileExtension + ". File name is " + 

fileName);
							Thread.sleep(500);
							found = true;
							break;
						}
					}
				}
				if(found)
				{
					return downloadedFileName;
				}
				else
				{
					currentTime = (System.currentTimeMillis()-startTime)/1000;
					if(currentTime>timeOut)
					{
						System.out.println("Failed to download expected file");
						return downloadedFileName;
					}
					valid = watchKey.reset();
				}
			} while (valid);
		} 
		
		catch (InterruptedException e) 
		{
			System.out.println("Interrupted error - " + e.getMessage());
			e.printStackTrace();
		}
		catch (NullPointerException e) 
		{
			System.out.println("Download operation timed out.. Expected file was not downloaded");
		}
		catch (Exception e)
		{
			System.out.println("Error occured - " + e.getMessage());
			e.printStackTrace();
		}
		return downloadedFileName;
	}

  
 /* @BeforeSuite
  public void beforeSuite() throws IOException {
	  
	  //we need to take the backup of report generated for test
	  
	  configReader = new ConfigReader();
	  ConnectToDeviceOrBrowser();
	  
	 
	  
  }
*/  
 /*@AfterSuite
  public void beforeSuite() {
	  seleniumWebDriver.quit();
  }
*/ 
	 // @DataProvider(name = "Authentication")	  
	  public static Object[][] credentials() {
	 
	        // The number of times data is repeated, test will be executed the same no. of times
	 
	        // Here it will execute two times
	 
	        return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};
	 
	  }
//	  @DataProvider(name = "Authentications")	  
	  public static Object[][] credentialsD() {
	 
	        // The number of times data is repeated, test will be executed the same no. of times
	 
	        // Here it will execute two times
	 
	        return new Object[][] { { "sree2sree02@gmail.com", "123@sreekanth" }};
	 
	  }
	 
	  
	/* @AfterClass
	  public void afterClass() {
		  seleniumWebDriver.quit();
	  }
	 */
  
  //add data source to each of the test files
  
  

}
