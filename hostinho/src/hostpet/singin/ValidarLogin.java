package hostpet.singin;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.controller.UsuarioDAO;
import hostpet.model.Usuario;

/**
 * Servlet implementation class ValidarLogin
 */
@WebServlet("/ValidarLogin")
public class ValidarLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String page = "";
		UsuarioDAO usuario = null;
		try {
			usuario = new UsuarioDAO();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pwd = usuario.md5(senha);
		List<Usuario> usuarios = usuario.getAll();
		
		for (Usuario usuario2 : usuarios) {
			if(usuario2.getLogin().equals(login)) {
				if(usuario2.getSenha().equals(pwd)) {
					page = "entrar.jsp";
					break;
				}else {
					page = "erro.jsp";
				}
			}else {
				page = "erro.jsp";
			}
		}
		
		response.sendRedirect(page);
		
	}
	

}
