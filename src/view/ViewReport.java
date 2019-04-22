package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.EmployeeController;

/**
 * Servlet implementation class ViewReport
 */
@WebServlet("/ViewReport")
public class ViewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		 LocalDateTime now = LocalDateTime.now();
			 
	    
		
		PrintWriter out=response.getWriter();
		int eid=Integer.parseInt(request.getParameter("eid"));
		out.println("<script src='asset/jquery-2.2.1.min.js'></script>");//<script src='asset/viewreport.js'></script>
		out.println("<script src='asset/collapse.js'></script>");
		  out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script>");
		
		out.println("<html>");
		  ResultSet rs=EmployeeController.displayById(eid);
		  try {
			if(rs.next()){
			  
			  try {
				out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name:&nbsp;<b>"+rs.getString(2)+"</b><br>");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  out.println("<button onclick='myFunction()'>Print</button><script>function myFunction() {  window.print();}</script><div class='d-flex justify-content-center align-items-center container '><center><table>");
		  out.println("<input type='hidden' value="+eid+" name='eid' id='eid'");
	
		  out.println("<tr><td>From:<input type=date id=datefrom>&nbsp;&nbsp;</td><td>&nbsp;&nbsp;To:<input type=date id='dateto' value=" + java.time.LocalDate.now()+" required ></td><td><input type='submit' value='Search' id='searchbtn' class='btn btn-primary btn-sm'></td> </tr>");		
			

			out.println("</center></table></div>");
			out.println("<br><div id='result'></div><div id='consum'></div></html>");
			
	
	}

	
}
