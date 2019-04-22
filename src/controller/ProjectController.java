package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Project;
import model.Task;

public class ProjectController {
	
	public static boolean addNewProject(Project P)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into project(projectname)values('"+P.getName()+"')";
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:addNewRecord()"+e);
		}
	return(false);
		
	}
	public static ResultSet displayAll()
	{
		try
		{
	Connection cn=DbHelper.openConnection();	
	String query="Select * from project";
		ResultSet rs=DbHelper.executeQuery(cn,query);
		return (rs);
	}catch(Exception e)
		{

		System.out.println("Error:displayAll()"+e);
		
		}
		return (null);
	}

	public static boolean deleteProject(int projectid)
	{
		try
		{
	Connection cn=DbHelper.openConnection();	
	String query="delete from project where projectid="+projectid;
	boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}catch(Exception e)
		{

		System.out.println("Error:displayAll()"+e);
		
		}
		return (false);
	}

}
