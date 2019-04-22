package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Employees;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * Servlet implementation class AddTask
 */
@WebServlet("/AddTask")
public class AddTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		 LocalDateTime now = LocalDateTime.now();
		PrintWriter out = response.getWriter();	 
	    out.println("<html>");
	    HttpSession ses=request.getSession();
    	@SuppressWarnings("deprecation")
		Employees A=(Employees)ses.getValue("SEMPLOYEE");
       
	    /*try{
	    	@SuppressWarnings("unused")
			String s=(String)ses.getValue("LTIME").toString();
			 	
	    	
	    }catch(Exception e){
		    response.sendRedirect("EmployeeLogin");
		   
	    	
		    }*/
    	out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		
    	out.println("<script src='asset/project.js'></script>");
	    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
	   
	    out.println("<form action='SubmitTask' method='post' >");
	    
	    
		out.println("<div class='d-flex justify-content-center align-items-center container '><table class='table table-hover text-centered'><caption><b><font size='44px'>Add New Task</font></b></caption><br>");
		out.println("<tr><td><b>Select Project:  </b></td><td><select name='project' id='project' required> <option>--Select Project--</option> <option>Zemi</option> <option>SlickArray</option> <option>ALA</option> <option>Car Rental</option> <option>Wasicom</option></select></td> <td><b>Date:</b></td><td><input type='date' name='date' value=" + java.time.LocalDate.now()+" required /></td> <td> <input type='hidden' name='employeeid' value='" + A.getEmployeeid() + "'/> </td></tr>");
		out.println("<br><tr><td><b>Describe Your Task:</b></td><td><textarea name='task' placeholder='Enter task here....'  rows='5' cols='40' required ></textarea></td><td><b>Time: </b></td><td><input type='time' name='consumetime'   required /> (HH:MM) <input type='hidden' name='currenttime' value="+dtf.format(now)+" /> </td></tr>");
		//value="+dtf.format(now)+" for date
		out.println("</table>");
		out.println("<button type=submit value='Submit Task' class='btn btn-primary'>Submit Task</button>");
		out.println("</form></div>");
		out.println("</html>");
		out.flush();
		
	
	
	}

	
}
