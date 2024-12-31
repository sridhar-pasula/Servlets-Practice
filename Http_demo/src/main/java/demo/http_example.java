package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class http_example extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		String ename= req.getParameter("ename");
		String des= req.getParameter("des");
		Long sal = Long.parseLong(req.getParameter("sal"));
		String email= req.getParameter("email");
		Connection con= null;
		PreparedStatement  ps=null;
		
	PrintWriter pw= resp.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/http_demo?user=root&&password=root");
			ps= con.prepareStatement("insert into emp values (?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, ename);
			ps.setString(3, des);
			ps.setLong(4, sal);
			ps.setString(5, email);
			ps.executeUpdate();
			System.out.println("hello "+ename);
			pw.println("<html><body bgcolor='orange'>");
//			pw.println("<pre><h3>User details are: \nFirstName: "+fname+" \nLast Name: "+lname+" \nAge: "+age+"</h3></pre>");
			pw.println("<h2> Hello " + ename+ " Your Response got saved Successfully </h2>");
			pw.println("</body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.println("<html><body bgcolor='orange'>");
			//pw.println("<pre><h3>User details are: \nFirstName: "+fname+" \nLast Name: "+lname+" \nAge: "+age+"</h3></pre>");
			pw.println("<h2> Sorry!! " + ename+ " Something Went Wrong </h2>");
			pw.println("</body></html>");
	}
		finally {
			if(pw!=null) {
				pw.close();
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

