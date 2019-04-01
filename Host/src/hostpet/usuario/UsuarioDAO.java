package hostpet.usuario;

import java.math.BigInteger;
import java.security.*;
import java.util.*;

public class UsuarioDAO {

 private List<Usuario> usuarios = new ArrayList<>();

 public UsuarioDAO() {
   load();
 }

 public String md5(String text) {
  MessageDigest m = null;
  try {
   m = MessageDigest.getInstance("MD5");
   m.update(text.getBytes(),0,text.length());
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }catch (NullPointerException e){
	e.printStackTrace();
  }
  return ""+new BigInteger(1,m.digest()).toString(16);
 }

 private void load() {
  String cripto = md5("12345");
  usuarios.add(new Usuario("bianca.santos@ucsal.edu.br", cripto, "bianca.santos@ucsal.edu.br", "Bianca"));
 }
	
 public List<Usuario> getAll() {
  return usuarios;
 }
}
