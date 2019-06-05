package hostpet.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import hostpet.dao.PetDAO;
import hostpet.dao.RecuperarSenhaDAO;
import hostpet.enums.Porte;
import hostpet.enums.Sexo;
import hostpet.enums.Tipo;
import hostpet.model.Pet;
import hostpet.model.Usuario;


@WebServlet("/pets")
@MultipartConfig
public class Pets extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String p = request.getParameter("p");
		if (p != null && p.equals("new")) {
			PetDAO dao = new PetDAO();
			Usuario u = (Usuario) request.getSession(true).getAttribute("usuario");
			request.setAttribute("Petlista", dao.listarAdote());
			request.setAttribute("Petadocao", dao.adocao(u));
			request.setAttribute("Petdoacao", dao.doacao(u));
			request.getRequestDispatcher("cadastroPet.jsp").forward(request, response);
		} else {
			PetDAO dao = new PetDAO();
			request.setAttribute("Petlista", dao.listarAdote());
			request.getRequestDispatcher("adote.jsp").forward(request, response);
		}
	}	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String petnome = request.getParameter("btn");
		Usuario u = (Usuario) request.getSession(true).getAttribute("usuario");
		
		
		if(petnome == null) {
			Date date= new Date();
			long time = date.getTime();
			Part foto = request.getPart("file");  
			
			String nome = request.getParameter("nome");
			int idade = Integer.parseInt(request.getParameter("idade"));
			String temperamento = request.getParameter("temperamento");
			String descricao = request.getParameter("descricao");
			String bairro = request.getParameter("bairro");
			String fotoNome = Paths.get(foto.getSubmittedFileName()).getFileName().toString();

			File uploads = new File("C:\\Users\\bianc\\eclipse-workspace\\host\\WebContent\\perfil");
			String novoNome = time + fotoNome;
			File file = new File(uploads, novoNome);
			
//			try (InputStream input = foto.getInputStream()) {
//				Files.copy(input, file.toPath());
//				}
			
			Sexo sexo = null;
			Porte porte = null;
			Tipo tipo = null;		
			Usuario doador = (Usuario) request.getSession(true).getAttribute("usuario");
			System.out.println("nome" + doador.getNome());
			
			
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
				Pet pet = new Pet(nome, idade, temperamento, sexo, porte, descricao, bairro, doador, tipo, novoNome);
				PetDAO dao = new PetDAO();
				dao.inserir(pet);
				request.setAttribute("Petlista", dao.listarAdote());
				request.getRequestDispatcher("adote.jsp").forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			}
		}else {
			try {
				Usuario user = (Usuario) request.getSession(true).getAttribute("usuario");
				PetDAO dao = new PetDAO();
				System.out.println(petnome);
				System.out.println(u.getNome());
				dao.adotante(petnome, u.getNome(), user);
				request.getRequestDispatcher("adote.jsp").forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
				request.getRequestDispatcher("erro.jsp").forward(request, response);
			}
		}
		
	
	}
}
