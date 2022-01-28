package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is used to get the elements in homepage
 * @author DELL
 *
 */
public class Home {
	WebDriver driver;
/**
 * this is used to intialise the elements
 * @param driver
 */
	public Home(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver,this);	

	}
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
   
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement admintmg;
	
    @FindBy(linkText="Sign Out")
    private WebElement signoutlink;

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getAdmintmg() {
		return admintmg;
	}

	public WebElement getSignoutlink() {
		return signoutlink;
	}
/**
 * this is used to logout from the page
 * @param driver
 */
  public void logout(WebDriver driver) 
  {
	  Actions a=new Actions(driver);
	  a.moveToElement(admintmg).perform();
	  signoutlink.click();
	  
  }
}
