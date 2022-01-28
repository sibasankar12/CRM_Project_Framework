package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.comcast.objectrepositorylib.ContactInformation;
import com.crm.comcast.objectrepositorylib.Contacts;
import com.crm.comcast.objectrepositorylib.CreateNewContact;
import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Login;
import com.crm.generic.ExcelUtility;
import com.crm.generic.FileUtility;
import com.crm.generic.WebDriverUtility;

public class CreateContact {

	public static void main(String[] args) throws Throwable {
	
	    WebDriverUtility wlib=new WebDriverUtility();
	    FileUtility flib=new FileUtility();
	    ExcelUtility elib=new ExcelUtility();
	     
	   
	    
	    String USERNAME = flib.getPropertyKeyValue("username");
	    String PASSWORD = flib.getPropertyKeyValue("password");
	    String URL = flib.getPropertyKeyValue("url");
	    String BROWSER = flib.getPropertyKeyValue("browser");
	    
	    String lastname = elib.getDataFromExcel("Sheet1", 7, 2);
	    
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
	   
	   /* step 01 - Login to the App */
	  
	   Login lp=new Login(driver);
	   lp.getLogintoApp(USERNAME, PASSWORD);
	   
	 /* step 02- Navigate to the contact page */
	  
	   Home h=new Home(driver);
	   h.getContactlink().click();
	   
	 /*  step 03 - Navigate to the create new contanct page*/
	   
	   Contacts c=new Contacts(driver);
	   c.getCreateNewContactImg().click();
	   
	  
	 /* step 04 - create contanct */  
	   
	   CreateNewContact crtn= new CreateNewContact(driver);
	     crtn.createContact(lastname);
		
	     wlib.waitUntilPageLoad(driver);
	     
	  /* step 05-  Navigate to the contanctInformation page */ 
	    
	     ContactInformation ctin=new ContactInformation(driver);
	     String actconMsg = ctin.getContactHeaderMsg().getText();

	     if(actconMsg.contains(lastname))
	     {
	    	 System.out.println("contact created successfully==PASS");
	     }
	     else {
	    	 System.out.println("contact not created successfully==FAIL");
	     }
	   /* step 06 - logout to the App */ 
	   
	     h.logout(driver);
	   
	     driver.quit();
	     
	}

}
