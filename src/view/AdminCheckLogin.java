package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.AdminController;
import model.AdminModel;

/**
 * Servlet implementation class AdminCheckLogin
 */
@WebServlet("/AdminCheckLogin")
public class AdminCheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCheckLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminModel A=AdminController.checkLogin(request.getParameter("aid"),request.getParameter("pwd"));
		 PrintWriter out = response.getWriter();
		  
		 if(A==null)
		{ out.println("<html>");
			 out.println("<h3><i>Invalid Admin Id/Password....<i></h3>");
			 out.println("</html>");
		}
		 else
		 {
		HttpSession ses=request.getSession();	 
		ses.putValue("SADMIN", A);
		ses.putValue("LTIME",new java.util.Date());
		response.sendRedirect("AdminHome");	 
		 }
	}

}
