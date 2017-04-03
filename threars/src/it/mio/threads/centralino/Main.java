package it.mio.threads.centralino;

import java.util.Date;

public class Main {


	public static void main(String[] args) throws InterruptedException {

		
		//initializzazione dei 100 clienti
		Cliente[] clienti = new Cliente[100];
		for(int i =0; i< 100; i++) {
			clienti[i] = new Cliente(i);
		}
		
		Pool pool = new Pool(5);
		
		Date t0 = new Date();
		for(Cliente c : clienti)  {
			pool.serve(c);
			System.out.println("Cliente " + c + " associato ad un operatore.");
		}
		Date t1 = new Date();
		
		System.out.println((t1.getTime() - t0.getTime()) + "ms");
		
		

	} 
}
