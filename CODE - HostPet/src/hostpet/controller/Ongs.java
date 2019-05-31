package hostpet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.dao.OngDAO;
import hostpet.dao.UsuarioDAO;
import hostpet.model.Ong;
import hostpet.model.Usuario;

@WebServlet("/ongs")
public class Ongs extends HttpServlet {

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
		String cnpj = request.getParameter("cnpj");
		String descricao = request.getParameter("descricao");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		
		try {
			Ong ong = new Ong(nome, email, cidade, estado, cnpj, descricao);
			UsuarioDAO Udao = new UsuarioDAO();
			OngDAO Odao = new OngDAO();
			Odao.inserir(ong);
			Udao.inserirOng(usuario, ong);
			request.getRequestDispatcher("entrar.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("erro.jsp").forward(request, response);
		}
		
		
	}
}
