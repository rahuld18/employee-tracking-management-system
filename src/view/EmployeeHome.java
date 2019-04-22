package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.Employees;


@WebServlet("/EmployeeHome")
public class EmployeeHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeHome() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  

		PrintWriter out = response.getWriter();	 
	    out.println("<html>");
	    out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
	    HttpSession ses=request.getSession();
    	
		@SuppressWarnings("deprecation")
		Employees A=(Employees)ses.getValue("SEMPLOYEE");
    	
	
		
	    try{
	    	//String s=(String)ses.getValue("LTIME").toString();
			String nav="<h4 class='navbar-default text-light bg-secondary' >"+A.getEmployeename()+"["+A.getEmployeeid()+"]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ses.getValue("LTIME")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src=/EmployeTracking/eimages/"+A.getPhotograph()+" width=25 height=25>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='EmployeeLogout'>Logout</a></h4>";
			
			out.println(nav);
	    	
	    }catch(Exception e){
		    response.sendRedirect("EmployeeLogin");
		   
	    	
		    }
	    
	    
	    System.out.println(A.getEmployeeid());
	    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
	    out.println("<link rel='stylesheet' type='text/css' href='css/home.css'/> ");
		
	    out.println("<script src='asset/notify.js'></script><input type='hidden' name='eid' value="+A.getEmployeeid()+"  /><table column-gap='40px'>");
	   
	    out.println("<tr><td valign='top' style='background-color:#2f2929'>");
        out.println("<a href='AddTask' target='mw'><button class='btn btn-primary btn-block' width='120px'> Add Task </button></a> <br><br><br><br>");
       // out.println("<a href='DisplayEmployeeTaskById?eid="+A.getEmployeeid()+"' target='mw'> <button class='btn btn-primary'> View Report </button></a><br>");
        out.println("<a href='ViewReport?eid="+A.getEmployeeid()+"' target='mw'><button class='btn btn-primary btn-block'> View Report </button></a> <br><br><br><br>");
               
	    out.print("</td><td></td>");
	    out.println("<td ><iframe name='mw' frameborder=0 width='900' height='900' align='right'></iframe></td>");
	    out.println("</html>");
		
	}

}
