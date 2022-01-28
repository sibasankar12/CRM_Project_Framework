package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is used to get the elements of the login page
 * @author Siba
 *
 */
public class Login {
 WebDriver driver;
 /**
  * this is used to initialise the elements
  * @param driver
  */
	public Login(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);

	}
	
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
/**
 * this is used to login to the app in the page 
 * @param USERNAME
 * @param PASSWORD
 */
	public void getLogintoApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passwordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}

}
