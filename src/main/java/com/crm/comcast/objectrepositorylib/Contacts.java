package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is used to get the contact page
 * @author Siba
 *
 */
public class Contacts {

		WebDriver driver;
	/**
	 * this is used to intiate the element
	 * @param driver
	 */
		public Contacts(WebDriver driver) 
		{
		this.driver=driver;
		PageFactory.initElements( driver,this);

	}
		
		
		@FindBy(xpath="//img[@title='Create Contact...']")
		private WebElement createNewContactImg;
		
		
		public WebElement getCreateNewContactImg() {
			return createNewContactImg;
		}

}
