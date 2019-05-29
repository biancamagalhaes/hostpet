package hostpet.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hostpet.enums.Perfil;
import hostpet.model.Ong;
import hostpet.model.Usuario;
import hostpet.util.Conexao;

public class UsuarioDAO {

	private Conexao conexao;

	
	//
	
	public UsuarioDAO() {
		this.conexao = Conexao.getConexao();
		System.out.println(conexao.toString());
		List<Usuario> listaUsuario = listar();
		System.out.println(listaUsuario.toString());
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
	
	public Usuario login(String login, String senha) {
		System.out.println("cheguei no dao");
		PreparedStatement stmt;
	    Usuario usuario  = null;
	    String senhaCript = md5(senha);
		System.out.println(senhaCript);
		try {
			
			stmt = conexao.getConnection().prepareStatement("select login,nome,email,cidade,estado,foto from usuario where login=? and senha=?;");
			stmt.setString(1, login);
			stmt.setString(2, senhaCript);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setEmail(rs.getString("email"));
				usuario.setCidade(rs.getString("cidade"));
				usuario.setEstado(rs.getString("estado"));
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("no dao ainda:" + usuario.getNome());
		return usuario;
	}

	public List<Usuario> listar() {
		Statement stmt;
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select id_usuario,usuario.id_ong,usuario.perfil,usuario.nome,usuario.email,usuario.cidade"
					+ ",usuario.estado,login,senha,telefone, cpf, datanascimento, ong.id_ong as idong, ong.nome as nomeong,"
					+ "ong.email as emailong, ong.cidade as cidadeong, ong.estado as estadong, cnpj, descricao " +
					"from usuario, ong where usuario.id_ong = ong.id_ong");
			
			while(rs.next()) {
			
				Ong o = new Ong();
				o.setId(rs.getInt("idong"));
				o.setNome(rs.getString("nomeong"));
				o.setEmail(rs.getString("emailong"));
				o.setCidade(rs.getString("cidadeong"));
				o.setEstado(rs.getString("estadoong"));
				o.setCnpj(rs.getString("cnpj"));
				o.setDescricao(rs.getString("descricao"));
								
				Usuario u = new Usuario();
				u.setId(rs.getInt("id_usuario"));
				u.setNome(rs.getString("nome"));
				u.setEmail(rs.getString("email"));
				u.setCidade(rs.getString("cidade"));
				u.setEstado(rs.getString("estado"));
				u.setLogin(rs.getString("login"));
				u.setSenha(rs.getString("senha"));
				u.setTelefone(rs.getString("telefone"));
				u.setCpf(rs.getString("cpf"));
				u.setNascimento(rs.getDate("datanascimento"));
				u.setTipo(Perfil.values()[rs.getInt("perfil")]);
				
				u.setOng(o);
				usuarios.add(u);
			
			}
			
			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return usuarios;
	}

	public void inserir(Usuario usuario) {
		if(usuario.getOng() == null) {
			System.out.println("inseri meu usuario");
			try {
				
				PreparedStatement ps = conexao.getConnection()
						.prepareStatement("insert into usuario (nome, email, cidade, estado, login, senha, " + 
				"telefone, cpf, datanascimento) values (?,?,?,?,?,?,?,?,?);");
				
				ps.setString(1, usuario.getNome());
				ps.setString(2, usuario.getEmail());
				ps.setString(3, usuario.getCidade());
				ps.setString(4, usuario.getEstado());
				ps.setString(5, usuario.getLogin());
				ps.setString(6, md5(usuario.getSenha()));
				ps.setString(7, usuario.getTelefone());
				ps.setString(8, usuario.getCpf());
				ps.setDate(9, (Date) usuario.getNascimento());
				ps.execute();
				ps.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}else {
		try {
			
			PreparedStatement ps = conexao.getConnection()
					.prepareStatement("insert into usuario (id_ong, nome,"
							+ "email, cidade, estado, login, senha, telefone, cpf, datanascimento) values (?,?,?,?,?,?,?,?,?,?);");
			
		
			ps.setInt(1, (usuario.getOng().getId()));
			ps.setString(2, usuario.getNome());
			ps.setString(3, usuario.getEmail());
			ps.setString(4, usuario.getCidade());
			ps.setString(5, usuario.getEstado());
			ps.setString(6, usuario.getLogin());
			ps.setString(7, usuario.getSenha());
			ps.setString(8, usuario.getTelefone());
			ps.setString(9, usuario.getCpf());
			ps.setDate(10, (Date) usuario.getNascimento());
			ps.execute();
			ps.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		}
		
		
	}
	
	public void close() {
		conexao.closeConnection();
	}


	
}