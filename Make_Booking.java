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
 * Servlet implementation class Make_Booking
 */
@WebServlet("/Make_Booking")
public class Make_Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Make_Booking() {
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
		
		response.setHeader("Cache-Control","no-cache");
	    response.setHeader("Cache-Control","no-store");
	    response.setHeader("Pragma","no-cache");
	    response.setDateHeader ("Expires", 0);
		
		PrintWriter out = response.getWriter();
		Connection conn;
		PreparedStatement pst,pst2,pst3,pst4;
		ResultSet rs,rs2,rs3,rs4;
		try
		{
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
			
			
			String servType = request.getParameter("servType");
			String uname = request.getParameter("uname");
			
			String servDate = request.getParameter("servDate");
			
			
			String sql = "select * from providers where servType = \""+servType+"\"";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			
			/*Get list of all providers who provide the chosen service*/
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			int flag = 1;
			out.println("<table><tr><th>Provider Name</th><th>Average Rating</th><th>Confirm Booking</th>");
			
			while(rs.next())
			{
				/*For each such provider, see if they have an upcoming booking on same date*/
				String pname = rs.getString(1);
				String sql2 = "select * from booking where providerID = \""+pname+"\" and servDate = \""+servDate+"\" and status = \"upc\"";
				pst2 = conn.prepareStatement(sql2);
				rs2 = pst2.executeQuery(sql2);
				if(rs2.next()==false)    //Provider Available without previous booking
				{
					//Get name of free provider
					String sql3 = "select fname, lname from user_customer where uname = \""+rs.getString(1)+"\"";
					pst3 = conn.prepareStatement(sql3);
					rs3 = pst3.executeQuery(sql3);
					
					/*Get average rating of provider*/
					String sql4 = "select AVG(rating) from rating where providerID = \""+pname+"\"";
					pst4 = conn.prepareStatement(sql4);
					rs4 = pst4.executeQuery();
					String rating = "";
					
					rs4.next();
					rating = rs4.getString(1);
					
					if(rating == null)
						rating = "Unrated";
					
					while(rs3.next())
					{
						out.println("<tr><td>"+rs3.getString(1)+" "+rs3.getString(2)+"</td><td>"+rating+"</td>");
						out.println("<td><form method = 'post' action = 'Confirm_Booking'>");
						out.println("<input type = 'hidden' name = 'userID' value = '"+uname+"'>");
						out.println("<input type = 'hidden' name = 'providerID' value = '"+rs.getString(1)+"'>");
						out.println("<input type = 'hidden' name = 'servDate' value = '"+servDate+"'>");
						out.println("<input type = 'submit' value='Confirm'></form></td></tr>");
						flag = 0;
					}
				}
			}
			if(flag==1)
			{
				out.println("<tr><td>Currently no Service Providers available on chosen date</td>");
				out.println("<td><form action = 'BookingPage.jsp'>");
				out.println("<input type = 'submit' value = 'Try a different Date'></form></td></tr></table>");
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
