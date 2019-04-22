package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.TaskController;
import model.Employees;
import model.Task;


@WebServlet("/SubmitTask")
public class SubmitTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	    	HttpSession ses=request.getSession();
	    	
			@SuppressWarnings("deprecation")
			Employees A=(Employees)ses.getValue("SEMPLOYEE");
	    	
			try{
				@SuppressWarnings("unused")
				String s=(String)ses.getValue("LTIME").toString();
				
				
	    }catch(Exception e){
		    response.sendRedirect("EmployeeLogin");
		   
	    	
		    }
		Task T=new Task();
		PrintWriter out=response.getWriter();
		T.setProjectname(request.getParameter("project"));
		T.setConsumetime(request.getParameter("consumetime"));
		T.setDate(request.getParameter("date"));
		T.setCurrenttime(request.getParameter("currenttime"));
		T.setTask(request.getParameter("task"));
		T.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
		
		boolean st=TaskController.addNewRecord(T);
		
		out.println("<html>");
		if(st)
		{
			
			out.println("Task inserted <a href='AddTask'>Add more Task</a>");
			
		}
		  else
	       {out.println("Fail to Submit Task..<br><a href='AddTask'>Add more Task</a>");}
	       out.println("</html>");  
	       out.flush();  
	
		
	}

}
