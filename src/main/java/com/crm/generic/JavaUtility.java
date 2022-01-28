package com.crm.generic;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/*
 * This class contains java specific generic libraries
 * @author Siba
 */

public class JavaUtility {
/**
 * it is used to generate the integer RanDom number with in the boundary of 0 to 1000
 * @return intData
 */
	public int getRanDomnNumber() 
	{
		Random random=new Random();
		int ranDomNumber = random.nextInt(1000);
		return ranDomNumber;
		}
/**
 * it is used to get the current system date and time
 * @return String
 */
   public String getSystemDate()
{
	Date date=new Date();
	String SystemDateAndTime = date.toString();
	return SystemDateAndTime;
}
/**
 * it is used to get the current system date with YYYY-MM-DD format 
 * @return String
 */
   public String finalDateFormat()
   {
	   Date date=new Date();
	   String SystemDateAndTime=date.toString();
	   String[]dte=SystemDateAndTime.split(" ");
	   String YYYY=dte[5];
	   String DD=dte[2];
	   String MM=dte[1];
	   String today=YYYY+"-"+MM+"-"+DD;
	   return today;
	   
   }
/**
 * used to pass Virtual Key to OS
 * @throws Throwable
 */
   
  public void PressVirtualEnterKeys() throws Throwable
  {
	  Robot rc=new Robot();
	  rc.keyPress(KeyEvent.VK_ENTER);
	  rc.keyRelease(KeyEvent.VK_ENTER);
  }
	
	
}
