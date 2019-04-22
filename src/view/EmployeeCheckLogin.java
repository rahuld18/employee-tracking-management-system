package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.EmployeeController;
import model.Employees;

/**
 * Servlet implementation class EmployeeCheckLogin
 */
@WebServlet("/EmployeeCheckLogin")
public class EmployeeCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeCheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Employees A=EmployeeController.checkLogin(request.getParameter("eid"),request.getParameter("pwd"));
	 PrintWriter out = response.getWriter();
	  
	 if(A==null)
	{ out.println("<html>");
		 out.println("<h3><i>Invalid Employee Id/Password....<i></h3>");
		 out.println("</html>");
	}
	 else
	 {
		 HttpSession ses=request.getSession();	 
			ses.putValue("SEMPLOYEE", A);
			ses.putValue("LTIME",new java.util.Date());
		 
	response.sendRedirect("EmployeeHome");	 
	 }
	
	}

}
