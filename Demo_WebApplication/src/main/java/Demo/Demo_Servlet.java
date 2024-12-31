package Demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.mysql.cj.xdevapi.PreparableStatement;

public class Demo_Servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res ) throws ServletException, IOException {
		String fname= req.getParameter("fname");
		String lname= req.getParameter("lname");
		int age= Integer.parseInt(req.getParameter("age"));
	//	System.out.println("User details are: \nFirst Name: "+fname+" \nLast Name: "+lname+" \nAge: "+age);
		
		PrintWriter pw= res.getWriter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_webapp?user=root&&password=root");
			PreparedStatement ps= con.prepareStatement("insert into user1 values (?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setInt(3, age);
			ps.executeUpdate();
			
			pw.println("<html><body bgcolor='orange'>");
			//pw.println("<pre><h3>User details are: \nFirstName: "+fname+" \nLast Name: "+lname+" \nAge: "+age+"</h3></pre>");
			pw.println("<h2> Your Response got saved Successfully </h2>");
			pw.println("</body></html>");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.println("<html><body bgcolor='orange'>");
			//pw.println("<pre><h3>User details are: \nFirstName: "+fname+" \nLast Name: "+lname+" \nAge: "+age+"</h3></pre>");
			pw.println("<h2> Data not saved </h2>");
			pw.println("</body></html>");
		}
		
		
		
        
		 
	}

}
