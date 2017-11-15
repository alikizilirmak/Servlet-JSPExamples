package response;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ResponseHeaderExample",urlPatterns= {"/responseHeaderExample"})
public class ResponseHeaderExample extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setHeader("Isim", "Ali Kizilirmak");
		
		//setHeader override mant��� ile �al���r
		response.setHeader("Isim", "Baris Kizilirmak");
		
		boolean isNameApsend = response.containsHeader("Isim");
		System.out.println("Bir isim var m�? " + isNameApsend);
		
		String name = response.getHeader("Isim");
		System.out.println("�sim: " + name);
		
		response.addHeader("Isim", "Dilek Kizilirmak");
		
		Collection<String> names = response.getHeaders("Isim");
		for (String string : names) {
			System.out.println("�sim: " + string);
		}
		
		response.setIntHeader("Yas", 27);
		response.addIntHeader("Yas", 35);
		response.addIntHeader("Yas", 16);
		
		Collection<String> ages = response.getHeaders("Yas");
		for (String string : ages) {
			System.out.println("Ya�: " + string);
		}
		
		
	}
}
