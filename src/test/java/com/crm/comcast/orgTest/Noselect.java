package com.crm.comcast.orgTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Noselect {

	public static void main(String[] args) throws SQLException 
	{
		Connection conn=null;
		int result=0;
		try {
	Driver driveref=new Driver();	
	DriverManager.registerDriver(driveref);
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
   Statement stat = conn.createStatement();
   String query = "insert into project value('TY_PROJ_3002','deepak','12/01/2022','Bank of Baroda_2','on going',10)";
	 result = stat.executeUpdate(query);
	}
	catch(Exception e) {
		
	}
		finally {
			if(result==1)
			{
				System.out.println("project inserted successfully");
			}
			else {
				System.err.println("project not inserted successfully");
			}
			conn.close();
			System.out.println("close db connect");
		}
	}
	

}
