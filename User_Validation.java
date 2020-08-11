package SagnikBeta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class User_Validation
 */
@WebServlet("/User_Validation")
public class User_Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Validation() {
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
		PreparedStatement pst,pst2;
		ResultSet rs,rs2;
		try
		{
			out.println("<head>" + 
					"<style> " + 
					"body {font-family: Arial, Helvetica, sans-serif;}"+
			"form {border: 3px solid #f1f1f1;}"+

			"input[type=text], input[type=password] {"+
			"width: 100%;"+
			"padding: 12px 20px;"+
			"margin: 8px 0;"+
			"display: inline-block;"+
			"border: 1px solid #ccc;"+
			"box-sizing: border-box;"+
			"}"+

			"button {"+
			"background-color: #2F4F4F;"+
			"color: white;"+
			"padding: 14px 20px;"+
			"margin: 8px 0;"+
			"border: none;"+
			"cursor: pointer;"+
			"width: 100%;"+
			"}"+

			"button:hover {"+
			"opacity: 0.8;"+
			"}"+

			".container {"+
			  "padding: 16px;"+
			  "height: 580px;"+
			  "width: 50%;"+
			  "background-color: gainsboro;"+
			  
			"}"+

			".select-style {"+
			    "border: 1px solid #ccc;"+
			    "width: 200px;"+
			    "border-radius: 13px;"+
			    "overflow: hidden;"+
			    "background-color: slategray;"+
			    "color: white;"+
			"}"+

			".select-style select {"+
			    "padding: 10px 8px;"+
			    "width: 130%;"+
			    "border: none;"+
			    "border-radius: 13px;"+
			    "box-shadow: none;"+
			    "background-color: LightGray;"+
			    "background-image: none;"+
			    "-webkit-appearance: none;"+
			    "color: white;"+
			"}"+

			".select-style select:focus {"+
			    "outline: none;"+
			"}"+

			"input[type=submit] {"+
			  "background-color: #2F4F4F;"+
			  "border: none;"+
			  "color: white;"+
			  "padding: 12px 32px;"+
			  "text-decoration: none;"+
			  "margin: 4px 2px;"+
			  "cursor: pointer;"+
			"}"+ 
					"</style> " + 
					"</head>");
			
			
			
			String uname = request.getParameter("uname");
			String emailID = request.getParameter("emailID");
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			String sql = "select uname from user_customer where uname = \""+uname+"\"";
			String sql2 = "select emailID from user_customer where emailID = \""+emailID+"\"";
			pst2 = conn.prepareStatement(sql2);
			rs2 = pst2.executeQuery(sql2);
			
			
			
			pst = conn.prepareStatement(sql);
			//pst.setString(1,uname);
			rs = pst.executeQuery(sql);
			if(rs2.next())
			{
				out.println("User already Registered! Please Login with your login credentials!");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
			}
			else if(rs.next())
			{
				out.println("User Name already taken");
				RequestDispatcher rd = request.getRequestDispatcher("Register_User.jsp");
				rd.include(request, response);
			}
			else
			{
				String uType = "user";
				out.println("<form method = 'post' action = 'User_Entry'>");
				out.println("<div class = 'container'>");
				out.println("<b>Email ID:</b> <input type = 'text' name = 'emailID' value = '"+emailID+"' readonly>");
				out.println("<br><b>User Name:</b> <input type = 'text' name = 'uname' value = '"+uname+"' readonly>");
				out.println("<br><b>First Name:</b> <input type = 'text' placeholder = 'First Name' name = 'fname' required>");
				out.println("<br><b>Last Name:</b> <input type = 'text' placeholder = 'Last Name' name = 'lname' required>");
				out.println("<br><b>Password:</b> <input type = 'password' placeholder = 'Password' name = 'pass' required>");
				out.println("<br><b>Address:</b> <input type = 'text' placeholder = 'Address' name = 'address' required>");
				out.println("<br><b>Phone Number:</b> <input type = 'text' placeholder = 'Phone Number' name = 'phNO' required>");
				out.println("<br><input type = 'hidden' name = 'userType' value = '"+uType+"'");
				out.println("<br><input type='submit' value ='Create Account'></div></form>");
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
