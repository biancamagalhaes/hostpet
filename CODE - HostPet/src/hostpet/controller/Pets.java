package hostpet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.dao.PetDAO;
import hostpet.enums.Porte;
import hostpet.enums.Sexo;
import hostpet.model.Pet;

@WebServlet("/pet")
public class Pets extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		int idade = Integer.parseInt(request.getParameter("idade"));
		String temperamento = request.getParameter("temperamento");
		String descricao = request.getParameter("descricao");
		String bairro = request.getParameter("bairro");
		Sexo sexo = null;
		Porte porte = null;
		
		if(request.getParameter("sexo") == "feminino") {
			sexo = sexo.FEMEA;
		}else {
			sexo = sexo.MACHO;
		}
		
		if(request.getParameter("porte") == "grande") {
			porte = porte.GRANDE;
		}else if(request.getParameter("porte") == "medio") {
			porte = porte.MEDIO;
		}else {
			porte = porte.PEQUENO;
		}
		
		Pet pet = new Pet(nome, idade, temperamento, sexo, porte, descricao, bairro);
		PetDAO dao = new PetDAO();
		dao.inserir(pet);
		//FAZER ESSA PARTE DO FILTRO E ETC
		//request.getRequestDispatcher("entrar.jsp").forward(request, response);
		
		
	}
}
