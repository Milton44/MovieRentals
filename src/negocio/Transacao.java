package negocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.*;

public class Transacao {

	protected  ArrayList<Locacao> alugueis;
	
	public Transacao() {
		
		alugueis= new ArrayList<Locacao>();
	}
	
	public double valorLocacaoTotal() {
	    double valor=0;
		for (Locacao locacao : alugueis) {
			valor +=locacao.filme.valor;
		}
		return valor;
	}
	
	public Genero generosMaisAlugados(){
		
		Map<Genero, Integer> map = new HashMap<Genero, Integer>();
		for(Genero gender : Arrays.asList(Genero.values())) {	
			map.put(gender, 0);
			for(Locacao aluguel : alugueis) {
				
				if(aluguel.filme.genero == gender)
					map.put(gender,map.get(gender)+1);
			}
		}
		
		Genero generMaisAlugadoValor = Genero.NONE;
		for(Entry<Genero, Integer> entry : map.entrySet()) {
			if(map.containsKey(generMaisAlugadoValor)) {		
				if(map.get(entry.getKey())> map.get(generMaisAlugadoValor))
					generMaisAlugadoValor = entry.getKey();
				
			}else {
				generMaisAlugadoValor = entry.getKey();
			}
		}
		return generMaisAlugadoValor;
		
	}
}
