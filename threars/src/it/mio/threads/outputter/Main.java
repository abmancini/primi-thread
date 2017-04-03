package it.mio.threads.outputter;

import java.util.ArrayList;
import java.util.List;

public class Main {

	private static Outputter out = new Outputter() {
		@Override
		public void println(String s) {
			System.out.println(s);
		}
	};


	public static void main(String[] args) throws InterruptedException {
		
		CountingOutputterMoltoIntelligente outi = new CountingOutputterMoltoIntelligente(out);

		
		List<MyThread> mts = new ArrayList<MyThread>();
	
		
		//costruire N Mythread
		for(int i =0; i< 3; i++ ) {
			MyThread myt = new MyThread("Thread"+i, 100, outi);
			mts.add(myt);
		}
			
					
		List<Thread> ts = new ArrayList<>();
		for(MyThread mt : mts) {
			Thread t = new Thread(mt);
			ts.add(t);
		}

		for(Thread t : ts) {
			t.start();
		}
		

		for(Thread t : ts) {
			t.join();
		}

		outi.flush();

	} 
}
