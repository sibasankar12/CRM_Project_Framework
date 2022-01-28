package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Login;
import com.crm.comcast.objectrepositorylib.Organization;
import com.crm.comcast.objectrepositorylib.OrganizationInformation;
import com.crm.generic.ExcelUtility;
import com.crm.generic.FileUtility;
import com.crm.generic.JavaUtility;
import com.crm.generic.WebDriverUtility;

public class CreateOrganizationwithindustry {

	public static void main(String[] args) throws Throwable 
	{
	JavaUtility jlib=new JavaUtility();	
    WebDriverUtility wlib=new WebDriverUtility();
    FileUtility flib=new FileUtility();
    ExcelUtility elib=new ExcelUtility();
     
    int randomint = jlib.getRanDomnNumber();
    
    String USERNAME = flib.getPropertyKeyValue("username");
    String PASSWORD = flib.getPropertyKeyValue("password");
    String URL = flib.getPropertyKeyValue("url");
    String BROWSER = flib.getPropertyKeyValue("browser");
    
    String orgName = elib.getDataFromExcel("Sheet1", 4, 2)+randomint;
    
    WebDriver driver=null;
    
    if(BROWSER.equals("chrome"))
    {
    	driver=new ChromeDriver();
    }
    else if ((BROWSER.equals("firefox")))
    		{
    	driver=new FirefoxDriver();
    	 }
   
   driver.get(URL);
   
   /* step 01- Login to the App */
   Login lp=new Login(driver);
   lp.getLogintoApp(USERNAME, PASSWORD);
	
   /* step 02- Navigate to the organization page*/
   Home hp=new Home(driver);
   hp.getOrglink().click();
   
   /* step 03- Navigate to the create new organization page*/
	Organization org=new Organization(driver);
	org.getCreateNewOrgImg().click();
	
	
	String industries = elib.getDataFromExcel("Sheet1", 4, 3);
	
	/* step 04- create  new  organization with organization name and industries  */
	CreateNewOrganization ctorg=new CreateNewOrganization(driver);
	ctorg.createOrg(orgName, industries);
	
	
	wlib.waitUntilPageLoad(driver);
	
	/* step 05- Navigate to the organizationInformation page*/
	OrganizationInformation orgin=new OrganizationInformation(driver);
	String actorgMsg = orgin.getOrgHeaderSucMsg().getText();
	System.out.println(actorgMsg);
	System.out.println(orgName);
	
	/* step 06- compare between the actual orgnization and given organization name*/
	if(actorgMsg.contains(orgName))
	 {
		 System.out.println("organization created successfully==PASS");
	 }
	 else
	 {
		 System.out.println("organization not created successfully==FAIL");
	 }
	
    
    /* step 07- compare between the actual industry and the given industry  */
	String actIndustryInfo = orgin.getIndustriesInfo().getText();
	if(actIndustryInfo.equals(industries))
	{
		System.out.println("org created with industries successfully==PASS");
	}
	else {
		System.out.println("org not created with industries  successfully==FAIL");
	}
	
	/* step 08- logout from the App*/
	hp.logout(driver);
	
	/*  step 09- close the driver */
	driver.quit();
    
	}

}	
	
