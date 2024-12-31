package employeeManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String dob = req.getParameter("dob");
		String city = req.getParameter("city");
		String pwd = req.getParameter("password");
		long phone = Long.parseLong(req.getParameter("phone"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_servlet?user=root&&password=root");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select max(eid) from employee_management_system");
			PreparedStatement ps = con.prepareStatement("insert into employee_management_system values(?,?,?,?,?,?,?)");
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setString(4, dob);
			ps.setString(5, city);
			ps.setLong(6, phone);
			ps.setString(7, pwd);
			int newEid = 101;
            if(rs.next()) {
                int maxEid = rs.getInt(1);
                if(!rs.wasNull()) {
                    newEid = maxEid + 1;
                }
            }
            ps.setInt(1, newEid);
			ps.executeUpdate();
			resp.sendRedirect("login.html");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}