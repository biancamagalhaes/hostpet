package hostpet.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import hostpet.dao.PetDAO;
import hostpet.enums.Porte;
import hostpet.enums.Sexo;
import hostpet.enums.Tipo;
import hostpet.model.Pet;
import hostpet.model.Usuario;

@WebServlet("/pets")
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
		Part filePart = request.getPart("foto");
		Sexo sexo = null;
		Porte porte = null;
		Tipo tipo = null;
		
		Usuario doador = (Usuario) request.getSession(true).getAttribute("usuario");
		System.out.println("nome" + doador.getNome());
		
		
		
		
		
		 // Retrieves <input type="file" name="file">
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		InputStream fileContent = filePart.getInputStream();
		File uploads = new File("/path/to/uploads");
		File file = new File(uploads, "somefilename.ext");

		try (InputStream input = filePart.getInputStream()) {
		Files.copy(input, file.toPath());
		}
		
		
		
		
		
		
		
		if(request.getParameter("tipo") == "gato") {
			tipo = tipo.GATO;
		}else {
			tipo = tipo.CACHORRO;
		}
		
		if(request.getParameter("sexo") == "feminino") {
			sexo = sexo.FEMEA;
		}else {
			sexo = sexo.MACHO;
		}
		
		int p = Integer.parseInt(request.getParameter("porte"));
		System.out.println(p);
		if(p >= 66) {
			porte = porte.GRANDE;
		}else if( p < 66 && p >33 ) {
			porte = porte.MEDIO;
		}else {
			porte = porte.PEQUENO;
		}
		
		try {
			Pet pet = new Pet(nome, idade, temperamento, sexo, porte, descricao, bairro, doador, tipo);
			PetDAO dao = new PetDAO();
			dao.inserir(pet);
			request.getRequestDispatcher("adote.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
		
		
	}
}
