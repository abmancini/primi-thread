package it.mio.threads.centralino;


public class Operatore implements Runnable {

	private Cliente c;
	private Pool pool;

	public Operatore(Cliente c, Pool pool) {
		this.c = c;
		this.pool = pool;
	}

	@Override
	public void run() {
		//qualcosa
		try {
			System.out.println("Serving: " + c);
			Thread.sleep(1000);
			System.out.println("Served: " + c);
			pool.decrementaOperatoriOccupati();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
