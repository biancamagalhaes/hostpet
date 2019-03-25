package hostpet.singin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Usuario
 */
@WebServlet("/Usuario")
public class Usuario {

	 private String login;
	 private String senha;
	 private String email;
	 private String nome;

	 public Usuario() { }
			
	 public Usuario(String login, String senha, String email, String nome) {
	  this.login = login;
	  this.senha = senha;
	  this.email = email;
	  this.nome = nome;
	 }

	 public String getLogin() { return login; }
	 
	 public void setLogin(String login) { this.login = login; }

	 public String getSenha() { return senha; }
	 
	 public void setSenha(String senha) { this.senha = senha; }
	 
	 public String getEmail() { return email; }

	 public void setEmail(String email) { this.email = email; }

	 public String getNome() { return nome; }

	 public void setNome(String nome) { this.nome = nome; }
		
	}
