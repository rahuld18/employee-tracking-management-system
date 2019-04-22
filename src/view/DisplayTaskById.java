package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.TaskController;


/**
 * Servlet implementation class DisplayTaskById
 */
@WebServlet("/DisplayTaskById")
public class DisplayTaskById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTaskById() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();	 
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		 LocalDateTime now = LocalDateTime.now();
		
out.println("<html><script src='asset/jquery-2.2.1.min.js'></script>");


//Employees A=(Employees)ses.getValue("SEMPLOYEE");
try{System.out.println(request.getParameter("eid"));
	int taskid=Integer.parseInt(request.getParameter("taskid"));
	int eid=Integer.parseInt(request.getParameter("eid"));
	ResultSet rs=TaskController.displayById(taskid);
	if(rs.next())
	 { 
		
		out.println("<script>document.getElementById('task').value="+rs.getString(2)+";</script>");
    	out.println("<script src='asset/project.js'></script>");
	    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
	   
	    out.println("<form class='form-control' action='FinalEditDeleteTask' method='post' >");
	    
	    
		out.println("<table><caption> &nbsp;&nbsp;&nbsp;&nbsp;<b>Add New Task</b></caption><br><br>");
		out.println("<tr><td><b>Select Project:</b> ["+rs.getString(4)+"]  </td><td><select name='project' id='project'> <option>--Select Project--</option> </select></td> <td><b>Date:</b></td><td>["+rs.getString(5)+"]<input type='date' name='date' value=" + java.time.LocalDate.now()+" ></td> </tr>");
		out.println("<br><br><tr><td><b>Describe Your Task:</b> </td><td> <textarea name='task' id='task'  value='"+rs.getString(2)+"' rows='5' cols='40' ></textarea> </td> <td>["+rs.getString(3)+"] <input type='time' name='consumetime' value="+dtf.format(now)+"/> (HH:MM) <input type='hidden' name='currenttime' value="+dtf.format(now)+" /> </td></tr>");
		
		out.println("</table><input type='hidden' name='eid' id='eid' value='"+eid+"'/><input type='hidden' name='taskid' id='taskid' value='"+taskid+"'/>");
		out.println("<button type='submit' value='Edit' name='btn' class='btn btn-primary'>Edit Task</button><button type='submit' value='Delete' name='btn' class='btn btn-danger'>Delete Task</button>");
		out.println("</form>");
		out.println("</html>");
		out.flush();
	 }
	 else
	 {out.print("Not Found....");
		 }
	System.out.println(rs);
  
}catch(Exception e){System.out.println("display task "+e);}


		
		
	}

	
}
