package SagnikBeta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit_Profile_Servlet
 */
@WebServlet("/Edit_Profile_Servlet")
public class Edit_Profile_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_Profile_Servlet() {
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
					"  width: 100%;" + 
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
					"  background-color: gainsboro; " + 
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
			
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String phNO = request.getParameter("phNO");
			String address = request.getParameter("address");
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			
			String sql = "update user_customer set pass = \""+pass+"\", phNO = \""+phNO+"\", address = \""+address+"\" where uname = \""+uname+"\"";
			pst = conn.prepareStatement(sql);
			pst.execute();
			
			out.println("<h2>Changes saved Successfully");
			out.println("<form action = 'Home_User.jsp'>");
			out.println("<div class = 'container'>");
			out.println("<button type = 'submit'>Home</button>");
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
	}

}
