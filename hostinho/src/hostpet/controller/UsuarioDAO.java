package hostpet.controller;

import java.math.BigInteger;
import java.security.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import hostpet.enums.Perfil;
import hostpet.model.Usuario;

public class UsuarioDAO {

 private List<Usuario> usuarios = new ArrayList<>();

 public UsuarioDAO() throws ParseException {
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

 private void load() throws ParseException {
  String cripto = md5("12345");
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  Date date = sdf.parse( "2009-12-31" );
  try {
	//usuarios.add(new Usuario("bianca.santos", cripto, "bianca.santos@ucsal.edu.br", "Bianca", "Salvador", "Bahia", "71 9 99594330", "05445097579", date, Perfil.ADMIN));
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 }
	
 public List<Usuario> getAll() {
  return usuarios;
 }
}
