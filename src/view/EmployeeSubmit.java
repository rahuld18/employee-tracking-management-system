package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.softech.FileUpload;

import controller.EmployeeController;
import model.Employees;

/**
 * Servlet implementation class EmployeeSubmit
 */
@WebServlet("/EmployeeSubmit")


@MultipartConfig(fileSizeThreshold=1024*1024*2,//2MB
maxFileSize=1024*1024*10,//10MB
maxRequestSize=1024*1024*50)

public class EmployeeSubmit extends HttpServlet {

       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeSubmit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employees E=new Employees();
		PrintWriter out=response.getWriter();
		E.setEmployeename(request.getParameter("efn")+" "+request.getParameter("eln"));
		
		E.setFname(request.getParameter("efan"));
		E.setDob(request.getParameter("edob"));
		E.setGender(request.getParameter("eg"));
		E.setPermanentaddress(request.getParameter("epa"));
		E.setPstate(request.getParameter("epst"));
		E.setPcity(request.getParameter("epct"));
		E.setCurrentaddress(request.getParameter("epca"));
		E.setCstate(request.getParameter("ecst"));
		E.setCcity(request.getParameter("ecct"));
		E.setContactno(request.getParameter("ecn"));
		E.setMobileno(request.getParameter("embn"));
		E.setEmailid(request.getParameter("eem"));
		E.setQualification(request.getParameter("equa"));
		E.setDesignation(request.getParameter("ed"));
        E.setBasicsalary(request.getParameter("ebs"));
        E.setPassword(request.getParameter("epwd"));
//       E.setPhotograph(request.getParameter("eph"));
        
        
        Part P=request.getPart("eph");
        FileUpload F=new FileUpload(P,"C:/Users/rahul/workspace/EmployeTracking/WebContent/eimages");
        E.setPhotograph(F.filename);
        
		boolean st=EmployeeController.addNewRecord(E);
		out.println("<html>");
		if(st)
		{
			
			out.println("Record inserted <a href='EmployeeView'>Add more employee</a>");
			
		}
		  else
	       {out.println("Fail to Submit Record..<br><a href='EmployeeView'>Add More Employee</a>");}
	       out.println("</html>");  
	       out.flush();       
	}

}
