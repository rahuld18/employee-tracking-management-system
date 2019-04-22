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
 * Servlet implementation class AdminHome
 */
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();	 
	    out.println("<html><body>");
	    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
		   
	    
	    
	    try{
	    	HttpSession ses=request.getSession();
	    	
			@SuppressWarnings("deprecation")
			AdminModel A=(AdminModel)ses.getValue("SADMIN");
	    	
			@SuppressWarnings("deprecation")
			String nav="<h4>"+A.getAdminname()+"["+A.getAdminid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=/EmployeTracking/eimages/"+A.getPicture()+" width=25 height=25>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='AdminLogout'>Logout</a></h4><hr color='red'>";
	    	out.println(nav);
	    	
	    }catch(Exception e){
		    response.sendRedirect("AdminLogin");
		   
	    	
		    }
	    
	    
	    out.println("<table>");
	   
	    out.println("<tr><td valign='top' style='background-color:#2f2929'>");
       
	    out.println("<a href='AddProject' target='mw'><button class='btn btn-primary btn-block'>Add Project</button></a><br><br><br>");
	    out.println("<a href='TrackEmployee' target='mw'><button class='btn btn-primary btn-block'>Track Employee</button></a><br><br><br>");
	    out.println("<a href='ProjectList' target='mw'><button class='btn btn-primary btn-block'>List Of Projects</button></a><br><br><br>");
	          
	    out.println("<a href='EmployeeList' target='mw'><button class='btn btn-primary btn-block'>List Of Employee</button></a><br><br><br>");
        out.println("<a href='SearchEmployee' target='mw'><button class='btn btn-primary btn-block'>Search Employee</button></a><br><br><br>");

	    out.print("</td>");
	    out.println("<td valign='top'><iframe name='mw' frameborder=0 width='800' height='800'></iframe></td>");
	    out.println("</body></html>");
	}

}
