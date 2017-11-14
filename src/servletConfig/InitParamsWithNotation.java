package servletConfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "initParamsWithNotation", urlPatterns = {"/initParamsWithNotation"}, 
			initParams = {@WebInitParam(name = "ali", value = "Ali Kizilirmak"),
							@WebInitParam(name = "baris", value = "Baris Kizilirmak")})
public class InitParamsWithNotation extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServletConfig config = getServletConfig();
		Enumeration<String> initParamsList = config.getInitParameterNames();
		PrintWriter writer = response.getWriter();
		
		while (initParamsList.hasMoreElements()) {
			String string = (String) initParamsList.nextElement();
			writer.write(" " + string + " ");
		}
		
		writer.write(" " + config.getInitParameter("ali") + " ");
		writer.write(" " + config.getInitParameter("baris"));
	}
}
