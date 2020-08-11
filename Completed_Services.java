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
 * Servlet implementation class Completed_Services
 */
@WebServlet("/Completed_Services")
public class Completed_Services extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Completed_Services() {
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
		PreparedStatement pst,pst2;
		ResultSet rs,rs2;
		try {
			out.println("<head>"
					+ "<style>"
					+ "table {"
					+ "font-family: arial, sans-serif;"
					+ "border-collapse: collapse;"
					+ "width: 100%;"
					+ "}"
					+ "td, th {"
					+ "border: 1px solid #dddddd;"
					+ "text-align: left;"
					+ "padding: 8px;"
					+ "}"
					+ "tr:nth-child(even) {"
					+ "background-color: #dddddd;"
					+ "}</style></head>");
			
			
			
			String uname = request.getParameter("uname");
			
			String sql = "select bookingID, userID, bookDate, servDate from booking where providerID = \""+uname+"\" and status = \"com\"";
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			out.println("<table><tr><th>Booking ID</th><th>Customer Name</th><th>Booking Date</th><th>Service Date</th></tr>");
			int flag = 1;
			while(rs.next())
			{
				flag = 0;
				String userID = rs.getString(2);
				
				String sql2 = "select fname,lname from user_customer where uname = \""+userID+"\"";
				pst2 = conn.prepareStatement(sql2);
				rs2 = pst2.executeQuery();
				
				rs2.next();
				
				out.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs2.getString(1)+" "+rs2.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
				
			}
			if(flag==1)
			{
				out.println("<tr><td>You have No Completed Services</td></tr></table>");
			}
			else
				out.println("</table>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}

}
