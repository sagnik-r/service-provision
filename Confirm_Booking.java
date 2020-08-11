package SagnikBeta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Confirm_Booking
 */
@WebServlet("/Confirm_Booking")
public class Confirm_Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Confirm_Booking() {
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
		PreparedStatement pst,pst2,pst3,pst4;
		ResultSet rs2,rs3,rs4;
		
		try
		{
			String userID = request.getParameter("userID");
			String providerID = request.getParameter("providerID");
			String servDate = request.getParameter("servDate");
			
			Date date = Calendar.getInstance().getTime();  
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
			String bookDate = dateFormat.format(date); 
			
			
			int bookingID;
			String sql = "insert into booking(bookingID,userID,providerID,address,phNO,phNOpr,bookDate,servDate,status) values(?,?,?,?,?,?,?,?,?)";
			String sql2 = "select address,phNO from user_customer where uname = \""+userID+"\"";
			String sql3 = "select phNO from user_customer where uname = \""+providerID+"\"";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			
			/*Getting customer phNO and Address*/
			pst2 = conn.prepareStatement(sql2);
			rs2 = pst2.executeQuery();
			
			/*Getting Provider phNO*/
			pst3 = conn.prepareStatement(sql3);
			rs3 = pst3.executeQuery();
			
			rs2.next(); rs3.next();
			
			
			/*Getting Booking ID*/
			
			  String sql4 = "select MAX(bookingID) from booking"; 
			  pst4 = conn.prepareStatement(sql4); 
			  rs4 = pst4.executeQuery();
			  if(rs4.next()==false)
				  bookingID = 1; 
			  else 
				  bookingID = rs4.getInt(1)+1;
			 
			
			/*Entering into Table*/
			pst = conn.prepareStatement(sql);
			pst.setInt(1,bookingID);
			pst.setString(2,userID);
			pst.setString(3,providerID);
			pst.setString(4,rs2.getString(1));
			pst.setString(5,rs2.getString(2));
			pst.setString(6, rs3.getString(1));
			pst.setString(7, bookDate);
			pst.setString(8, servDate);
			pst.setString(9, "upc");
			pst.execute();
			
			out.println("<h2 style = 'font-family:georgia,garamond,serif;font-size:18px;font-style:bold;'>Your Booking was made successfully</h2>");
			out.println("<form action = 'Home_User.jsp'>");
			out.println("<input type = 'submit' style = 'color: white; font-family:georgia,garamond,serif;font-size:20px;font-style:bold;background-color: darkslategray;' value = 'Home'></form></h2>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
