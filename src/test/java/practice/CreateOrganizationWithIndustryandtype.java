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

public class CreateOrganizationWithIndustryandtype
{

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
	
	String orgName = elib.getDataFromExcel("Sheet1", 4, 2)+rndomnum;
	String industries = elib.getDataFromExcel("Sheet1", 4, 3);
	String type = elib.getDataFromExcel("Sheet1",4 ,4 );
	
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
	
	/* step 01- login to the App */
	Login lg=new Login(driver);
	lg.getLogintoApp(USERNAME, PASSWORD);
	
	/* step 02- Navigate to the organization page */
	Home h=new Home(driver);
	h.getOrglink().click();
	
	/* step 03- Navigate to the create new organization page */
   Organization org=new Organization(driver);
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
	if(actorgMsg.trim().contains(orgName))
	 {
		 System.out.println("organization created successfully==PASS");
	 }
	 else
	 {
		 System.out.println("organization not created successfully==FAIL");
	 }
	
    
    /* step 07- compare between the actual industries name and the given industries name*/
	String actIndustryInfo = orgin.getIndustriesInfo().getText();
	if(actIndustryInfo.equals(industries))
	{
		System.out.println("org created with industries successfully==PASS");
	}
	else {
		System.out.println("org not created with industries  successfully==FAIL");
	}
	
	/* step 08- compare betwwen the actual type and the type given*/
	String actTypeInfo = orgin.getTypelistInfo().getText();
	if(actTypeInfo.equals(type))
	{
		System.out.println("org created with industries with type successfully==PASS");
	}
	else
	{
		System.out.println("org not created with industries with successfully==FAIL");
	}
	
	/* step 09- logout from App */
	h.logout(driver);
	
	/* step 10- close the browser*/
	driver.quit();
	}




}
