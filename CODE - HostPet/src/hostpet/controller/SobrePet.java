package hostpet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.dao.PetDAO;
import hostpet.model.Pet;



@WebServlet("/SobrePet")
public class SobrePet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("cheguei no sobre");
		String id = request.getParameter("button");
		
		try {
			PetDAO dao = new PetDAO();
			Pet pet = new Pet();
			pet = dao.sobre(Integer.parseInt(id));
			request.getSession(true).setAttribute("pet", pet);
			request.getRequestDispatcher("pet.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	
	}
}
