package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DbHelper;
import controller.StateCityController;
import org.json.JSONObject;
import java.util.ArrayList;
/**
 * Servlet implementation class GetAllCitiesJSON
 */
@WebServlet("/GetAllCitiesJSON")
public class GetAllCitiesJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllCitiesJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		   ResultSet rs=StateCityController.GetAllCities(Integer.parseInt(request.getParameter("sid")));
		   ArrayList <JSONObject> obj=DbHelper.JsonEngine(rs); 
			out.println(obj);
	}

}
