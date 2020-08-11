package SagnikBeta;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class User_Entry
 */
@WebServlet("/User_Entry")
public class User_Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User_Entry() {
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
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");

			String sql = "insert into user_customer(uname,pass,fname,lname,emailID,phNO,address,userType) values(?,?,?,?,?,?,?,?)" ;
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String emailID = request.getParameter("emailID");
			String phNO = request.getParameter("phNO");
			String address = request.getParameter("address");
			String userType = request.getParameter("userType");
			pst = conn.prepareStatement(sql);
			pst.setString(1,uname);
			pst.setString(2,pass);
			pst.setString(3,fname);
			pst.setString(4,lname);
			pst.setString(5,emailID);
			pst.setString(6,phNO);
			pst.setString(7,address);
			pst.setString(8, userType);
			pst.execute() ;
			if(userType.equals("provider"))
			{
				String servType = request.getParameter("servType");
				String sql2 = "insert into providers(uname,servType) values(?,?)";
				pst2 = conn.prepareStatement(sql2);
				pst2.setString(1, uname);
				pst2.setString(2, servType);
				pst2.execute();
			}
			out.println("User Account Created!! Login with your Credentials!");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
