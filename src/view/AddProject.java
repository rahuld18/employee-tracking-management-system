package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AdminModel;

/**
 * Servlet implementation class AddProject
 */
@WebServlet("/AddProject")
public class AddProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();	 
	    out.println("<html>");
	    
	    
	    try{
	    	HttpSession ses=request.getSession();
	    	
			@SuppressWarnings("deprecation")
			AdminModel A=(AdminModel)ses.getValue("SADMIN");
	    	
	    	
	    }catch(Exception e){
		    response.sendRedirect("AdminLogin");
		   
	    	
		    }

	    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
	   
	    out.println("<div class='d-flex justify-content-center align-items-center container '><form  action='SubmitProject' class='form-control center_div' method='post' >");
	    
	    
		out.println("<b>Add New Project</b><br><br><input type='text' name='pro' id='pro' class='form-control' Placeholder='Enter project name...'/>");
		
		out.println("<br><button type=submit value='Submit Project' class='btn btn-default'>Submit Task</button>");
		out.println("</form></div>");
		out.println("</html>");
		out.flush();
		
	
	    
	    
	    
	}

	

}
