package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.TaskController;
import model.Task;

/**
 * Servlet implementation class FinalEditDeleteTask
 */
@WebServlet("/FinalEditDeleteTask")
public class FinalEditDeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalEditDeleteTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html>");
		try{
			Task T=new Task();
			int taskid=Integer.parseInt(request.getParameter("taskid"));
			int eid=Integer.parseInt(request.getParameter("eid"));
			T.setTaskid(taskid);
			String btn=request.getParameter("btn");
			if("Edit".equalsIgnoreCase(btn))
			{
				
				T.setProjectname(request.getParameter("project"));
				T.setConsumetime(request.getParameter("consumetime"));
				T.setDate(request.getParameter("date"));
				T.setCurrenttime(request.getParameter("currenttime"));
				T.setTask(request.getParameter("task"));
				//T.setEmployeeid(Integer.parseInt(request.getParameter("employeeid")));
				TaskController.editTask(T);
			}
			 else if("Delete".equalsIgnoreCase(btn))
	    	 {
				 TaskController.deleteRecord(T.getTaskid());
	    	 }
			
			
			response.sendRedirect("ViewReport?eid="+eid);
			
		}
		catch(Exception e)
		{
			out.println("FinalEditDelete() "+e);
			
			
		} out.print("</html>");
	}

}
