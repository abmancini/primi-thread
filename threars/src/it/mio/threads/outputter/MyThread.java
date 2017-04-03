package it.mio.threads.outputter;

/*
 * 
 */
public class MyThread implements Runnable {

	private String name;
	private int num;
	private Outputter out;

	public MyThread(String name, int num, Outputter out) {
		this.name = name;
		this.num = num;
		this.out = out;
	}

	@Override
	public void run() {
		for(int i =0 ; i < num; i++) 
			out.println(name);		
	}
	
}
