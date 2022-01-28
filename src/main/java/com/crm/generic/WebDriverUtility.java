package com.crm.generic;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * this class contains webdriver specific generic methods
 * @author Siba
 *
 */
public class WebDriverUtility 
{
/**
 * this method wait for 20sec for page loading
 * @param driver
 */

	public void waitUntilPageLoad(WebDriver driver) 
	{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

/**
 * this method wait for the element to be visible
 * @param driver
 * @param element
 */

public void waitForElementVisibility(WebDriver driver,WebElement element)
{
WebDriverWait wait=new WebDriverWait(driver,20);
wait.until(ExpectedConditions.visibilityOf(element));
}

/**
 * this method wait for the element to be clicked,its custom wait created to avoid elementInterAceptableException 
 * @param element
 * @throws Throwable
 */
public void waitAndClick(WebElement element) throws Throwable
{
	int count=0;
	while(count<20)
	{
	try 
	{
		element.click();
		break;
	}
	catch(Throwable e)
	{
		Thread.sleep(1000);
		count++;
	}
	}
}

/**
 * this method enables user to handel dropdown using value
 * @param element
 * @param value
 */
public void select(WebElement element,String Value)
{
	Select sc=new Select( element);
	
	sc.selectByValue(Value);
}

/**
 * this methods enables user to handel dropdown using index
 * @param element
 * @param index
 */

public void select(WebElement element,int index)
{
	Select sc=new Select(element);
	sc.selectByIndex(index);
}



/**
 * this method will perform mouse over action
 * @param driver
 * @param 
 */
public void mouseOver(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();
}

/**
 * this method performs right click operation
 * @param driver
 * @param element
 */
public void rightClick(WebDriver driver,WebElement element)
{
	Actions a=new Actions(driver);
	a.contextClick(element).perform();
}

/**
 * this method helps to switch from one window to another  
 * @param driver
 * @param partialWinTitle
 */
public void switchToWindow(WebDriver driver,String partialWinTitle)
{
	Set<String> wid = driver.getWindowHandles();
	Iterator<String> it = wid.iterator();
	while(it.hasNext())
	{
		String winid=it.next();
		String title=driver.switchTo().window(winid).getTitle();
		if(title.contains(partialWinTitle))
		{
			break;
		}
	}
}
/**
 * Accept alert
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}

/**
 * Cancel alert
 * @param driver
 */
public void cancelAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}

/**
 * this method used for scrolling action in a webpage
 * @param driver
 * @param element
 */
public void scrollToWebElement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	int y=element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
	
}

/**
 * this method is used to switch to frame by index
 * @param driver
 * @param index
 */

public void switchFrame(WebDriver driver,int index)
{
	driver.switchTo().frame(index);
}

/**
 * this method is used to switch to frame by element
 * @param driver
 * @param element
 */
public void switchFrame(WebDriver driver,WebElement element)
{
	driver.switchTo().frame(element);
}

/**
 * this method is used to switch to frame by name
 * @param driver
 * @param idOrName
 */
public void switchFrame(WebDriver driver,String idOrName)
{
	driver.switchTo().frame(idOrName);
}

/**
 * this method is used to take screenshot of particular webpage
 * @param driver
 * @param screenshotName
 * @throws Throwable
 */
public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./screenshot/"+screenshotName+".PNG");
	Files.copy(src, dest);
	
}

/**
 * pass enter key appertain in to browser
 * @param driver
 */
public void passEnterKey(WebDriver driver)
{
	Actions act=new Actions(driver);
	act.sendKeys(Keys.ENTER).perform();
}


}
