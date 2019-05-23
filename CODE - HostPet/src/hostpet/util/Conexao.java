package hostpet.util;

import java.sql.*;

public class Conexao {
	
	private String url;
	private String usuario;
	private String senha;
	private Connection conex;
	private static Conexao conexao;
	
	Conexao(){
		url = "jdbc:postgresql://localhost:5432/hostpet";
		usuario = "postgres";
		senha = "995943";
		
		try {
			Class.forName("org.postgresql.Driver");
			conex = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão Realizada com Seucesso!!!");
		} catch (Exception e) {
			System.out.println("Erro ao conectar com o banco: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	

	public Connection getConnection() {
		return conex;
	}
	
	public static  Conexao getConexao() {
		if(conexao == null) {
			conexao = new Conexao();
		}
		return conexao;
	}
	
	
	public void closeConnection() {
		try {
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
