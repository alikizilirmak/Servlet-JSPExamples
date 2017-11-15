package response;

import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ResponseOne",urlPatterns= {"/responseOne"})
public class ResponseOne extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			response.setCharacterEncoding("ISO-8859-9");
			//response.setCharacterEncoding("UTF-8");
			PrintWriter writer = response.getWriter();
			writer.write("Kýzýlýrmak");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
