package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





/**
 * Servlet implementation class EmployeeView
 */
@WebServlet("/EmployeeView")
public class EmployeeView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		PrintWriter out=response.getWriter();
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");
		out.println("<script src='asset/statecity.js'></script>");
		  out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
		   
		out.println("<html>");
		
		out.println("<form class='form-control' action='EmployeeSubmit' method='post' enctype='multipart/form-data'>");
		out.println("<table><caption><b><i>Employee Register</i></b></caption>");
		out.println("<tr> <td><b><i> Name:</i></b></td> <td><input type='text' name='efn' placeholder='firstname'></td> <td><input type='text' name='eln' placeholder='lastname'></td></tr>");
		
		
		out.println("<tr><td><b><i>Father's Name:</b></i></td><td><input type='text' name='efan'></td></tr>");
		out.println("<tr><td><b><i>Birth Date:</b></i></td><td><input type='date' name='edob'></td></tr>");
		out.println("<tr><td><b><i>Gender:</b></i></td><td><input type='radio' name='eg' value='Male'>Male <input type='radio' name='eg' value='Female'>Female</td></tr>");
		out.println("<tr><td><b><i>Permanent<br>Address:</b></i></td><td><textarea name='epa' rows='3' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>State:</b></i></td><td><select name='epst' id='epst'> </select></td></tr>");
		out.println("<tr><td><b><i>City:</b></i></td><td><select name='epct' id='epct'></select></td></tr>");
		
		out.println("<tr><td><b><i>Current<br>Address:</b></i></td><td><textarea name='epca' rows='3' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>State:</b></i></td><td><select name='ecst' id='ecst'></select></td></tr>");
		out.println("<tr><td><b><i>City:</b></i></td><td><select name='ecct' id='ecct'></select></td></tr>");
		
		out.println("<tr><td><b><i>Contact Number:</b></i></td><td><input type='text' name='ecn'></td></tr>");
		out.println("<tr><td><b><i>Mobile Number:</b></i></td><td><input type='text' name='embn'></td></tr>");
		out.println("<tr><td><b><i>Email:</b></i></td><td><input type='email' name='eem'></td></tr>");
		
		out.println("<tr><td><b><i>Qualification:</b></i></td><td><textarea name='equa' rows='3' cols='25'></textarea></td></tr>");
		out.println("<tr><td><b><i>Designation:</b></i></td><td><input type='text' name='ed'></td></tr>");
		out.println("<tr><td><b><i>Basic Salary:</b></i></td><td><input type='text' name='ebs'></td></tr>");
		
		out.println("<tr><td><b><i>Password:</b></i></td><td><input type='password' name='epwd'></td></tr>");
		
		out.println("<tr><td><b><i>Photograph:</b></i></td><td><input type='file' name='eph'></td></tr>");
		
		out.println("</table>");
		out.println("<input type='submit' class='btn btn-primary'></input> <button type='reset' class='btn btn-danger'>Reset</button>");
		out.println("</form></html>");
		out.flush();
 	}

}









