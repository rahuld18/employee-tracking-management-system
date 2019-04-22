package controller;

import java.sql.Connection;
import java.sql.ResultSet;

import model.AdminModel;

public class AdminController
{
	public static AdminModel checkLogin(String aid,String pwd)
	{
		 try{
			  Connection cn=DbHelper.openConnection();
			  String query="select * from admin where adminid='"+aid+"' and password='"+pwd+"'";
			  
			  ResultSet rs=DbHelper.executeQuery(cn, query);
			  if(rs.next())
			  {
				  AdminModel A=new AdminModel();
				  A.setAdminid(rs.getString(1));
				  A.setAdminname(rs.getString(4));
				  A.setPicture(rs.getString(3));
				  return A;
				  
			  }
			  
			}
			catch(Exception e)
				{
				System.out.println("Error:checkLogin"+e);
				}
			return(null);
			  
		
	}
	

}
