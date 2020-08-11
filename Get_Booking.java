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
 * Servlet implementation class Get_Booking
 */
@WebServlet("/Get_Booking")
public class Get_Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Get_Booking() {
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
		PreparedStatement pst,pst2,pst3;
		ResultSet rs,rs2,rs3;
		try
		{
			String uname = request.getParameter("uname");
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			String sql = "select bookingID, userID, providerID, bookDate, servDate, status from booking where userID =\""+uname+"\"";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			int flag = 1;
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
			+ "}");
			out.println("input[type=submit] {" + 
					"    padding:5px 15px;" + 
					"    background:#ccc;" + 
					"    border:0 none;" + 
					"    cursor:pointer;" + 
					"    -webkit-border-radius: 5px;" + 
					"    border-radius: 5px;" + 
					"}</style></head>");
			
			out.println("<table>"+"<tr><th>Booking ID</th><th>Service Provider<th>Service Type</th></th><th>Booking Date</th><th>Service Date</th><th>Status</th><th>Action</th></tr>");
			while(rs.next())
			{
				flag=0;
				int bookingID = rs.getInt(1);
				String userID = rs.getString(2);
				String providerID = rs.getString(3);
				String bookDate = rs.getString(4);
				String servDate = rs.getString(5);
				String status = rs.getString(6);
				String statDef;
				if(status.equals("upc"))
					statDef = "Upcoming";
				else if(status.equals("can"))
					statDef = "Cancelled";
				else
					statDef = "Completed";
				
				String sql2 = "select fname,lname from user_customer where uname = \""+providerID+"\"";
				pst2 = conn.prepareStatement(sql2);
				rs2 = pst2.executeQuery();
				rs2.next();
				
				String sql3 = "select servType from providers where uname = \""+providerID+"\"";
				pst3 = conn.prepareStatement(sql3);
				rs3 = pst3.executeQuery();
				rs3.next();
				String servType = rs3.getString(1);
				String servDisp = "";
				switch(servType)
				{
					case "acrep":   servDisp = "AC Repairing";
									break;
					case "tvrep":   servDisp = "TV Repairing";
									break;
					case "frirep":  servDisp = "Refrigerator Repairing";
									break;
					case "carC":    servDisp = "Car Cleaning";
									break;
					case "carP":    servDisp = "Carpentry";
									break;
					case "elec":    servDisp = "Electrician";
									break;
					case "plu":     servDisp = "Plumbing";
									break;
					case "hkp":     servDisp = "Housekeeping";
									break;
				}
				
				String fname = rs2.getString(1);
				String lname = rs2.getString(2);
				out.println("<tr><td>"+bookingID+"</td><td>"+fname+" "+lname+"</td><td>"+servDisp+"</td><td>"+bookDate+"</td><td>"+servDate+"</td><td>"+statDef+"</td>");
				
				if(status.equals("upc"))
				{
					out.println("<td><form action = 'ConfirmCancel.jsp'>"
							+"<input type = 'hidden' name = 'bookingID' value = "+bookingID+">"
							+"<input type = 'hidden' name = 'servType' value = '"+servDisp+"'>"
							+"<input type = 'hidden' name = 'servDate' value = '"+servDate+"'>" 
							+"<input type = 'submit' value = 'Cancel'></form></td></tr>");
				}
				else if(status.equals("com"))
				{
					out.println("<td><form action = 'Rating.jsp'>"
							+"<input type = 'hidden' name = 'bookingID' value = "+bookingID+">"
							+"<input type = 'hidden' name = 'servType' value = '"+servDisp+"'>"
							+"<input type = 'hidden' name = 'servDate' value = '"+servDate+"'>"
							+"<input type = 'hidden' name = 'userID' value = '"+userID+"'>"
							+"<input type = 'hidden' name = 'providerID' value = '"+providerID+"'>"
							+"<input type = 'submit' value = 'Submit Rating'></form></td></tr>");
				}
			
			
			
			}
			if(flag==1)
			{
				out.println("<tr><td>NO BOOKINGS MADE</td>");
				out.println("<td>Try booking a Service</td>");
				out.println("<td><form action = 'BookingPage.jsp' method='post'><input type = 'submit' value = 'Start Booking'></form></td></tr>");
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
