package vtiger.Lead.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateNewLeadByAssignTo {
@Test
	public void Leadbyassign() throws IOException, InterruptedException 
	{
		FileInputStream fis=new FileInputStream("./External data/commondata1.property");
         Properties p=new Properties();
         p.load(fis);
        
          String URL = p.getProperty("url");
          String USERNAME = p.getProperty("un");
          String PASSWORD = p.getProperty("pwd");
          
          WebDriver driver=new ChromeDriver();
          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
          driver.get(URL);
          driver.findElement(By.name("user_name")).sendKeys(USERNAME);
          driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
          driver.findElement(By.id("submitButton")).click();
          driver.findElement(By.linkText("Leads")).click();
  		  driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
  		
  		WebElement wb = driver.findElement(By.name("salutationtype"));
  		Select s=new Select(wb);
  		s.selectByValue("Mr.");
  		driver.findElement(By.name("firstname")).sendKeys("siba sankar");
  		driver.findElement(By.name("lastname")).sendKeys("sahu");
  		driver.findElement(By.name("company")).sendKeys("amazon");
  		driver.findElement(By.id("designation")).sendKeys("system manager");
  		
  		WebElement wb1 = driver.findElement(By.name("leadsource"));
  		Select s1=new Select(wb1);
  		s1.selectByValue("Self Generated");
  		
  		WebElement wb2 = driver.findElement(By.name("industry"));
  		Select s2=new Select(wb2);
  		s2.selectByValue("Banking");
  		
  		driver.findElement(By.name("annualrevenue")).sendKeys("50000");
  		driver.findElement(By.id("noofemployees")).sendKeys("20");
  		driver.findElement(By.id("secondaryemail")).sendKeys("sahusibasankar28@gmail.com");
  		driver.findElement(By.id("phone")).sendKeys("8917412959");
  		driver.findElement(By.id("mobile")).sendKeys("9437694325");
  		driver.findElement(By.id("fax")).sendKeys("8521478922");
  		driver.findElement(By.id("email")).sendKeys("balakrushna9@gmail.com");
  		driver.findElement(By.className("detailedViewTextBox")).sendKeys("www.amazon.com");
  		
  		WebElement wb3 = driver.findElement(By.name("leadstatus"));
  		Select s3=new Select(wb3);
  		s3.selectByValue("Contacted");
  		
  		WebElement wb4 = driver.findElement(By.name("rating"));
        Select s4=new Select(wb4);
        s4.selectByValue("Active");
		  
        driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
       WebElement wb5=driver.findElement(By.name("assigned_user_id"));
       Select s5=new Select(wb5);
       Thread.sleep(3000);
       s5.selectByValue("1");
        Thread.sleep(3000);       
       driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
       WebElement wb6 = driver.findElement(By.name("assigned_group_id"));
       Select s6=new Select(wb6);
       s6.selectByValue("2");
       Thread.sleep(3000);
       s6.selectByValue("3");
       Thread.sleep(3000);
       s6.selectByValue("4");
       
       driver.findElement(By.name("lane")).sendKeys("At- Naayagarh, dist- Nayagarh");
       driver.findElement(By.id("code")).sendKeys("752069");
       driver.findElement(By.id("country")).sendKeys("india");
       driver.findElement(By.id("pobox")).sendKeys("Nayagarh");
       driver.findElement(By.id("city")).sendKeys("nayagarh");
       driver.findElement(By.id("state")).sendKeys("odisha");
       driver.findElement(By.name("description")).sendKeys("it is complete");
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
       JavascriptExecutor j= (JavascriptExecutor)driver;
       j.executeScript("window.scrollTo(0,document.body.scrollHeight)");
       
       Thread.sleep(12000);
       
      
       WebElement wb7 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
       Actions a=new Actions(driver);
       a.moveToElement(wb7).perform();
       driver.findElement(By.linkText("Sign Out")).click();
       
		
		
		
	}

}
