package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchEmployee
 */
@WebServlet("/SearchEmployee")
public class SearchEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession ses=request.getSession();
		try{
			@SuppressWarnings("deprecation")
			String s=(String)ses.getValue("LTIME").toString();
	    	}catch(Exception e)
	    	{
	    		response.sendRedirect("AdminLogin");
	    	}
PrintWriter out=response.getWriter();

		
		out.println("<html>"); out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/><script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
		   
		out.println("<div class='d-flex justify-content-center align-items-center container '><form action='DisplayEmployeeById'>");
		out.println("<table>");
		out.println("<caption><b>Search Employee By Id:</b></caption>");
		out.println("<tr><td><b>Employee Id:</b> </td><td><input type='text' name='eid' class='form-control'></td></tr>");
		out.println("</table>");
		out.println("<input type='submit' class='btn btn-default' value='search'>");
		out.println("</form></div>");
		out.println("</html>");
		out.flush();

		
	}


}
