package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import controller.CollapseController;
import controller.DbHelper;


/**
 * Servlet implementation class CollapseButton
 */
@WebServlet("/CollapseButton")
public class CollapseButton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CollapseButton() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		PrintWriter out=response.getWriter();
		ResultSet rs=CollapseController.displayDate(Integer.parseInt(request.getParameter("eid")),request.getParameter("datefrom"),request.getParameter("dateto"));
		System.out.println(request.getParameter("datefrom"));
		ArrayList<JSONObject> obj=DbHelper.JsonEngine(rs);
		out.println(obj);
	
	}


}
