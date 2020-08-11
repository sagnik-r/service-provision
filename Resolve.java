package SagnikBeta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Resolve
 */
@WebServlet("/Resolve")
public class Resolve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Resolve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.setHeader("Cache-Control","no-cache");
	    response.setHeader("Cache-Control","no-store");
	    response.setHeader("Pragma","no-cache");
	    response.setDateHeader ("Expires", 0);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn;
		PreparedStatement pst;
		try
		{
			out.println("<head>" + 
					"<style>" + 
					"" + 
					"body {font-family: Arial, Helvetica, sans-serif;}" + 
					"form {border: 3px solid #f1f1f1;}" + 
					"" + 
					"input[type=text], input[type=password] {" + 
					"  width: 100%;" + 
					"  padding: 12px 20px;" + 
					"  margin: 8px 0;" + 
					"  display: inline-block;" + 
					"  border: 1px solid #ccc;" + 
					"  box-sizing: border-box;" + 
					"}" + 
					"" + 
					"button {" + 
					"  background-color: darkslategray;" + 
					"  color: white;" + 
					"  padding: 14px 20px;" + 
					"  margin: 8px 0;" + 
					"  border: none;" + 
					"  cursor: pointer;" + 
					"  width: 50%;" + 
					"}" + 
					"" + 
					"button:hover {" + 
					"  opacity: 0.8;" + 
					"}" + 
					"" + 
					".container {" + 
					"  padding: 16px;" + 
					"  height: 280px;" + 
					"  width: 50%;" + 
					"  " + 
					"}" + 
					"" + 
					".select-style {" + 
					"    border: 1px solid #ccc;" + 
					"    width: 200px;" + 
					"    border-radius: 13px;" + 
					"    overflow: hidden;" + 
					"    background-color: LightGray;" + 
					"}" + 
					"" + 
					".select-style select {" + 
					"    padding: 10px 8px;" + 
					"    width: 130%;" + 
					"    border: none;" + 
					"    border-radius: 13px;" + 
					"    box-shadow: none;" + 
					"    background-color: LightGray;" + 
					"    background-image: none;" + 
					"    -webkit-appearance: none;" + 
					"}" + 
					"" + 
					".select-style select:focus {" + 
					"    outline: none;" + 
					"}" + 
					"" + 
					"</style>" + 
					"</head>");
			
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			
			int bookingID = Integer.parseInt(request.getParameter("bookingID"));
			String reply = request.getParameter("reply");
			
			String sql = "update rating set reply = \""+reply+"\" , resolved = \"yes\" where bookingID = "+bookingID;
			pst = conn.prepareStatement(sql);
			pst.execute();
			
			out.println("<h2 style = 'font-family:georgia,garamond,serif;font-size:20px;font-style:bold;'>Your Reply was recorded");
			out.println("<form action = 'Home_Admin.jsp'>");
			out.println("<input type = 'submit' style = 'font-family:georgia,garamond,serif;font-size:20px;font-style:bold;background-color: darkslategray;' value = 'Home'></form></h2>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
