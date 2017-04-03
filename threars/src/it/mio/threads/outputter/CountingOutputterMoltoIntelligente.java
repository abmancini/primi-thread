package it.mio.threads.outputter;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CountingOutputterMoltoIntelligente implements Outputter {
	
	
	public static class Misura {
		int numero;
		long ms;
		
		public Misura(int numero, long ms) {
			this.numero = numero;
			this.ms = ms;
		}
	}
	
	private Map<String,List<Misura>> viste = new HashMap<>();
	
 	private String ultimo =""; 
	private long ultima_timestamp =0;

	private Outputter delegate;
	public CountingOutputterMoltoIntelligente(Outputter delegate) {
		this.delegate = delegate;
	}
	
	
	@Override
	public synchronized void println(String s) {	
		
		if(ultimo.equals(s)) {
			//incrementiamo valore corrente nella mappa corrispondente
			List<Misura> list = viste.get(s);
			int pos = list.size() -1;
			Misura e = list.get( pos );
			e.numero++;
			e.ms = (new Date()).getTime() - ultima_timestamp;
			//list.set(pos, e +1);
			//numero++;
		} else {
			//e' diverso dall'ultimo
			ultima_timestamp = (new Date()).getTime();
			List<Misura> list = viste.get(s);
			if(list == null) { //e' il primo con questo nome
				list = new ArrayList<>();
				list.add( new Misura(1,0) );
				viste.put(s, list);
			} else {
				list.add( new Misura(1,0) );
			}

			ultimo=s;
		}
		
		
		delegate.println(s);
	}
	
	public void flush() {
		System.out.println("Closing");		
		System.out.println("---------------------------");
		
		for(  Entry<String, List<Misura>> e: viste.entrySet()) {
			int sum = 0;
			System.out.println(e.getKey() + " eseguito in " + e.getValue().size() + " blocchi");
			for( Misura m : e.getValue()) {
				int f = m.numero;
				long ms = m.ms;
				System.out.println(e.getKey() + ": " + f + " volte (" + ms+ "ms)" );
				sum+= f;
			}
			System.out.println(e.getKey() + ": totale " + sum + " volte");
			
		}
		
		System.out.println("---------------------------");
		
		
	}
	
}
