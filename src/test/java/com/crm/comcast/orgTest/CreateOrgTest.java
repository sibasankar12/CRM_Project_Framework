package com.crm.comcast.orgTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class CreateOrgTest {

	public static void main(String[] args) throws SQLException
	{
	Connection conn=null;	
		
	try {	
	Driver 	driverref=new Driver();
	  DriverManager.registerDriver(driverref);
	  conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	System.out.println("connection done");
	Statement state = conn.createStatement();
	String query="select * from projec";
	ResultSet resultst = state.executeQuery(query);
	while(resultst.next())
	{
		System.out.println(resultst.getString(1)+"\t"+resultst.getString(2)+"\t"+resultst.getString(3)+"\t"+resultst.getString(4));
	}
	}
	catch(Exception e) {
		
	}
	finally {
		conn.close();
		System.out.println("close db connection");
	}
	}
}
