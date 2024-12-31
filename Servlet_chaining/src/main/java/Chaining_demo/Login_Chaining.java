 package Chaining_demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_Chaining extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection con= null;
		PreparedStatement  ps=null;
		PrintWriter pwd= resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_http?user=root&&password=root");
			ps= con.prepareStatement("insert into user_details values(?,?)");
			
			String uname= req.getParameter("un");
			String pass= req.getParameter("pw");
			
//			if(uname.equals("baby")&& pass.equals("babu123")) {
//				RequestDispatcher rd= req.getRequestDispatcher("Home.html");
//				rd.forward(req, resp);
//			}else {
//				
//				pwd.println("<h1>invalid Credentials</h1>");
//				RequestDispatcher rd=req.getRequestDispatcher("login.html");
//				rd.include(req, resp);
//			}
			ps.executeUpdate();
			System.out.println("hello "+uname);
			pwd.println("<html><body bgcolor='orange'>");
//			pw.println("<pre><h3>User details are: \nFirstName: "+fname+" \nLast Name: "+lname+" \nAge: "+age+"</h3></pre>");
			pwd.println("<h2> Hello " + uname+ " Your Response got saved Successfully </h2>");
			pwd.println("</body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pwd.println("<html><body bgcolor='orange'>");
			//pw.println("<pre><h3>User details are: \nFirstName: "+fname+" \nLast Name: "+lname+" \nAge: "+age+"</h3></pre>");
			pwd.println("<h2> Sorry!! Something Went Wrong </h2>");
			pwd.println("</body></html>");
	}
		finally {
			if(pwd!=null) {
				pwd.close();
			}
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		
		
	}
}
