package it.mio.threads.outputter;

public class CountingOutputterIntelligente implements Outputter {
	
 	private String ultimo =""; 
	private int numero =0;
	private Outputter delegate;
	
	public CountingOutputterIntelligente(Outputter delegate) {
		this.delegate = delegate;
	}
	
	
	@Override
	public synchronized void println(String s) {		
		if(ultimo.equals(s)) {
			numero++;
		} else {
			if(numero > 0)
				System.out.println("visto " + numero + " volte " + ultimo);
			System.out.println("iniziamo con: " + s );
			ultimo=s;
			numero=1;
		}
		
		delegate.println(s);
	}
	
	public void flush() {
		System.out.println("visto " + numero + " volte " + ultimo);
		System.out.println("Closing");
		ultimo = "";
	}
	
}
