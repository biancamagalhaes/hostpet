package hostpet.singin;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hostpet.dao.PetDAO;
import hostpet.dao.UsuarioDAO;
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
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.login(login,senha);
		
		if(usuario!=null){
			//ok
			request.getSession(true).setAttribute("usuario", usuario);
			PetDAO Pdao = new PetDAO();
			request.setAttribute("Petlista", Pdao.listarAdote());
			page = "adote.jsp";
		}else{
			//erro
			page = "erro.jsp";
		}

		
		response.sendRedirect(page);
		
	}
	

}
