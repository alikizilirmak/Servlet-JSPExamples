package servlet.context.example;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReadingFileWithServletContext", urlPatterns = {"/ReadingFileWithServletContext"})
public class ReadingFileWithServletContext extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ServletContext context = getServletContext();
		
		InputStream txtStream = context.getResourceAsStream("/WEB-INF/ali.txt");
		InputStream propStream = context.getResourceAsStream("/WEB-INF/adSoyad.properties");
		 
		Properties properties = new  Properties();
		properties.load(propStream);
		
		System.out.println(properties.getProperty("ad"));
		System.out.println(properties.getProperty("soyad"));
		
		/*
		 * ServletOutputStream ile PrintWriter ayný anda kullanýlamaz.
		 * 
		int content;
		ServletOutputStream servletOutputStream = response.getOutputStream();
		while ((content = txtStream.read()) != -1) {
			servletOutputStream.write(content);
		}*/
		
		PrintWriter writer = response.getWriter();
		writer.write("</br>");
		writer.write(context.getRealPath("/WEB-INF/ali.txt"));
		writer.write("</br>");
		writer.write(context.getContextPath());
		writer.write("</br>");
		writer.write(context.getServletContextName());
	}
}
