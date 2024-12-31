package demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Square extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	//	int num=(int)req.getAttribute("num"); //**1st way**
		 
	//	int num= Integer.parseInt(req.getParameter("a")); //**2nd way using form input**
		
	// 3rd way using session 
		
	HttpSession session= req.getSession();
	
	
	int num=(int) session.getAttribute("num");
	int square= num*num;
	session.setAttribute("squ",square);
	PrintWriter pw= resp.getWriter();
	 pw.println("<html><body bgcolor='blue'>");
		pw.println("<h2> Square of number is " +square+ "</h2>");
		pw.println("<form action='div'>");
		pw.println("<button>divide</button>");
		pw.println("</form>");
		pw.println("</body></html>");
		
		
	}
}
