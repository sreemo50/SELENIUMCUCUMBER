package Page;

import java.util.List;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import Common.AbstractPage;

public class EntryPage extends AbstractPage {
	public EntryPage(WebDriver driver)
	{		
		super(driver);			
	}
	
	@FindBy(how=How.CLASS_NAME,using="_1vp5")
	private WebElement uname;
	
	@FindBy(how=How.XPATH,using="//div[@id='userNav']/ul[@class='_bui _3-96']/li")
	private List<WebElement> NameClick;
	
	@FindBy(how=How.XPATH,using="//div[@id='universalNav']/ul[@class='_bui _3-96']/li")
	private List<WebElement> LinkLeft;
	
	@FindBy(how=How.ID,using="//*[@id='userNavigationLabel']")
	private WebElement LogotList;
	
	@FindBy(how=How.XPATH,using="//*[@id='js_9hx']/div/div/ul/li")
	private List<WebElement> LogoutOptionList;
	
	
	
	
	
	
	public void namecheck(String namest)
	{
		System.out.println("come to this namecheck");
		//Assert.assertTrue(uname.getText().equals(namest), "Not fount");
	}
	
	public void NameClick()
	{	
		MouseOverAndClick(NameClick.get(0));		
		NameClick.get(0).click();
	}
	
	public void leftLinkClick()
	{
		MouseOverAndClick(LinkLeft.get(0));
		LinkLeft.get(0).click();
	}

	public void pressLogoutLookingArrow() {
		// TODO Auto-generated method stub
		LogotList.click();
	}
	
	public void LogoutClick()
	{
		MouseOverAndClick(LogoutOptionList.get(7));
		LogoutOptionList.get(7).click();
	}
	
	
	
	
	
	/*public void clickNext()
	{
		next.click();
	}*/

}
