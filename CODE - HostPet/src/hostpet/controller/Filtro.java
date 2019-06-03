package hostpet.controller;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.dao.PetDAO;
import hostpet.enums.Porte;
import hostpet.enums.Tipo;
import hostpet.model.Pet;
import hostpet.model.Usuario;

/**
 * Servlet implementation class Filtro
 */
@WebServlet("/filtro")
public class Filtro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Filtro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String p = request.getParameter("p");
			if (p != null && p.equals("new")) {
				//PetDAO dao = new PetDAO();
				//request.setAttribute("Petlista", dao.);
				request.getRequestDispatcher("adote.jsp").forward(request, response);
			} else {
				//PetDAO dao = new PetDAO();
				//request.setAttribute("Petlista", dao.listarAdote());
				request.getRequestDispatcher("adote.jsp").forward(request, response);
			}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int gato = Integer.parseInt(request.getParameter("gato"));
		int cachorro = Integer.parseInt(request.getParameter("cachorro"));
		int p = Integer.parseInt(request.getParameter("porte"));
		String cidade = request.getParameter("cidade");
		
		Porte porte = null;
		Tipo tipo = null;
		
		if(p >= 66) {
			porte = porte.GRANDE;
		}else if( p < 66 && p >33 ) {
			porte = porte.MEDIO;
		}else {
			porte = porte.PEQUENO;
		}
		
		
		if(gato == 1) {
			tipo = tipo.GATO;
		}else if(cachorro == 1){
			tipo = tipo.CACHORRO;
		}else {
			tipo = null;
		}
		
		try {
			Pet pet = new Pet();
			pet.setPorte(porte);
			pet.setTipo(tipo);
			Usuario usuario = new Usuario();
			usuario.setCidade(cidade);
			PetDAO dao = new PetDAO();
			dao.filtro(pet, usuario);
			request.setAttribute("Petlista", dao.listarAdote());
			request.getRequestDispatcher("adote.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
	}

}
