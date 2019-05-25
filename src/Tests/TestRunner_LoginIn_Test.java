package Tests;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Common.ConfigReader;
import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features" ,glue={"StepDefCls"},plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})//
public class TestRunner_LoginIn_Test  {

	@AfterClass
	 public static void writeExtentReport() {		
		//		writeToExtendReport();
		System.out.println(ConfigReader.getReportConfigPath());
		Reporter.loadXMLConfig(new File(ConfigReader.getReportConfigPath()));
	    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	 }
}
