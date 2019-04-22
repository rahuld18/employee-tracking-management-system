package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ProjectController;
import model.Employees;
import model.Project;

/**
 * Servlet implementation class SubmitProject
 */
@WebServlet("/SubmitProject")
public class SubmitProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitProject() {
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
		
		Project P=new Project();
		PrintWriter out=response.getWriter();
		P.setName(request.getParameter("pro"));
		boolean st=ProjectController.addNewProject(P);
		
		out.println("<html>");
		if(st)
		{
			
			out.println("Project inserted <a href='AddProject'>Add more Projects</a>");
			
		}
		  else
	       {out.println("Fail to Submit Project..<br><a href='AddProject'>Add more Projects</a>");}
	       out.println("</html>");  
	       out.flush();  
	}

}
