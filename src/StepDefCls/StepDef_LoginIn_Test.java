package StepDefCls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import Common.AbstractTest;
import Common.PLAZASITE;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



public class StepDef_LoginIn_Test extends AbstractTest {
	WebDriver  driver;
	protected PLAZASITE plaza;
	@Given("^I Open Chrome and start application$")
	public void I_Open_Chrome_and_start_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions	
		try{
		
			//super.HaiMethos();
		//ConnectToDeviceOrBrowser();
		//System.setProperty("webdriver.gecko.driver",configReader.getDriverPath());
		 System.setProperty("webdriver.gecko.driver","F:\\supportsoftware\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.facebook.com");
		driver.manage().window().maximize();
		FirefoxOptions options = new FirefoxOptions();
		  options.addArguments("--disable-notifications");
		 plaza=new PLAZASITE(driver);
		}
		catch(Exception e)
		{
			System.out.println("EEroor"+e.getMessage());
			
		}
	}

	@When("^User enter valid username and password$")
	public void User_enter_valid_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		plaza.HomeScreen().emailentry("sree2sree02@gmail.com");		
		plaza.HomeScreen().passcodeentry("123@sreekanth");
	
	}

	@When("^User click on Login$")
	public void User_click_on_Login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		plaza.HomeScreen().clickOnLogin();
	 
	}

	@Then("^Message displayed username$")
	public void Message_displayed_username() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions		
		plaza.EntryScreen().namecheck("Sreekanth");
	   
	}
	
	@When("^User Logout$")
	public void User_Logout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		plaza.EntryScreen().pressLogoutLookingArrow();
		plaza.EntryScreen().LogoutClick();
		
	}

	@Then("^User should see Login$")
	public void User_should_see_Login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		plaza.HomeScreen().LoginExists();
	}

//	@When("^I enter Invalid username and password$")
//	public void i_enter_Invalid_username_and_password() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    
//	}
//
//	@Then("^Message displayed failed on the page$")
//	public void message_displayed_failed_on_the_page() throws Throwable {
//	    // Write code here that turns the phrase above into concrete actions
//	    
//	}

}
