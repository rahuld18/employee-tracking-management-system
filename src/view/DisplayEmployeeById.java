package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.EmployeeController;

/**
 * Servlet implementation class DisplayEmployeeById
 */
@WebServlet("/DisplayEmployeeById")
public class DisplayEmployeeById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployeeById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		 PrintWriter out=response.getWriter();
		 out.println("<html>");
		 out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
		   
		 out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
			out.println("<script src='asset/statecity.js'></script>"); 
		 
	       try{
	    ResultSet rs=EmployeeController.displayById(Integer.parseInt(request.getParameter("eid")));
	    	 if(rs.next())
	    	 {
	    		 out.println("<form action='FinalEditDeleteEmployee' method='post' enctype='multipart/form-data'>");
	    		 out.println("<table class='table'> <tr><td>");
	    			out.println("<table><caption><b><i>Employee Register</i></b></caption>");
	    			out.println("<tr><td><b><i>Employee Id:</b></i></td><td><input type='text' name='eid' value='"+rs.getString(1)+"'></td></tr>");
	    		    //String n[]=rs.getString(2).split(" ");
	    		    		
	    			//out.println("<tr><td><b><i>Name:</b></i></td><td><input type='text' name='efn' placeholder='First Name' value='"+n[0]+"'> <input type='text' name='eln' placeholder='Last Name' value='"+n[1]+"'></td></tr>");
	    			out.println("<tr><td><b><i>Father's Name:</b></i></td><td><input type='text' name='efan' value='"+rs.getString(3)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Birth Date:</b></i></td><td><input type='date' name='edob' value='"+rs.getString(4)+"'></td></tr>");
                    if(rs.getString(5).equals("Male")) 
                    out.println("<tr><td><b><i>Gender:</b></i></td><td><input type='radio' name='eg' value='Male' checked>Male <input type='radio' name='eg' value='Female'>Female</td></tr>");
                    else
                 	  out.println("<tr><td><b><i>Gender:</b></i></td><td><input type='radio' name='eg' value='Male' >Male <input type='radio' name='eg' value='Female' checked>Female</td></tr>");
	
                    out.println("<tr><td><b><i>Permanent<br>Address:</b></i></td><td><textarea name='epa' rows='3' cols='25'>"+rs.getString(6)+"</textarea></td></tr>");
	    			out.println("<tr><td><b><i>State:["+rs.getString(7)+"]<input type=hidden  name='oldpstate' id='oldpstate' value='"+rs.getString(20)+"'></b></i></td><td><select name='epst' id='epst'></select></td></tr>");
	     			out.println("<tr><td><b><i>City:["+rs.getString(8)+"]<input type=hidden  name='oldpcity' id='oldpcity' value='"+rs.getString(21)+"'></b></i></td><td><select name='epct' id='epct'><option>-City-</option></select></td></tr>");
	    			System.out.println(rs.getString(7));
	    			out.println("<tr><td><b><i>Current<br>Address:</b></i></td><td><textarea name='epca' rows='3' cols='25'>"+rs.getString(9)+"</textarea></td></tr>");
	    			out.println("<tr><td><b><i>State:["+rs.getString(10)+"]<input type=hidden  name='oldcstate' id='oldcstate' value='"+rs.getString(22)+"'></b></i></td><td><select id='ecst' name='ecst'></select></td></tr>");
	    			out.println("<tr><td><b><i>City:["+rs.getString(11)+"]<input type=hidden  name='oldccity' id='oldccity' value='"+rs.getString(23)+"'></b></i></td><td><select id='ecct' name='ecct'><option>-City-</option></select></td></tr>");
	    			
	    			out.println("<tr><td><b><i>Contact Number:</b></i></td><td><input type='text' name='ecn' value='"+rs.getString(12)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Mobile Number:</b></i></td><td><input type='text' name='embn' value='"+rs.getString(13)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Email:</b></i></td><td><input type='email' name='eem' value='"+rs.getString(14)+"'></td></tr>");
	    			
	    			out.println("<tr><td><b><i>Qualification:</b></i></td><td><textarea name='equa' rows='3' cols='25'>"+rs.getString(15)+"</textarea></td></tr>");
	    			out.println("<tr><td><b><i>Designation:</b></i></td><td><input type='text' name='ed' value='"+rs.getString(16)+"'></td></tr>");
	    			out.println("<tr><td><b><i>Basic Salary:</b></i></td><td><input type='text' name='ebs' value='"+rs.getString(17)+"'></td></tr>");
	    		 	out.println("</table>");
	    			out.println("<input type='submit' value='Edit' name='btn'> <input type='Submit' value='Delete' name='btn'>");
	    			
	    			out.println("</td> <td>");
	    			out.println("<img src=/EmployeTracking/eimages/"+rs.getString(19)+"  width=200 height=200 ><br><br>");
	    			out.println("<input type='file' name='eph'><br><br>");
	    			out.println("<input type='submit' value='Edit Picture' name='btn'></td></tr></table>");
	    			
	    			
	    			
	    			out.println("</form>");	 
	    		  
	    	 }
	    	 else
	    	 {out.print("Not Found....");
	    		 }
	       
	}catch(Exception e){System.out.println("display employee "+e);}
	
		
		
	}
	}

