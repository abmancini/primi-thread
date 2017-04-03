package it.mio.threads.centralino;

public class Cliente {
	int num;
	
	public Cliente(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "Cliente numero: " + num;
	}
	
}