package hostpet.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.dao.UsuarioDAO;
import hostpet.model.Usuario;

@WebServlet("/usuarios")
public class Usuarios extends HttpServlet {

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
		String email = request.getParameter("email");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String cpf = request.getParameter("cpf");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String telefone = null;
	
		//DATE AND TIME
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		
		try {
			date = simpleDateFormat.parse(request.getParameter("data"));
			java.sql.Date data = new java.sql.Date(date.getTime()); 
			
			Usuario usuario = new Usuario(login, senha, email, nome, cidade, estado, telefone, cpf, data);
			UsuarioDAO dao = new UsuarioDAO();
			dao.inserir(usuario);
			request.getRequestDispatcher("adocao.jsp").forward(request, response);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
		
	}
}
