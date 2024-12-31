package err;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/hello")
public class Http_Status_Matching extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int a= Integer.parseInt(req.getParameter("hello"));
		int b=a/0;
		PrintWriter pw= resp.getWriter();
		pw.println("<h1> res is"+b+"</h1>");
	}
}
