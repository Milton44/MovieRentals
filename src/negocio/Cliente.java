package negocio;

public class Cliente {

	protected String nome;
	protected int id;
	protected boolean ativo;
	
	public Cliente(String nome, int id) {
		this.nome= nome;
		this.id= id;
		this.ativo = true;
	}
	
	public Cliente(String nome, int id, boolean ativo) {
		this.nome= nome;
		this.id= id;
		this.ativo = ativo;
	}
}
