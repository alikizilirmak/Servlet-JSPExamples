package servlet.context.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextClass extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletContext context = getServletContext();
		PrintWriter writer = response.getWriter();
		
		Enumeration<String> enumeration = context.getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			writer.write(string);
			writer.write("</br>");
		}

		String email = context.getInitParameter("emailAddress");
		writer.write(email);
		writer.close();
	}
}
