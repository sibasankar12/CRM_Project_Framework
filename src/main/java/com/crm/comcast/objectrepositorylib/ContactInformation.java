package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is used to get the contact information page
 * @author siba
 *
 */
public class ContactInformation {
  WebDriver driver;
/**
 * this is used to initiate the elements
 * @param driver
 */
  public ContactInformation(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements( driver,this);

	}
  
  @FindBy(xpath="//span[@class='dvHeaderText']")
  private WebElement contactHeaderMsg;
  
  @FindBy(id="dtlview_Last Name")
  private WebElement lastnameInfo;
  
  @FindBy(id="mouseArea_Organization Name")
  private WebElement orginfo;

public WebElement getContactHeaderMsg() {
	return contactHeaderMsg;
}

public WebElement getLastnameInfo() {
	return lastnameInfo;
}

public WebElement getOrginfo() {
	return orginfo;
}
  

}
