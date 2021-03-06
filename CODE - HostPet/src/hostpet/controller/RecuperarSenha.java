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
		String msg = null;
		String page = null;
		
		Usuario u = new Usuario();
		u.setSenha(senha);
		u.setEmail(email);
		
		RecuperarSenhaDAO s = new RecuperarSenhaDAO();
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario user = s.verificar(email);
		
		if(user == null) {
			msg = "Desculpa n�o encontramos esse email no nosso banco de dados, talvez tenha errado!";
			page = "recuperarSenha.jsp";
		}else {
			dao.senha(u);
			page = s.email(email, senha);
		}
		
		request.getRequestDispatcher(page).forward(request, response);
	}

}
