package hostpet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import hostpet.model.Pet;
import hostpet.model.Usuario;
import hostpet.util.Conexao;

public class RecuperarSenhaDAO {

private Conexao conexao;
	
	public RecuperarSenhaDAO() {
		this.conexao = Conexao.getConexao();
		System.out.println(conexao.toString());
	}
	
	public Usuario verificar(String email) {
		PreparedStatement stmt;
		Usuario usuario = null;
		try {
			
			stmt = conexao.getConnection().prepareStatement("select nome from usuario where email=?;");
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
	}
	
	public String emailDoador(String email, Usuario user) {
	    UsuarioDAO u = new UsuarioDAO();	
		List<Usuario> usuarios = u.usuarios();
		String page = "erro.jsp";	
					Properties props = new Properties();
				    /** Parâmetros de conexão com servidor Gmail */
				    props.put("mail.smtp.host", "smtp.gmail.com");
				    props.put("mail.smtp.socketFactory.port", "465");
				    props.put("mail.smtp.socketFactory.class", 
				    "javax.net.ssl.SSLSocketFactory");
				    props.put("mail.smtp.auth", "true");
				    props.put("mail.smtp.port", "465");
				 
				    Session session = Session.getDefaultInstance(props,
				      new javax.mail.Authenticator() {
				           protected PasswordAuthentication getPasswordAuthentication() 
				           {
				                 return new PasswordAuthentication("hostpetsistema@gmail.com", 
				                 "hostpet123");
				           }
				      });
				 
				    /** Ativa Debug para sessão */
				    session.setDebug(true);
				 
				    try {
				 
				      Message message = new MimeMessage(session);
				      message.setFrom(new InternetAddress("hostpetsistema@gmail.com")); 
				      //Remetente
				 
				      Address[] toUser = InternetAddress  //Destinatário(s)
				              .parse(email);  
				 
				      message.setRecipients(Message.RecipientType.TO, toUser);
				      message.setSubject("Dados de " + user.getNome());//Assunto
				      if(user.getTelefone() == null) {
				    	  message.setText("Este usuario não disponibilizou telefone porém o seu email é " + user.getEmail());
				      }else {
				    	  message.setText("Os dados deste usuario são email: " + user.getEmail() + "e telefone: " + user.getTelefone());
				      }
				      /**Método para enviar a mensagem criada*/
				      Transport.send(message);
				      page = "index.jsp";
				      System.out.println("Feito!!!");
				 
				     } catch (MessagingException e) {
				        throw new RuntimeException(e);
				    }
				  
			return page;
		}
	
	public String email(String email, String senha) {
    UsuarioDAO u = new UsuarioDAO();	
	List<Usuario> usuarios = u.usuarios();
	String page = "erro.jsp";	
		for (Usuario usuario2 : usuarios) {
			if(usuario2.getEmail().equals(email)) {
				Properties props = new Properties();
			    /** Parâmetros de conexão com servidor Gmail */
			    props.put("mail.smtp.host", "smtp.gmail.com");
			    props.put("mail.smtp.socketFactory.port", "465");
			    props.put("mail.smtp.socketFactory.class", 
			    "javax.net.ssl.SSLSocketFactory");
			    props.put("mail.smtp.auth", "true");
			    props.put("mail.smtp.port", "465");
			 
			    Session session = Session.getDefaultInstance(props,
			      new javax.mail.Authenticator() {
			           protected PasswordAuthentication getPasswordAuthentication() 
			           {
			                 return new PasswordAuthentication("hostpetsistema@gmail.com", 
			                 "hostpet123");
			           }
			      });
			 
			    /** Ativa Debug para sessão */
			    session.setDebug(true);
			 
			    try {
			 
			      Message message = new MimeMessage(session);
			      message.setFrom(new InternetAddress("hostpetsistema@gmail.com")); 
			     // Remetente
			 
			      Address[] toUser = InternetAddress  //Destinatário(s)
			                 .parse(usuario2.getEmail());  
			 
			      message.setRecipients(Message.RecipientType.TO, toUser);
			      message.setSubject("Recuperar Senha");//Assunto
			      //message.setText("Sua nova senha é" + senha);
			      /**Método para enviar a mensagem criada*/
			      Transport.send(message);
			      page = "index.jsp";
			      System.out.println("Feito!!!");
			 
			     } catch (MessagingException e) {
			        throw new RuntimeException(e);
			    }
			  
			}
	
		}
		return page;
	}
}
