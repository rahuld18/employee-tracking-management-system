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

import controller.DbHelper;
import controller.TaskController;

/**
 * Servlet implementation class ConsumeTimeJSON
 */
@WebServlet("/ConsumeTimeJSON")
public class ConsumeTimeJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsumeTimeJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		ResultSet rs=TaskController.consumeTime(request.getParameter("dateto"),Integer.parseInt(request.getParameter("eid")));
				
				ArrayList<JSONObject> obj=DbHelper.JsonEngine(rs);
		out.println(obj);
	
		
	}

	

}
