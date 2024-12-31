package employeeManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_servlet?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("select * from employee_management_system where eid=? and password=?");
			int eid = Integer.parseInt(req.getParameter("eid"));
			String pwd = req.getParameter("password");
			ps.setLong(1, eid);
			ps.setString(2, pwd);
			s.setAttribute("eid", eid);
			ResultSet rs = ps.executeQuery();
			RequestDispatcher rd1 = req.getRequestDispatcher("view-details-int.html");
			RequestDispatcher rd2 = req.getRequestDispatcher("login.html");
			if(rs.next())
				rd1.forward(req, resp);
			else
				rd2.include(req, resp);				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
