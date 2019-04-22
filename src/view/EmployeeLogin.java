package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeLogin
 */
@WebServlet("/EmployeeLogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
		 out.println("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'/> <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js'  crossorigin='anonymous'></script> <script src='https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js'></script> ");
		 out.println("<link rel='stylesheet' type='text/css' href='css/login.css'/> <img src='https://scontent.fidr1-2.fna.fbcdn.net/v/t1.0-9/38126645_2109202232455596_7370699337803759616_n.png?_nc_cat=110&_nc_ht=scontent.fidr1-2.fna&oh=936fad544e54ca97c9c19dcce98a9c07&oe=5CF05ADA' width='100px' />");
		out.println("<div class='container' ><form  action='EmployeeCheckLogin' method='post' >");
		out.println("<table><caption><b>Employee Login</b></caption><tr><td>  </td></tr>");
		out.println("<tr><td><b>Employee Id: </b></td><br><td><input type='text' name='eid'></td></tr>");
		out.println("<tr><td><b>Password: </b></td><br><td><input type='password' name='pwd'></td></tr>");
		
		out.println("</table>");
		out.println("<input class='btn btn-primary' type=submit value='Log In'>");
		out.println("</div></body></html>");
		out.flush();
		
		
		
	}

}
