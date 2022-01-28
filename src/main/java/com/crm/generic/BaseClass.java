package com.crm.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.crm.comcast.objectrepositorylib.Home;
import com.crm.comcast.objectrepositorylib.Login;

public class BaseClass {

	       
	    //object creation for utility//
		
	    public  JavaUtility jlib=new JavaUtility();	
	    public  WebDriverUtility wlib=new WebDriverUtility();
	    public  FileUtility flib=new FileUtility();
	    public  ExcelUtility elib=new ExcelUtility();
	    public static    WebDriver driver=null;
	    public  static  WebDriver sDriver=null;
	   
	    @BeforeSuite(groups={"smokeTest","regressionTest"})
	    public void conFigBS()
	    {
	    	System.out.println("======connect to  the database====");
	    }
	    
	   // @Parameters("browser")
	    @BeforeClass(groups={"smokeTest","regressionTest"})
		public  void  conFigBC() throws Throwable 
		{
	    	System.out.println("======launch  the browser====");
	    	
	    	String URL = flib.getPropertyKeyValue("url");
	      String BROWSER = flib.getPropertyKeyValue("browser");	
	    
	        if(BROWSER.equals("chrome"))
	        {
	        	driver=new ChromeDriver();
	        }
	        else if ((BROWSER.equals("firefox")))
	        		{
	        	driver=new FirefoxDriver();
	        	 }
	        driver.get(URL);
	        sDriver=driver;
		}
	   
	    @BeforeMethod(groups={"smokeTest","regressionTest"})
	    public void conFigBM() throws Throwable
	    {
	    	System.out.println("====login to the App====");
	    	 String USERNAME = flib.getPropertyKeyValue("username");
	    	 String PASSWORD = flib.getPropertyKeyValue("password");
	    	 
	    	 Login lp=new Login(driver);
	    	 lp.getLogintoApp(USERNAME, PASSWORD);
	    		
	    }
	   
	    @AfterMethod(groups={"smokeTest","regressionTest"})
	    public void conFigAM()
	    {
	    	
	    	/* step 08- logout from the App*/
	    	System.out.println("====logout from the App===");
	    	Home hp=new Home(driver);
	    	wlib.waitUntilPageLoad(driver);
	    	hp.logout(driver);
	    	
	     }
	    
	    @AfterClass(groups={"smokeTest","regressionTest"})
	    public void conFigAC()
	    {
	    	/*  step 09- close the driver */
	    	System.out.println("===close the browser===");
	    	driver.quit();

	    }
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void conFigAS()
	{
		System.out.println("======close connection of the database====");
	}

}

	
	
	
	
