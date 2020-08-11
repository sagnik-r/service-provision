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
 * Servlet implementation class View_Complaints
 */
@WebServlet("/View_Complaints")
public class View_Complaints extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public View_Complaints() {
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
					"  height: 500px;" + 
					"  width: 50%;" + 
					"  background-color: gainsboro;" + 
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
			
			String sql = "select bookingID, userID, providerID, rating, review from rating where complaint = \"yes\" and resolved = \"no\"";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			int flag = 1;
			while(rs.next())
			{
				flag = 0;
				int bookingID = rs.getInt(1);
				String userID = rs.getString(2);
				String providerID = rs.getString(3);
				int rating = rs.getInt(4);
				String review = rs.getString(5);
				
				out.println("<form method = 'post' action = 'Resolve'>");
				out.println("<div class = 'container'>");
				out.println("<label for = 'bookingID'>Booking ID</label>");
				out.println("<input type = 'text' name = 'bookingID' value = '"+bookingID+"' readonly>");
				out.println("<label for = 'userID'>User ID</label>");
				out.println("<input type = 'text' name = 'userID' value = '"+userID+"' readonly>");
				out.println("<label for = 'providerID'>Provider ID</label>");
				out.println("<input type = 'text' name = 'providerID' value = '"+providerID+"' readonly>");
				out.println("<label for = 'rating'>Rating</label>");
				out.println("<input type = 'text' name = 'rating' value = '"+rating+"&#10025' readonly>");
				out.println("<label for = 'review'>Review</label>");
				out.println("<input type = 'text' name = 'review' value = '"+review+"' readonly>");
				out.println("<label for = 'reply'>Reply</label>");
				out.println("<input type = 'text' name = 'reply' placeholder = 'Write your Reply' maxlength = '150' required>");
				out.println("<button type = 'submit'>Submit your Reply</button></div></form>");
				
			}
			if(flag==1)
			{
				out.println("<h2 style = 'font-family:georgia,garamond,serif;font-size:20px;font-style:bold;'>No pending Complaints!!</h2>");
				out.println("<form action = 'Home_Admin.jsp' >");
				out.println("<input type = 'submit' style = 'font-family:georgia,garamond,serif;font-size:20px;font-style:bold; background-color: darkslategray;' value = 'Home'></form>");
			}
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
