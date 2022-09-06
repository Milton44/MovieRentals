package negocio;

import java.util.Date;

public class Locacao {

	protected Cliente cliente;
	protected Filme filme;
	protected double valorAluguel;
	protected Date date;
	
	public void alugar(Cliente c, Filme f, Date date) {
		this.cliente = c;
		this.filme = f;
		this.date = date;
	}
	public void setValorAluguel(double valorAluguel) {
		this.valorAluguel=valorAluguel;
	}
}
