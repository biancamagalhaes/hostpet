//package hostpet.dao;
//
//import java.util.List;
//import java.util.Properties;
//import javax.mail.Address;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import hostpet.model.Usuario;
//
//public class RecuperarSenhaDAO {
//
//	public RecuperarSenhaDAO() {
//	
//	}
//	
//	public String email(String login) {
//    UsuarioDAO u = new UsuarioDAO();	
//	List<Usuario> usuarios = u.login();
//	String page = "erro.jsp";	
//		for (Usuario usuario2 : usuarios) {
//			if(usuario2.getLogin().equals(login)) {
//				Properties props = new Properties();
//			    /** Parâmetros de conexão com servidor Gmail */
//			    props.put("mail.smtp.host", "smtp.gmail.com");
//			    props.put("mail.smtp.socketFactory.port", "465");
//			    props.put("mail.smtp.socketFactory.class", 
//			    "javax.net.ssl.SSLSocketFactory");
//			    props.put("mail.smtp.auth", "true");
//			    props.put("mail.smtp.port", "465");
//			 
//			    Session session = Session.getDefaultInstance(props,
//			      new javax.mail.Authenticator() {
//			           protected PasswordAuthentication getPasswordAuthentication() 
//			           {
//			                 return new PasswordAuthentication("hostpetsistema@gmail.com", 
//			                 "hostpet123");
//			           }
//			      });
//			 
//			    /** Ativa Debug para sessão */
//			    session.setDebug(true);
//			 
//			    try {
//			 
//			      Message message = new MimeMessage(session);
//			      message.setFrom(new InternetAddress("hostpetsistema@gmail.com")); 
//			      //Remetente
//			 
//			      Address[] toUser = InternetAddress //Destinatário(s)
//			                 .parse(usuario2.getEmail());  
//			 
//			      message.setRecipients(Message.RecipientType.TO, toUser);
//			      message.setSubject("Recuperar Senha");//Assunto
//			      message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
//			      /**Método para enviar a mensagem criada*/
//			      Transport.send(message);
//			      page = "index.jsp";
//			      System.out.println("Feito!!!");
//			 
//			     } catch (MessagingException e) {
//			        throw new RuntimeException(e);
//			    }
//			  
//			}
//	
//		}
//		return page;
//	}
//}
