package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.objectrepositorylib.ContactInformation;
import com.crm.comcast.objectrepositorylib.Contacts;
import com.crm.comcast.objectrepositorylib.CreateNewContact;
import com.crm.comcast.objectrepositorylib.CreateNewOrganization;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Login;
import com.crm.comcast.objectrepositorylib.Organization;
import com.crm.comcast.objectrepositorylib.OrganizationInformation;
import com.crm.generic.ExcelUtility;
import com.crm.generic.FileUtility;
import com.crm.generic.JavaUtility;
import com.crm.generic.WebDriverUtility;

public class CreateOrganizationWithContacts {

	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jlib=new JavaUtility();
	    WebDriverUtility wlib=new WebDriverUtility();
	    FileUtility flib=new FileUtility();
	    ExcelUtility elib=new ExcelUtility();
	   
	    int rndomnum = jlib.getRanDomnNumber();
		
	    
	    
	    String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		
		String orgName = elib.getDataFromExcel("Sheet1", 10, 3)+rndomnum;
		
		String lastname= elib.getDataFromExcel("Sheet1",10 ,2 );
		
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		wlib.waitUntilPageLoad(driver);
		
		driver.get(URL);
		
		/* step 01- Login to the App */
		Login lg=new Login(driver);
		lg.getLogintoApp(USERNAME, PASSWORD);
		
		/*  step 02 - Navigate to the organization page */
		Home h=new Home(driver);
		h.getOrglink().click();
		
		/*  step 03 - Navigate to the cretae new organization page*/
		Organization org=new Organization(driver);
		org.getCreateNewOrgImg().click();
		
		/*  step 04 - create the new organization*/
		CreateNewOrganization cr=new CreateNewOrganization(driver);
		cr.createOrg(orgName);
		
		/* step 05 - Navigate to the organizationInformation page*/
		OrganizationInformation orgin=new OrganizationInformation(driver);
		wlib.waitForElementVisibility(driver, orgin.getOrgHeaderSucMsg());
		
		/* step 06- Navigate to the contanct page*/
		 h.getContactlink().click();
		
		 /* step 07 - Navigate to  create new contanct page*/
		 Contacts c=new Contacts(driver);
		 c.getCreateNewContactImg().click();
		 
		/*  step 08 - create new contanct with lastname and the organization name*/
		 CreateNewContact crtn= new CreateNewContact(driver);
	     crtn.createContact(lastname, orgName);
	     
	     /* step 09 - Navigate to the contanctInformation page */
	     ContactInformation ctin=new ContactInformation(driver);
	     String actconMsg = ctin.getContactHeaderMsg().getText();
        
	     /* step 10- compare between references  */
	     if(actconMsg.contains(lastname))
	     {
	    	 System.out.println("contact created successfully==PASS");
	     }
	     else
	     {
		   
	    	 System.out.println("contact not created successfully==FAIL");
	   }
	     /* step 11- Logout from the App*/
	     h.logout(driver);
	     driver.quit();

}
}
