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
 * Servlet implementation class View_Profile
 */
@WebServlet("/View_Profile")
public class View_Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Profile() {
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
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn;
		PreparedStatement pst;
		ResultSet rs;
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
					"  height: 585px;" + 
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
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			String uname = request.getParameter("uname");
			
			String sql = "select * from user_customer where uname = \""+uname+"\"";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			rs.next();
			String pass = rs.getString(2);
			String fname = rs.getString(3);
			String lname = rs.getString(4);
			String emailID = rs.getString(5);
			String phNO = rs.getString(6);
			String address = rs.getString(7);
			
			out.println("<form action = 'Edit_Profile.jsp'>");
			out.println("<div class = 'container'>");
			out.println("<label for = 'uname'><b>User Name</b></label>");
			out.println("<input type = 'text' name = 'uname' value = '"+uname+"' readonly>");
			out.println("<label for = 'emailID'><b>Email ID</b></label>");
			out.println("<input type = 'text' name = 'emailID' value = '"+emailID+"' readonly>");
			out.println("<label for = 'fname'><b>First Name</b></label>");
			out.println("<input type = 'text' name = 'fname' value = '"+fname+"' readonly>");
			out.println("<label for = 'lname'><b>Last Name</b></label>");
			out.println("<input type = 'text' name = 'lname' value = '"+lname+"' readonly>");
			out.println("<label for = 'pass'><b>Password</b></label>");
			out.println("<input type = 'password' name = 'pass' value = '"+pass+"' readonly>");
			out.println("<label for = 'phNO'><b>Phone Number</b></label>");
			out.println("<input type = 'text' name = 'phNO' value = '"+phNO+"' readonly>");
			out.println("<label for = 'address'><b>Address</b></label>");
			out.println("<input type = 'text' name = 'address' value = '"+address+"' readonly>");
			out.println("<button type = 'submit'>Edit Profile</button></div></form>");
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
		
	}

}
