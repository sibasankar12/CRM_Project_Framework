package com.crm.comcast.orgTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest {
@Test
	public void projectunittest() throws SQLException 
	{
		String projectname = "Thanos";
		Connection conn=null;
		try {
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
     Statement stat = conn.createStatement();
     String query = "select * from project";
     ResultSet rslt = stat.executeQuery(query);
      boolean flag=false;
      while(rslt.next()) {
    	  String actproject = rslt.getString(4);
    	  if(actproject.equals(projectname)) 
    	  {
    		  flag=true;
    	  }
      }
      Assert.assertTrue(flag);
	}
		catch(Exception e)
		{

}
	finally {
		conn.close();
		System.out.println("close db connection");
	}
}
}