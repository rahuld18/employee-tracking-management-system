package controller;

import java.sql.Connection;
import java.sql.ResultSet;


import model.Task;

public class TaskController {
	
	public static boolean addNewRecord(Task T)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="insert into task(employeeid,task,date,consumetime,projectname,currenttime)values('"+T.getEmployeeid()+"','"+T.getTask()+"','"+T.getDate()+"','"+T.getConsumetime()+"','"+T.getProjectname()+"','"+T.getCurrenttime()+"')";
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:addNewRecord()"+e);
		}
	return(false);
		
	}
	
	public static ResultSet displayById(int eid)
	{
		
		try{
			  Connection cn=DbHelper.openConnection();
			  
			  String query="select T.currenttime,T.task,T.consumetime,T.projectname,T.date from task T where T.taskid="+eid;
			  
			  ResultSet rs=DbHelper.executeQuery(cn, query);
			  return(rs);
		}catch(Exception e)
		{
			

			System.out.println("Error:displaybyid()"+e);
		}
		return(null);
	}
	public static ResultSet TaskEmployeeWiseBetweenTwoDates(int eid,String datefrom,String dateto){
		try{
			  Connection cn=DbHelper.openConnection();
			  String q="select * from task where date between '"+datefrom+"' and '"+dateto+"' and employeeid='"+eid+"'";
			  ResultSet rs=DbHelper.executeQuery(cn, q);
			  return(rs);
			  
			}
			catch(Exception e){System.out.println("Error:addNewRecord()"+e);}
			return(null);
			
	}
	public static boolean editTask(Task T)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="update task set task='"+T.getTask()+"',date='"+T.getDate()+"',consumetime='"+T.getConsumetime()+"',projectname='"+T.getProjectname()+"',currenttime='"+T.getCurrenttime()+"' where taskid="+T.getTaskid();
	   System.out.println(query);
	  boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:editTask()"+e);
		}
	return(false);
		
	}
	public static boolean deleteRecord(int tid)
	{ try{
	  Connection cn=DbHelper.openConnection();
	  String query="delete from task where taskid="+tid;
	 boolean st=DbHelper.executeUpdate(cn, query);
	 return(st);
	  
	}
	catch(Exception e)
		{
		System.out.println("Error:deleteTask()"+e);
		}
	return(false);
		
	}
	public static ResultSet consumeTime(String dateto, int eid){
		try{
			 Connection cn=DbHelper.openConnection();
			  String q="select consumetime from task where date='"+dateto+"' and employeeid='"+eid+"'";
			  ResultSet rs=DbHelper.executeQuery(cn, q);
			  return(rs);
			 
			
		}catch(Exception e){
			System.out.println("Error:editTask()"+e);
			return (null);
			
		}
	}

}
