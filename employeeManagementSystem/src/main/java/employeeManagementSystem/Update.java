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

@WebServlet(urlPatterns = "/get-details")
public class Update extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession(false);
		int eid = (int) s.getAttribute("eid");
		String phoneStr = req.getParameter("phone");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String dob = req.getParameter("dob");
		String city = req.getParameter("city");
		String pwd = req.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_servlet?user=root&&password=root");
			if(!phoneStr.isEmpty()) {
				long phone = Long.parseLong(phoneStr);
				PreparedStatement ps1 = con.prepareStatement("update employee_management_system set phone=? where eid=?");
				ps1.setLong(1, phone);
				ps1.setInt(2, eid);
				ps1.executeUpdate();
			}
			if(!fname.isEmpty()) {
				PreparedStatement ps1 = con.prepareStatement("update employee_management_system set fname=? where eid=?");
				ps1.setString(1, fname);
				ps1.setInt(2, eid);
				ps1.executeUpdate();
			}
			if(!dob.isEmpty()) {
				PreparedStatement ps1 = con.prepareStatement("update employee_management_system set dob=? where eid=?");
				ps1.setString(1,dob);
				ps1.setInt(2, eid);
				ps1.executeUpdate();
			}
			if(!lname.isEmpty()) {
				PreparedStatement ps1 = con.prepareStatement("update employee_management_system set lname=? where eid=?");
				ps1.setString(1, lname);
				ps1.setInt(2, eid);
				ps1.executeUpdate();
			}
			if(!pwd.isEmpty()) {
				PreparedStatement ps1 = con.prepareStatement("update employee_management_system set password=? where eid=?");
				ps1.setString(1, pwd);
				ps1.setInt(2, eid);
				ps1.executeUpdate();
			}
			if(!city.isEmpty()) {
				PreparedStatement ps1 = con.prepareStatement("update employee_management_system set city=? where eid=?");
				ps1.setString(1, city);
				ps1.setInt(2, eid);
				ps1.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = req.getRequestDispatcher("/view-details");
		rd.forward(req, resp);
	}
}
