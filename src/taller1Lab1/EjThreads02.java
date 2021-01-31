package taller1Lab1;

public class EjThreads02 implements Runnable{

	
	public static void main(String[] args) {
		Thread t = new Thread(new EjThreads02());
		t.start();

	}

	@Override
	public void run() {
		System.out.println("Implementando la interfaz Runnable");
		
	}

}
