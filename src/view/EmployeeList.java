package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.EmployeeController;

/**
 * Servlet implementation class EmployeeList
 */
@WebServlet("/EmployeeList")
public class EmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
HttpSession ses=request.getSession();
    	
    	try{
		@SuppressWarnings("deprecation")
		String s=(String)ses.getValue("LTIME").toString();
    	}catch(Exception e)
    	{
    		response.sendRedirect("AdminLogin");
    	}
		
		PrintWriter out=response.getWriter();
		 out.println("<html>");
		 out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
		   
	       try{
	    	   
	    	   ResultSet rs=EmployeeController.displayAll();
	    	   if(rs.next())
	    	   {
	    		   out.println("<table  class='table'>");
	    		   out.println("<caption><b><i>Employee List</i></b></caption>");
	    		   out.println("<tr> <th>Employee</th> <th>Gender</th> <th>BirthDate</th> <th>Permanent<br>Address</th> <th>Current<br>Address</th><th>Contact<br>Information</th><th>Qualification<br>Designation</th><th>Update</th> </tr>");
	    		   
	    		   do{
	    			   out.println("<tr><td>Id:"+rs.getString(1)+"<br>"+"<img width=45 height=45 src=/EmployeTracking/eimages/"+rs.getString(19)+"><br>"+rs.getString(2)+"<br>F'Name:"+rs.getString(3)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(4)+"</br></td><td>"+rs.getString(6)+"<br>"+rs.getString(8)+","+rs.getString(7)+"</td><td>"+rs.getString(9)+"<br>"+rs.getString(11)+","+rs.getString(10)+"</td><td>Ph:"+rs.getString(12)+"<br>Mob:"+rs.getString(13)+"<br>Mail:"+rs.getString(14)+"</td><td>"+rs.getString(15)+"<br>"+rs.getString(16)+"</br>"+rs.getString(17)+"</td><td><a href=DisplayEmployeeById?eid="+rs.getString(1)+">Edit/Delete</a></td></tr>");
	    			   
	    			   
	    		   }while(rs.next());
	    		   
	    		   out.println("</table>");
	    	   }else
	    	   {
	    		   out.println("No Record Found..."); 
	    	   }
	    	   
	       }catch(Exception e)
	       {
	    	   
	    	   out.println("employee list "+e);	  
	       }
	    out.println("</html>");
	    out.flush();
	       
		
	}

}
