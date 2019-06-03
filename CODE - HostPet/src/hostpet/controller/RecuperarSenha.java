package hostpet.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.dao.RecuperarSenhaDAO;
import hostpet.dao.UsuarioDAO;
import hostpet.model.Usuario;


/**
 * Servlet implementation class RecuperarSenha
 */
@WebServlet("/recuperarSenha")
public class RecuperarSenha extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecuperarSenha() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= request.getParameter("email");
		Date date= new Date();
		long time = date.getTime();
		String senha = Long.toString(time);
		
		Usuario u = new Usuario();
		u.setSenha(senha);
		u.setEmail(email);
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.senha(u);
		RecuperarSenhaDAO s = new RecuperarSenhaDAO();
		
		String page = s.email(email, senha);
		System.out.println("Page" + page);
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
