/*
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import model.Employees;
import controller.DbHelper;
public class EmployeeController {
	
	
	public static boolean addNewRecord(Employees E)
	{
		try{
			Connection cn=DbHelper.openConnection();
			/*Class.forName("com.mysql.jdbc.Driver").newInstance();
			  Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mm","root","");
			  */
	/*	String query="insert into employees(employeename,fname,dob,gender,permanentaddress,pstate,pcity,currentaddress,ccity,contactno,mobileno,emailid,qualification,designation,basicsalary,password,photograph)values('"+E.getEmployeename()+"','"+E.getFname()+"','"+E.getDob()+"','"+E.getGender()+"','"+E.getPermanentaddress()+"','"+E.getPstate()+"','"+E.getPcity()+"','"+E.getCurrentaddress()+"','"+E.getCstate()+"','"+E.getCcity()+"','"+E.getContactno()+"','"+E.getMobileno()+"','"+E.getEmailid()+"','"+E.getQualification()+"','"+E.getDesignation()+"','"+E.getBasicsalary()+"','"+E.getPassword()+"','"+E.getPhotograph()+"')";
		 boolean st=DbHelper.executeUpdate(cn, query);
/*Statement smt=cn.createStatement();
		
		smt.executeUpdate(query);*/
	/*	return(st);
		 
		}catch(Exception e)
		{
			
			System.out.println("Error:addNewRecord()"+e);
		}
		return(false);
		
	}

}
*/
package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.Employees;

public class EmployeeController {
public static boolean addNewRecord(Employees E)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="insert into employees(employeename,fname,dob,gender,permanentaddress,pstate,pcity,currentaddress,cstate,ccity,contactno,mobileno,emailid,qualification,designation,basicsalary,password,photograph)values('"+E.getEmployeename()+"','"+E.getFname()+"','"+E.getDob()+"','"+E.getGender()+"','"+E.getPermanentaddress()+"','"+E.getPstate()+"','"+E.getPcity()+"','"+E.getCurrentaddress()+"','"+E.getCstate()+"','"+E.getCcity()+"','"+E.getContactno()+"','"+E.getMobileno()+"','"+E.getEmailid()+"','"+E.getQualification()+"','"+E.getDesignation()+"','"+E.getBasicsalary()+"','"+E.getPassword()+"','"+E.getPhotograph()+"')";
 boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:addNewRecord()"+e);
	}
return(false);
	
}



public static boolean editRecord(Employees E)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="update employees set employeename='"+E.getEmployeename()+"',fname='"+E.getFname()+"',dob='"+E.getDob()+"',gender='"+E.getGender()+"',permanentaddress='"+E.getPermanentaddress()+"',pstate='"+E.getPstate()+"',pcity='"+E.getPcity()+"',currentaddress='"+E.getCurrentaddress()+"',cstate='"+E.getCstate()+"',ccity='"+E.getCcity()+"',contactno='"+E.getContactno()+"',mobileno='"+E.getMobileno()+"',emailid='"+E.getEmailid()+"',qualification='"+E.getQualification()+"',designation='"+E.getDesignation()+"',basicsalary='"+E.getBasicsalary()+"' where employeeid="+E.getEmployeeid();
   System.out.println(query);
  boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:editRecord()"+e);
	}
return(false);
	
}

public static boolean deleteRecord(int eid)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="delete from employees where employeeid="+eid;
 boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:deleteRecord()"+e);
	}
return(false);
	
}
public static boolean editPicture(int eid,String pic)
{ try{
  Connection cn=DbHelper.openConnection();
  String query="update employees set photograph='"+pic+"' where employeeid="+eid;
 boolean st=DbHelper.executeUpdate(cn, query);
 return(st);
  
}
catch(Exception e)
	{
	System.out.println("Error:editPicture()"+e);
	}
return(false);
	
}



public static ResultSet displayAll()
{
	try
	{
Connection cn=DbHelper.openConnection();	
String query="Select employeeid,employeename,fname,dob,gender,permanentaddress,pstate,pcity,currentaddress,cstate,ccity,contactno,mobileno,emailid,qualification,designation,basicsalary,password,photograph from employees";
	ResultSet rs=DbHelper.executeQuery(cn,query);
	return (rs);
}catch(Exception e)
	{

	System.out.println("Error:displayAll()"+e);
	
	}
	return (null);
}

public static ResultSet displayById(int eid)
{
	
	try{
		  Connection cn=DbHelper.openConnection();
		  
		  String query="select E.employeeid,E.employeename,E.fname,E.dob,E.gender,E.permanentaddress,(select S.statename from States S where S.stateid=E.pstate),(select C.cityname from cities C where C.cityid=E.pcity),E.currentaddress,(select S.statename from States S where S.stateid=E.cstate),(select C.cityname from cities C where C.cityid=E.ccity),E.contactno,E.mobileno,E.emailid,E.qualification,E.designation,E.basicsalary,E.password,E.photograph,E.pstate,E.pcity,E.cstate,E.ccity from employees E where E.employeeid="+eid;
		  
		  ResultSet rs=DbHelper.executeQuery(cn, query);
		  return(rs);
	}catch(Exception e)
	{
		

		System.out.println("Error:displayAll()"+e);
	}
	return(null);
}


public static Employees checkLogin(String eid,String pwd)
{
	try{
		  Connection cn=DbHelper.openConnection();
		  String query="select * from employees where employeeid='"+eid+"' and password='"+pwd+"'";
		  
		  ResultSet rs=DbHelper.executeQuery(cn, query);
		  if(rs.next())
		  {
			Employees E=new Employees();
			E.setEmployeeid(Integer.parseInt(rs.getString(1)));
			E.setPassword(rs.getString(18));
			
			
			E.setEmployeename(rs.getString(2));           // Not Mandatory 
			
			/*	E.setFname(rs.getString(3));
			E.setDob(rs.getString(4));
			E.setGender(rs.getString(5));
			E.setPermanentaddress(rs.getString(6));
			E.setPstate(rs.getString(7));
			E.setPcity(rs.getString(8));
			E.setCurrentaddress(rs.getString(9));
			E.setCstate(rs.getString(10));
			E.setCcity(rs.getString(11));
			E.setContactno(rs.getString(12));
			E.setMobileno(rs.getString(13));
			E.setEmailid(rs.getString(14));
			E.setQualification(rs.getString(15));
			E.setDesignation(rs.getString(16));
	       E.setBasicsalary(rs.getString(17));*/ 
	        E.setPhotograph(rs.getString(19));
			
			
			return E;
			  
			  
		  }
		  
	}
	catch(Exception e)
		{
		System.out.println("Error:checkLogin"+e);
		}
	return(null);
	  
	
	
}


}
