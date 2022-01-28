package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.generic.BaseClass;
/**
 * this is used to get the elements in create new organization page
 * @author Siba
 *
 */
public class CreateNewOrganization extends BaseClass
{
 WebDriver driver;
 /**
  * this is used to intialise the elements
  * @param driver
  */
	public CreateNewOrganization(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
 
 @FindBy(name="accountname")
 private WebElement orgNameEdt;
 
 @FindBy(name="industry")
 private WebElement industrieslst;
 
 @FindBy(name="accounttype")
 private WebElement typelist;
 
 @FindBy(xpath="//input[@title='Save [Alt+S]']")
 private WebElement saveBtn;
/**
 * this is used to create organization with industries
 * @param orgName
 * @param industries
 */
	public void createOrg(String orgName,String industries ) 
	{
	orgNameEdt.sendKeys(orgName);
	industrieslst.sendKeys(industries); 
	saveBtn.click();
		
	}
/**
 * this is used to create the organization 
 * @param orgName
 */
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		wlib.waitUntilPageLoad(driver);
		saveBtn.click();
	}
/**
 * this is used to create organization with industries and type of customer
 * @param orgName
 * @param industries
 * @param type
 */
	public void createOrg(String orgName,String industries,String type)
	{
		orgNameEdt.sendKeys(orgName);
		industrieslst.sendKeys(industries); 
		typelist.sendKeys(type);
		saveBtn.click();
	}

	public WebElement getIndustrieslst() {
		return industrieslst;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getTypelist() {
		return typelist;
	}
}
