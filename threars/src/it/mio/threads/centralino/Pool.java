package it.mio.threads.centralino;

//manages a pool of threads (threads are created and destroyed, can be optimized)
public class Pool {


	int currentltRunningThreads = 0;
	int MAX;

	public Pool(int max) {
		this.MAX = max;
	}
	public synchronized void incrementaOperatoriOccupati() {
		currentltRunningThreads ++;
	}
	public synchronized void decrementaOperatoriOccupati() {
		currentltRunningThreads--;
		notify();
	}
	
	public synchronized void serve(Cliente c) throws InterruptedException {
		if(currentltRunningThreads >= MAX) 
			wait();
		
		incrementaOperatoriOccupati();
		Operatore o= new Operatore(c,this);
		Thread to = new Thread(o); 
		to.start();
	}


}
