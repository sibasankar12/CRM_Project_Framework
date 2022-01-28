package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Sampletest {
	
	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException 
	{
		FileInputStream fis= new FileInputStream("./External data/commondata.property");
		Properties p = new Properties();
		p.load(fis);
		String Browser = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		Random ran = new Random();
		int ranDomNum = ran.nextInt(10000);
		
		FileInputStream fis_e= new FileInputStream("./External data/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis_e);
		String str = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue()+ranDomNum;
		 
		
		WebDriver driver = null ;
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(str);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String actMsg=driver.findElement(By.className("dvHeaderText")).getText();
		
		
		if(actMsg.contains(str))
		{
			System.out.println("New Organization is successfully created..PASS");
		}
		else
		{
			System.out.println("Organization is not created ..FAIL");
		}
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	}
}
