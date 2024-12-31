package demo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Calci extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 int n1= Integer.parseInt(req.getParameter("num1"));
	 int n2= Integer.parseInt(req.getParameter("num2"));
	 int sum= n1+n2;
	 
// 3rd way
	 HttpSession session = req.getSession();
	 session.setAttribute("num", sum);
	 
	 PrintWriter pw= resp.getWriter();
	 pw.println("<html><body bgcolor='orange'>");
		pw.println("<h2> Sum of two numbers is "+sum+ "</h2>");
		pw.println("<form action='sqr'>");
//		pw.println("<input type='hidden' name='a' value="+sum+">"); // 2nd way
		pw.println("<button>square</button>");
		pw.println("</form>");
		
		pw.println("</body></html>");
		
		// first way
//		req.setAttribute("num", sum);
//		RequestDispatcher rd= req.getRequestDispatcher("sqr");
//		rd.forward(req, resp);
		
		
		
	}
}
