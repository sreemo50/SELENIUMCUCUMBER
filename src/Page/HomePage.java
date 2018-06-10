package Page;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import Common.AbstractPage;
import Common.PLAZASITE;



public class HomePage extends AbstractPage {
	
	//WebDriver driver1;
	public HomePage(WebDriver driver)
	{		
		super(driver);	
		//this.driver1=driver;	
		
	}
	

	@FindBy(how=How.XPATH,using="//*[@id='email']")
	private WebElement emails;

	@FindBy(how=How.XPATH,using="//*[@id='u_0_3']")
	private WebElement LoginBtn;

	@FindBy(how=How.ID,using="pass")
	private WebElement passcodes;	

	
//	
//	public void Login(String email,String passcode)
//	{
//		try{
//				emails.sendKeys(email);
//				passcodes.sendKeys(passcode);
//				LoginBtn.click();
//				emails.clear();
//				passcodes.clear();
//				//emails.sendKeys(email);
//			}
//		catch(Exception e){
//				e.printStackTrace();
//		}
//	}



	public void emailentry(String email) {
		// TODO Auto-generated method stub
		emails.sendKeys(email);
		
	}



	public void passcodeentry(String passcode) {
		// TODO Auto-generated method stub
		passcodes.sendKeys(passcode);
		
	}



	public void clickOnLogin() {
		// TODO Auto-generated method stub
		LoginBtn.click();
		
	}



	public void LoginExists() {
		// TODO Auto-generated method stub
	//	Assert.assertTrue(LoginBtn.getText().equals("Login"), "Successfully LoggrdOut");
	}


	
	


}
