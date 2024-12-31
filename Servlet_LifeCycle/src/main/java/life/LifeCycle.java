package life;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(urlPatterns = "/life")
public class LifeCycle extends GenericServlet {

	
	public LifeCycle() {
		System.out.println("Object Created");
	}
	
	public void init() throws ServletException {
		System.out.println("initialization done");
	}
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		String name= arg0.getParameter("name");
		System.out.println("Hello: "+name);
	}
	public void destroy() {
		System.out.println("destroyed");
	}
	
	
}
