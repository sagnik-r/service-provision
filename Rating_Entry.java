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
 * Servlet implementation class Rating_Entry
 */
@WebServlet("/Rating_Entry")
public class Rating_Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rating_Entry() {
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
		// doGet(request, response);
		response.setHeader("Cache-Control","no-cache");
	    response.setHeader("Cache-Control","no-store");
	    response.setHeader("Pragma","no-cache");
	    response.setDateHeader ("Expires", 0);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection conn;
		PreparedStatement pst,pst2;
		ResultSet rs;
		try
		{
			out.println("<head><style>input[type=submit] {"+
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
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			
			int bookingID = Integer.parseInt(request.getParameter("bookingID"));
			String userID = request.getParameter("userID");
			String providerID = request.getParameter("providerID");
			String servDate = request.getParameter("servDate");
			int rating = Integer.parseInt(request.getParameter("rating"));
			String review = request.getParameter("review");
			String complaint = request.getParameter("complaint");
			
			String sql = "select * from rating where bookingID = "+bookingID;
			
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			if(rs.next()==false)
			{
				String sql2 = "insert into rating(bookingID,userID,providerID,rating,review,complaint,resolved) values(?,?,?,?,?,?,?)";
				pst2 = conn.prepareStatement(sql2);
				pst2.setInt(1, bookingID);
				pst2.setString(2, userID);
				pst2.setString(3, providerID);
				pst2.setInt(4, rating);
				pst2.setString(5, review);
				pst2.setString(6, complaint);
				if(complaint.equals("yes"))
					pst2.setString(7, "no");
				else
					pst2.setString(7, "yes");
				
				pst2.execute();
				
				out.println("<h2>Rating and Review registered successfully");
				out.println("<form action = 'Home_User.jsp'>");
				out.println("<input type = 'submit' value = 'Home'></form></h2>");
				
				
			}
			else
			{
				out.println("<h2>You have already submitted a rating for this booking");
				out.println("<form action = 'Home_User.jsp'>");
				out.println("<input type = 'submit' value = 'Home'></form></h2>");
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
