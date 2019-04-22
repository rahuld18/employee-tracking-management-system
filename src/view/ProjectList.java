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

import controller.ProjectController;

/**
 * Servlet implementation class ProjectList
 */
@WebServlet("/ProjectList")
public class ProjectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
	    	   
	    	   ResultSet rs=ProjectController.displayAll();
	    	   System.out.print(rs);
	    	   if(rs.next())
	    	   {
	    		   out.println("<div class='d-flex justify-content-center align-items-center container '><table border=1 class='table'>");
	    		   out.println("<caption><b><i>Project List</i></b></caption>");
	    		   out.println("<tr> <th>ID</th> <th>Project Name</th><th>Update</th> </tr>");
	    		   do{
	    			   out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td> <td> <a href=DeleteProject?projectid="+rs.getString(1)+">Delete</a> </td></tr>"); 
	    			   
	    		   }while(rs.next());
	    		   
	    		   out.println("</table></div>");
	    	   }else
	    	   {
	    		   out.println("No Record Found..."); 
	    	   }
	    	   
	       }catch(Exception e)
	       {
	    	   
	    	   out.println("project list "+e);	  
	       }
	    out.println("</html>");
	    out.flush();
	       
	}



}
