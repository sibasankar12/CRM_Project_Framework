package com.crm.comcast.objectrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * this is used to get the elements of the organization page
 * @author DELL
 *
 */
public class Organization {

	WebDriver driver;
/**
 * this is used to initialize the elements
 * @param driver
 */
	public Organization(WebDriver driver) 
	{
	this.driver=driver;
	PageFactory.initElements( driver,this);

	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgImg;
	
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchBtn;

	public WebElement getCreateNewOrgImg() {
		return createNewOrgImg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
