package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Divide extends HttpServlet  {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw= resp.getWriter();
		HttpSession session= req.getSession();
		int squ=(int)session.getAttribute("squ");
		try {
			double divide = squ/2;
		
			pw.println("<html><body bgcolor='yellow'>");
			pw.println("<h2> division of "+squ+ " by 2 is "+ divide+ "</h2>");
			pw.println("</body></html>");
		}catch (ArithmeticException e) {
			
			pw.println("<html><body bgcolor='cyan'>");
			pw.println("<h2> Cannot Divide by zero</h2>");
			pw.println("</body></html>");
		}
		
	}
}
