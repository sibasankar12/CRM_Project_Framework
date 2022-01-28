package com.crm.comcast.orgTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Organization;
import com.crm.comcast.objectrepositorylib.OrganizationInformation;
import com.crm.generic.BaseClass;


@Listeners()
public class OrganizationTest extends BaseClass{
	
	
    
    @Test(groups="smokeTest")
    public void createOrganization() throws Throwable 
    {
    	 int randomint =jlib.getRanDomnNumber();
    	 String orgName = elib.getDataFromExcel("Sheet1", 4, 2)+randomint;
    	 
    	
    	   Home hp=new Home(driver);
    	   wlib.waitUntilPageLoad(driver);
    	   hp.getOrglink().click();
    	   
    	   /* step 03- Navigate to the create new organization page*/
    		Organization org=new Organization(driver);
    		org.getCreateNewOrgImg().click();
    		
    		
    		
    		
    		/* step 04- create  new  organization with organization   */
    		CreateNewOrganization ctorg=new CreateNewOrganization(driver);
    		ctorg.createOrg(orgName);
    		
    		wlib.waitUntilPageLoad(driver);
    		
    		/* step 05- Navigate to the organizationInformation page*/
    		OrganizationInformation orgin=new OrganizationInformation(driver);
    		String actorgMsg = orgin.getOrgHeaderSucMsg().getText();
    		System.out.println(actorgMsg);
    		System.out.println(orgName);
    		
    		/* step 06- compare between the actual orgnization and given organization name*/
    		Assert.assertTrue(actorgMsg.contains(orgName));
    		
    	    
    	
    		
    	
    	
    }
    
    @Test(groups="regressionTest")
    public void createOrganizationwithIndustryandtype() throws Throwable
    {
    	
       int rndomnum = jlib.getRanDomnNumber();
    	
    	String orgName = elib.getDataFromExcel("Sheet1", 4, 2)+rndomnum;
    	String industries =elib.getDataFromExcel("Sheet1",4 ,3 );
    	String type = elib.getDataFromExcel("Sheet1",4 ,4 );
    	
    	Home h=new Home(driver);
    	h.getOrglink().click();
    	
    	/* step 03- Navigate to the create new organization page */
       Organization org=new Organization(driver);
       wlib.waitUntilPageLoad(driver);
       org.getCreateNewOrgImg().click();
       
       /* step 04- create organization with orgname and industries and the customer type*/
       CreateNewOrganization ctorg=new CreateNewOrganization(driver);
    	ctorg.createOrg(orgName, industries,type);
    	
    	wlib.waitUntilPageLoad(driver);
    	
    	
    	/* step 05 - Navigate to the organizationInformation page*/
    	OrganizationInformation orgin=new OrganizationInformation(driver);
    	String actorgMsg = orgin.getOrgHeaderSucMsg().getText();
    	System.out.println(actorgMsg);
    	System.out.println(orgName);
    	
    	/* step 06- compare to the actual organization and the given organization */ 
    	wlib.waitUntilPageLoad(driver);
    	Assert.assertTrue(actorgMsg.contains(orgName));;
    	
        
        /* step 07- compare between the actual industries name and the given industries name*/
    	String actIndustryInfo = orgin.getIndustriesInfo().getText();
    	System.out.println(actIndustryInfo);
    	SoftAssert so=new SoftAssert();
         so.assertTrue(actIndustryInfo.contains(industries));
         
    	
    	/* step 08- compare betwwen the actual type and the type given*/
    	String actTypeInfo = orgin.getTypelistInfo().getText();
    	System.out.println(actTypeInfo);
    	Assert.assertTrue(actTypeInfo.contains(type));
    	so.assertAll();
      }
    }
