package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.TaskController;

/**
 * Servlet implementation class DisplayEmployeeTaskById
 */
@WebServlet("/DisplayEmployeeTaskById")
public class DisplayEmployeeTaskById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployeeTaskById() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html>");
	       try{
	    ResultSet rs=TaskController.displayById(Integer.parseInt(request.getParameter("eid")));
	    	 if(rs.next())
	    	 {
	    		 
	    		 out.println("<table border=1>");
	    		   out.println("<caption><b><i>Task List</i></b></caption>");
	    		   out.println("<tr> <th>Time</th> <th>Task</th> <th>Consume Time</th> <th>Project Name</th></tr>");
	    		   
	    		   do{
	    			   out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
	    			   
	    			   
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
