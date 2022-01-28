package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.WebDriverUtility;
/**
 * this is used to get the  new contact in create new contact page
 * @author Siba
 *
 */
public class CreateNewContact extends WebDriverUtility {

	WebDriver driver;
/**
 * this is used to intialise the element
 * @param driver
 */
	public CreateNewContact (WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);

	}
	
	
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath="//img [@src='themes/softed/images/select.gif']")
	private WebElement orgLookUpImg;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
 


/**
  * this is used to create the lastname of contact
  * @param lastname
  */
	public void createContact(String lastname )
	{
		lastNameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	/**
	 * this is used to get the lastname with organization
	 * @param lastname
	 * @param orgName
	 * @throws InterruptedException 
	 */
	
	public void createContact(String lastname,String orgName) throws InterruptedException 
	{
		lastNameEdt.sendKeys(lastname);
		orgLookUpImg.click();
		switchToWindow(driver, "Accounts&action");
		Organization or=new Organization(driver);
		or.getSearchEdt().sendKeys(orgName);
		or.getSearchBtn().click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindow(driver,"Contacts&action");
		saveBtn.click();
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	



	


	
	


}
