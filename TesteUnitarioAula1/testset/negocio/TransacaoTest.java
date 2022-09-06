package negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import negocio.Cliente;
import negocio.Filme;
import negocio.Genero;
import negocio.Locacao;
import negocio.Transacao;

public class TransacaoTest {

	Transacao transacao;

	@Before
	public void setUp() throws Exception {
		transacao = new Transacao();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void valorLocacaoTotalTest() {
		Locacao locacao = new Locacao();
		Filme f = new Filme("Java", Genero.ROMANCE);
		f.valor = 100;

		Filme f2 = new Filme("JavaScript", Genero.ROMANCE);
		f2.valor = 50;

		
		locacao.alugar(new Cliente("Izaias", 2), f);
		locacao.alugar(new Cliente("Izaias", 2), f2);

		transacao.alugueis.add(locacao);
		assertTrue(150 == transacao.valorLocacaoTotal());
	}

}
