package it.mio.threads.outputter;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyThreadTest {

	@Test
	public void testEffettivamenteStampaIlSuoNome() {
		//voglio verificare che MtYrread 'stampi' il suo nome
		String NOME = "nome";
		//costruire un mythread
		MyThread myt = new MyThread(NOME, 20, 
				new Outputter() {		
					@Override
					public void println(String s) {
						//verificare che 'stampi' il parametro che gli ho passato 
						//nel costruttore
						if(! NOME.equals(s)) 
							fail("Unexpected Result: " + s + " != " + NOME);
					}
				});
		//eseguire run
		myt.run();
		assertTrue(true);	
	}

	public class CountingOutputter implements Outputter {
		int count = 0;
		@Override
		public void println(String s) {
			count++;
		}
		public int getCount() {
			return count;
		}
	}
	@Test
	public void testEffettivamenteStampaIlNumeroGiustoDiVolte() {
		int num = 17;
		CountingOutputter cout = new CountingOutputter();
		//costruire un mythread
		MyThread myt = new MyThread("XXX", num, cout);
		//eseguire run
		myt.run();
		assertTrue(cout.getCount() == num);	
	}
}
