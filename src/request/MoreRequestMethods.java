package request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="MoreRequestMethods",urlPatterns= {"/moreRequestMethods"})
public class MoreRequestMethods extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		
		writer.write("<html><body>");
		
		String serverName = request.getServerName();
		String hostHeader = request.getHeader("host");
		int localPort = request.getLocalPort();
		int serverPort = request.getServerPort();
		int remotePort = request.getRemotePort();
		String metot = request.getMethod();
		String contextPath = request.getContextPath();
		Enumeration<String> headerNames = request.getHeaderNames();
		
		writer.write("Server Name: " + serverName + "</br>");
		writer.write("Host Header Info: " + hostHeader + "</br>");
		writer.write("Server Port: " + serverPort + "</br>");
		writer.write("Local Port: " + localPort + "</br>");
		writer.write("Server Port: " + serverPort + "</br>");
		writer.write("Remote Port: " + remotePort + "</br>");
		writer.write("Method: " + metot + "</br>");
		writer.write("Context Path: " + contextPath + "</br>");
		writer.write("Header Names:</br>");
		while (headerNames.hasMoreElements()) {
			String string = (String) headerNames.nextElement();
			writer.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + string + "</br>");
		}
		
		writer.write("</body></html>");
		writer.close();
	}
}
