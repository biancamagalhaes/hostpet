package hostpet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hostpet.model.Ong;
import hostpet.model.Usuario;
import hostpet.util.Conexao;

public class OngDAO {

	private Conexao conexao;

	
	public OngDAO() {
		this.conexao = Conexao.getConexao();
		System.out.println(conexao.toString());
		//List<Usuario> listaPet = listar();
		//System.out.println(listaPet.toString());
	}

//	public List<Usuario> listar() {
//		Statement stmt;
//		List<Usuario> usuarios = new ArrayList<>();
//		
//		try {
//			
//			stmt = conexao.getConnection().createStatement();
//			ResultSet rs = stmt.executeQuery("select id_pet,id_usuarioa,id_usuariod,id_feedback,pet.nome,idade"
//					+ ",sexo,porte,temperamento,descricao, bairro, foto, id_usuario, id_ong, usuario.nome, email"
//					+ "cidade,estado, telefone, cpf, perfil, datanascimento, foto,ong.id_ong as idong, ong.nome as nomeong,"  
//		            + "ong.email as emailong, ong.cidade as cidadeong, ong.estado as estadong, cnpj, descricao" 
//					+ "from pet, usuario where id_usuarioa = id_usuario AND id_usuariod = id_usuario AND ong.id_ong = usuario.id_ong");
//			
//			while(rs.next()) {
//				
//				Ong o = new Ong();
//				o.setId(rs.getInt("idong"));
//				o.setNome(rs.getString("nomeong"));
//				o.setEmail(rs.getString("emailong"));
//				o.setCidade(rs.getString("cidadeong"));
//				o.setEstado(rs.getString("estadoong"));
//				o.setCnpj(rs.getString("cnpj"));
//				o.setDescricao(rs.getString("descricao"));
//				
//				Usuario a = new Usuario();
//				a.setId(rs.getInt("id_usuario"));
//				a.setNome(rs.getString("nome"));
//				a.setEmail(rs.getString("email"));
//				a.setCidade(rs.getString("cidade"));
//				a.setEstado(rs.getString("estado"));
//				a.setTelefone(rs.getString("telefone"));
//				a.setCpf(rs.getString("cpf"));
//				a.setNascimento(rs.getDate("datanascimento"));
//				a.setTipo(Perfil.values()[rs.getInt("perfil")]);
//				
//							
//				Usuario d = new Usuario();
//				d.setId(rs.getInt("id_usuario"));
//				d.setNome(rs.getString("nome"));
//				d.setEmail(rs.getString("email"));
//				d.setCidade(rs.getString("cidade"));
//				d.setEstado(rs.getString("estado"));
//				d.setTelefone(rs.getString("telefone"));
//				d.setCpf(rs.getString("cpf"));
//				d.setNascimento(rs.getDate("datanascimento"));
//				d.setTipo(Perfil.values()[rs.getInt("perfil")]);
//				a.setOng(o);
//				usuarios.add(u);
//			
//			}
//			
//			stmt.close();
//		
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	
//		return usuarios;
//	}
	
	public int id(Ong ong) {
		PreparedStatement stmt;
		try {
			
			stmt = conexao.getConnection().prepareStatement("select id_ong from ong where nome=?;");
			stmt.setString(1, ong.getNome());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				ong.setId(Integer.parseInt(rs.getString("id_ong")));
				int id = ong.getId();
				System.out.println("id:" + id);
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ong.getId();
	}

	public void inserir(Ong ong) {
		try {
				PreparedStatement ps = conexao.getConnection()
						.prepareStatement("insert into ong (nome, email, cidade, estado, cnpj, descricao) values (?,?,?,?,?,?);");
				
				ps.setString(1, ong.getNome());
				ps.setString(2, ong.getEmail());
				ps.setString(3, ong.getCidade());
				ps.setString(4, ong.getEstado());
				ps.setString(5, ong.getCnpj());
				ps.setString(6, ong.getDescricao());
				ps.execute();
				ps.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	public void close() {
		conexao.closeConnection();
	}
	
}
