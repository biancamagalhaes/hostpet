package hostpet.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import hostpet.model.Pet;
import hostpet.util.Conexao;

public class PetDAO {

	private Conexao conexao;

	
	public PetDAO() {
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

	public void inserir(Pet pet) {
		try {
				PreparedStatement ps = conexao.getConnection()
						.prepareStatement("insert into usuario (nome, idade, temperamento, sexo, porte, descricao, " + 
				"bairro) values (?,?,?,?,?,?,?);");
				
				ps.setString(1, pet.getNome());
				ps.setInt(2, pet.getIdade());
				ps.setString(3, pet.getTemperamento());
				ps.setString(4, pet.getSexo().toString());
				ps.setString(5, pet.getPorte().toString());
				ps.setString(6, pet.getDescricao());
				ps.setString(7, pet.getBairro());
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