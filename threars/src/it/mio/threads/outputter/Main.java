package it.mio.threads.outputter;

public class Main {

	

	private static Outputter out = new Outputter() {

		@Override
		public void println(String s) {
			System.out.println(s);
		}
	};


	public static void main(String[] args) throws InterruptedException {
		
		CountingOutputterIntelligente outi = new CountingOutputterIntelligente(out);

		//costruire 2 Mythread
		MyThread myt = new MyThread("Thread1", 100, outi);
		MyThread myt2 = new MyThread("Thread2", 100, outi);


		Thread t = new Thread(myt);
		Thread t2 = new Thread(myt2);

		t.start();
		t2.start();


		t.join();
		t2.join();

		outi.flush();

	} 
}
