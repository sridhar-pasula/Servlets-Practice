package employeeManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/del-confirm")
public class DelConfirm extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession s = req.getSession(false);
		int eid = (int)s.getAttribute("eid");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_servlet?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("select * from employee_management_system where eid=?");
			ps.setLong(1, eid);
			ResultSet rs = ps.executeQuery();
			rs.next();
			long phone = rs.getLong(6);
			String fname = rs.getString(2);
			String lname = rs.getString(3);
			String dob = rs.getString(4);
			String city = rs.getString(5);
			PrintWriter pw = resp.getWriter();
			pw.print("<!DOCTYPE html>\r\n"
					+ "<html lang='en'>\r\n"
					+ "  <head>\r\n"
					+ "    <meta charset='UTF-8' />\r\n"
					+ "    <meta name='viewport' content='width=device-width, initial-scale=1.0' />\r\n"
					+ "    <title>Document</title>\r\n"
					+ "    <style>\r\n"
					+ "      * {\r\n"
					+ "        padding: 0;\r\n"
					+ "        margin: 0;\r\n"
					+ "        box-sizing: border-box;\r\n"
					+ "      }\r\n"
					+ "      #view-details h1 {\r\n"
					+ "        position: absolute;\r\n"
					+ "        top: 30px;\r\n"
					+ "        color: #313f4a;\r\n"
					+ "      }\r\n"
					+ "      body {\r\n"
					+ "        background-color: grey;\r\n"
					+ "      }\r\n"
					+ "      section {\r\n"
					+ "        background-color: orange;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      #view-details {\r\n"
					+ "        height: 100vh;\r\n"
					+ "        /* border: 2px solid green; */\r\n"
					+ "        display: flex;\r\n"
					+ "        align-items: center;\r\n"
					+ "        justify-content: center;\r\n"
					+ "      }\r\n"
					+ "      #view-details section {\r\n"
					+ "        width: 30%;\r\n"
					+ "        /* border: 2px solid red; */\r\n"
					+ "        display: flex;\r\n"
					+ "        align-items: center;\r\n"
					+ "        justify-content: center;\r\n"
					+ "        height: 65vh;\r\n"
					+ "        border-radius: 15px;\r\n"
					+ "        box-shadow: 0 0 5px 2px rgba(0, 0, 0, 0.3);\r\n"
					+ "        font-size: 18px;\r\n"
					+ "        font-weight: 600;\r\n"
					+ "        color: #172631;\r\n"
					+ "      }\r\n"
					+ "      #view-details section > div {\r\n"
					+ "        height: 90%;\r\n"
					+ "        /* border: 2px solid green; */\r\n"
					+ "        width: 90%;\r\n"
					+ "        flex-direction: column;\r\n"
					+ "        justify-content: center;\r\n"
					+ "        gap: 20px;\r\n"
					+ "      }\r\n"
					+ "      #view-details div {\r\n"
					+ "        display: flex;\r\n"
					+ "        align-items: center;\r\n"
					+ "      }\r\n"
					+ "      #view-details div div {\r\n"
					+ "        justify-content: space-between;\r\n"
					+ "        gap: 8px;\r\n"
					+ "      }\r\n"
					+ "      button {\r\n"
					+ "        padding: 8px 12px;\r\n"
					+ "        border-radius: 15px;\r\n"
					+ "        cursor: pointer;\r\n"
					+ "        border: none;\r\n"
					+ "        background-color: rgb(55, 55, 141);\r\n"
					+ "        color: #fff;\r\n"
					+ "        font-weight: 700;\r\n"
					+ "        transition-property: background-color box-shadow;\r\n"
					+ "        transition-duration: 300ms;\r\n"
					+ "      }\r\n"
					+ "      button:hover {\r\n"
					+ "        background-color: rgb(111, 111, 192);\r\n"
					+ "        box-shadow: 0 0 3px 2px rgba(0, 0, 0, 0.3);\r\n"
					+ "      }\r\n"
					+ "      #view-details table input {\r\n"
					+ "        padding: 5px;\r\n"
					+ "        border-radius: 5px;\r\n"
					+ "        border: none;\r\n"
					+ "      }\r\n"
					+ "    </style>\r\n"
					+ "  </head>\r\n"
					+ "  <body>\r\n"
					+ "    <main id='view-details'>\r\n"
					+ "      <h1 style=\"color: white\">View Details</h1>\r\n"
					+ "      <section>\r\n"
					+ "        <div>\r\n"
					+ "          <form action='' method='post'>\r\n"
					+ "            <table cellspacing='20px'>\r\n"
					+ "              <tr>\r\n"
					+ "                <td><label for='eid'>Employee ID</label></td>\r\n"
					+ "                <td>\r\n"
					+ "                  <input\r\n"
					+ "                    type='text'\r\n"
					+ "                    id='eid'\r\n"
					+ "                    name='eid'\r\n"
					+ "                    placeholder='EID'\r\n"
					+ "                    value='"+eid+"'\r\n"
					+ "                    disabled\r\n"
					+ "                  />\r\n"
					+ "                </td>\r\n"
					+ "              </tr>\r\n"
					+ "              <tr>\r\n"
					+ "                <td><label for='fname'>First Name</label></td>\r\n"
					+ "                <td>\r\n"
					+ "                  <input\r\n"
					+ "                    type='text'\r\n"
					+ "                    id='fname'\r\n"
					+ "                    name='fname'\r\n"
					+ "                    placeholder='First Name'\r\n"
					+ "                    value='"+fname+"'\r\n"
					+ "                    disabled\r\n"
					+ "                  />\r\n"
					+ "                </td>\r\n"
					+ "              </tr>\r\n"
					+ "              <tr>\r\n"
					+ "                <td><label for='lname'>Last Name</label></td>\r\n"
					+ "                <td>\r\n"
					+ "                  <input\r\n"
					+ "                    type='text'\r\n"
					+ "                    id='lname'\r\n"
					+ "                    name='lname'\r\n"
					+ "                    placeholder='Last Name'\r\n"
					+ "                    value='"+lname+"'\r\n"
					+ "                    disabled\r\n"
					+ "                  />\r\n"
					+ "                </td>\r\n"
					+ "              </tr>\r\n"
					+ "              <tr>\r\n"
					+ "                <td><label for='dob'>Date of Birth</label></td>\r\n"
					+ "                <td>\r\n"
					+ "                  <input type='date' name='dob' id='dob' value='"+dob+"' disabled />\r\n"
					+ "                </td>\r\n"
					+ "              </tr>\r\n"
					+ "              <tr>\r\n"
					+ "                <td><label for='city'>Current City</label></td>\r\n"
					+ "                <td>\r\n"
					+ "                  <input\r\n"
					+ "                    type='text'\r\n"
					+ "                    name='city'\r\n"
					+ "                    id='city'\r\n"
					+ "                    placeholder='Current City'\r\n"
					+ "                    value='"+city+"'\r\n"
					+ "                    disabled\r\n"
					+ "                  />\r\n"
					+ "                </td>\r\n"
					+ "              </tr>\r\n"
					+ "              <tr>\r\n"
					+ "                <td><label for='phone'>Contact Number</label></td>\r\n"
					+ "                <td>\r\n"
					+ "                  <input\r\n"
					+ "                    type='tel'\r\n"
					+ "                    name='phone'\r\n"
					+ "                    id='phone'\r\n"
					+ "                    placeholder='Contact Number'\r\n"
					+ "                    value='"+phone+"'\r\n"
					+ "                    disabled\r\n"
					+ "                  />\r\n"
					+ "                </td>\r\n"
					+ "              </tr>\r\n"
					+ "              <tr>\r\n"
					+ "                <td align='center' colspan='2'><button type='submit' formaction='delete'>Confirm Delete</button></td>\r\n"
					+ "              </tr>\r\n"
					+ "            </table>\r\n"
					+ "          </form>\r\n"
					+ "        </div>\r\n"
					+ "      </section>\r\n"
					+ "    </main>\r\n"
					+ "  </body>\r\n"
					+ "</html>\r\n"
					+ "");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
