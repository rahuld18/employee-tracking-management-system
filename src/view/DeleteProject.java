package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ProjectController;

/**
 * Servlet implementation class DeleteProject
 */
@WebServlet("/DeleteProject")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int projectid=Integer.parseInt(request.getParameter("projectid"));
		PrintWriter out=response.getWriter();
		boolean st=ProjectController.deleteProject(projectid);
		out.println("<html>");
		if(st)
		{
			
			out.println("Project deleted  <a href='ProjectList'>Go To Project List</a>");
			
		}
		  else
	       {out.println("Fail to Delete project..<br><a href='ProjectList'>Go To Project List</a>");}
	       out.println("</html>");  
	       out.flush();  
	
		
		
		
	
	
	}


}
