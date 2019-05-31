package hostpet.model;

import hostpet.enums.Porte;
import hostpet.enums.Sexo;
import hostpet.enums.Tipo;

public class Pet {

	private int id;
	private String nome;
	private Integer idade;
	private String temperamento;
	private Sexo sexo;
	private Tipo tipo;
	private Porte porte;
	private String descricao;
	private String bairro;
	private Usuario doador;
	private Usuario adotante;

	public Pet(String nome, Integer idade, String temperamento, Sexo sexo, Porte porte, String descricao, String bairro, Usuario doador, Tipo tipo) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.temperamento = temperamento;
		this.sexo = sexo;
		this.porte = porte;
		this.descricao = descricao;
		this.bairro = bairro;
		this.doador = doador;
		this.tipo = tipo;
	}

	
	
	public Tipo getTipo() {
		return tipo;
	}



	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getTemperamento() {
		return temperamento;
	}

	public void setTemperamento(String temperamento) {
		this.temperamento = temperamento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Porte getPorte() {
		return porte;
	}

	public void setPorte(Porte porte) {
		this.porte = porte;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Usuario getAdotante() {
		return adotante;
	}

	public void setAdotante(Usuario adotante) {
		this.adotante = adotante;
	}

}
