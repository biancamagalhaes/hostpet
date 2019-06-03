package hostpet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hostpet.enums.Porte;
import hostpet.enums.Sexo;
import hostpet.model.Pet;
import hostpet.model.Usuario;
import hostpet.util.Conexao;

public class PetDAO {

	private Conexao conexao;

	
	public PetDAO() {
		this.conexao = Conexao.getConexao();
		System.out.println(conexao.toString());
		//List<Usuario> listaPet = listar();
		//System.out.println(listaPet.toString());
	}
	
	public List<Pet> filtro(Pet pet, Usuario usuario) {
		PreparedStatement stmt;
		List<Pet> pets = new ArrayList<>();
		try {
			
			stmt = conexao.getConnection().prepareStatement("select pet.nome as nomePet, pet.foto as fotoPet, id_pet from pet,usuario where tipo=? and usuario.cidade=? and porte=?;");
			stmt.setString(1, pet.getTipo().toString());
			stmt.setString(2, usuario.getCidade());
			stmt.setString(3, pet.getPorte().toString());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Pet p = new Pet();
				pet.setNome(rs.getString("nomePet"));
				pet.setFoto(rs.getString("fotoPet"));
				pet.setId(rs.getInt("id_pet"));
				
				pets.add(pet);
			}
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pets;
		
	}
	
	public Pet sobre(int id) {
		System.out.println("cheguei to feliz");
			PreparedStatement stmt;
			Pet pet = null;
			try {
				
				stmt = conexao.getConnection().prepareStatement("select idade, pet.nome, sexo, porte, temperamento, bairro, pet.foto, descricao, id_usuariod, usuario.estado, usuario.cidade, usuario.nome as nomeDono, usuario.foto as fotoDono from pet,usuario where id_pet=?;");
				stmt.setInt(1, id);
				ResultSet rs = stmt.executeQuery();
				if(rs.next()) {
					pet = new Pet();
					Usuario usuario = new Usuario();
					Sexo sexo = null;
					Porte porte = null;
					pet.setNome(rs.getString("nome"));
					pet.setIdade(rs.getInt("idade"));
					if(rs.getString("sexo") == sexo.MACHO.toString()) {
						pet.setSexo(sexo.MACHO);
					}else {
						pet.setSexo(sexo.FEMEA);
					}
					if(rs.getString("porte") == porte.GRANDE.toString()) {
						pet.setPorte(porte.GRANDE);
					}else if(rs.getString("porte") == porte.MEDIO.toString()){
						pet.setPorte(porte.MEDIO);
					}else {
						pet.setPorte(porte.PEQUENO);
					}
					pet.setTemperamento(rs.getString("temperamento"));
					pet.setBairro(rs.getString("bairro"));
					pet.setDescricao(rs.getString("descricao"));
					pet.setFoto(rs.getString("foto"));
					
					usuario.setEstado(rs.getString("estado"));
					usuario.setCidade(rs.getString("cidade"));
					usuario.setNome(rs.getString("nomeDono"));
					usuario.setFoto(rs.getString("fotoDono"));
					usuario.setId(rs.getInt("id_usuariod"));
					
					pet.setDoador(usuario);
				}
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return pet;
		}
	
	public List<Pet> listarAdote() {
		Statement stmt;
		List<Pet> pets = new ArrayList<>();
		
		try {
			
			stmt = conexao.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery("select nome,foto,id_pet from pet;");
			while(rs.next()) {
				
				Pet p = new Pet();
				p.setNome(rs.getString("nome"));
				p.setFoto(rs.getString("foto"));
				p.setId(rs.getInt("id_pet"));
				
				pets.add(p);
			
			}
			
			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pets;
	}

	public void inserir(Pet pet) {
		UsuarioDAO dao = new UsuarioDAO();
		try {
				PreparedStatement ps = conexao.getConnection()
						.prepareStatement("insert into pet (nome, idade, temperamento, sexo, porte, descricao, " + 
				"bairro, id_usuariod, tipo, foto) values (?,?,?,?,?,?,?,?,?,?);");
				
				ps.setString(1, pet.getNome());
				ps.setInt(2, pet.getIdade());
				ps.setString(3, pet.getTemperamento());
				ps.setString(4, pet.getSexo().toString());
				ps.setString(5, pet.getPorte().toString());
				ps.setString(6, pet.getDescricao());
				ps.setString(7, pet.getBairro());
				ps.setInt(8, dao.id(pet.getDoador()));
				ps.setString(9, pet.getTipo().toString());
				ps.setString(10, pet.getFoto());
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