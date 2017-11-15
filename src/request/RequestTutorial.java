package request;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="RequestTutorial",urlPatterns= {"/requestTutorial"})
public class RequestTutorial extends HttpServlet{

	/**
	 * doGet yerine doPost metodunu override etmek, verilerin url'de görünmemesizi saðlar.
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter writer = response.getWriter();
		writer.write(request.getParameter("firstName") + " ");
		writer.write(request.getParameter("lastName") + " ");
		writer.write(request.getParameter("marialStatus"));
		String[] params = request.getParameterValues("progLang");
		if (params.length > 0) {
			for (int i = 0; i < params.length; i++) {
				writer.write(" " + params[i] + " ");
			}
		}else {
			writer.write("Veri bulunamadý!");
		}
	}
}
