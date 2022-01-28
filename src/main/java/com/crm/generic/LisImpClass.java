package com.crm.generic;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.ITestListener;


public class LisImpClass implements ITestListener {


	
	public void onTestFailure(ITestResult result) 
	{
		String testName=result.getMethod().getMethodName();
		System.out.println(testName+"======Execute======");
		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sDriver);
        File src= edriver.getScreenshotAs(OutputType.FILE);
         File dest =new File("./Screenshot/"+testName+".png");
        		 
        try 
        {
        FileUtils.copyFile(src, dest);
         }
       catch(IOException e)
        {
    	   e.printStackTrace();
        	
        }
	}

}
