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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login_Validate
 */
@WebServlet("/Login_Validate")
public class Login_Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Validate() {
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
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String sql = "select uname,pass,userType from user_customer where uname =\""+uname+"\"";
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql:///sagnik","root","sagnik");
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			if(rs.next())
			{
				if(rs.getString(2).equals(pass))
				{
					if(rs.getString(3).equals("user"))
					{
						HttpSession session = request.getSession();
						session.setAttribute("username",uname);
						response.sendRedirect("Home_User.jsp");
					}
					else if(rs.getString(3).equals("provider"))
					{
						HttpSession session = request.getSession();
						session.setAttribute("username",uname);
						response.sendRedirect("Home_Provider.jsp");
					}
					else if(rs.getString(3).equals("admin"))
					{
						HttpSession session = request.getSession();
						session.setAttribute("username",uname);
						response.sendRedirect("Home_Admin.jsp");
					}
					else
					{
						response.sendRedirect("Login.jsp");
					}
				}
				else
				{
					out.println("Invalid Credentials");
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
					
				}
			}
			else
			{
				out.println("Invalid Credentials");
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.include(request, response);
				
			}
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}
