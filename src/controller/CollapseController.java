package controller;

import java.sql.Connection;
import java.sql.ResultSet;

public class CollapseController {
	
	
	public static ResultSet displayDate(int eid,String datefrom,String dateto)
	{
		try
		{
	Connection cn=DbHelper.openConnection();	
	String query="Select DISTINCT  date from task where date between '"+datefrom+"' and '"+dateto+"' and employeeid='"+eid+"' ORDER BY date";
		ResultSet rs=DbHelper.executeQuery(cn,query);
		return (rs);
	}catch(Exception e)
		{

		System.out.println("Error:displayAll()"+e);
		
		}
		return (null);
	}
	
	public static ResultSet displayByDate(String date,int eid)
	{
		
		try{
			  Connection cn=DbHelper.openConnection();
			  
			  String query="select * from task  where date='"+date+"' and employeeid="+eid;
			  
			  ResultSet rs=DbHelper.executeQuery(cn, query);
			  return(rs);
		}catch(Exception e)
		{
			

			System.out.println("Error:displaybyid()"+e);
		}
		return(null);
	}

}
