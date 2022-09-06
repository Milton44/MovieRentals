package negocio;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void valorLocacaoTotalTest() throws ParseException {
		Locacao locacao1 = new Locacao();
		Locacao locacao2 = new Locacao();
		
		Filme f = new Filme("Java", Genero.ROMANCE);
		f.valor = 100;

		Filme f2 = new Filme("JavaScript", Genero.ROMANCE);
		f2.valor = 50;

		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("05/09/2022");
		locacao1.alugar(new Cliente("Izaias", 2), f, date1);
		
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("02/09/2022");
		locacao2.alugar(new Cliente("Izaias", 2, false), f2, date2);

		transacao.alugueis.add(locacao1);
		transacao.alugueis.add(locacao2);
		
		assertTrue(150 == transacao.valorLocacaoTotal());
		assertTrue(locacao1.date == date1);
		assertTrue(locacao2.date == date2);
		assertTrue(!locacao2.cliente.ativo);
		assertTrue(locacao1.cliente.ativo);
	}

}
