package taller2Lab1;

public class ContadorThreads extends Thread{
	//Variable de la clase. Todos los objetos ven esta variable
	private static int contador = 0;

	public synchronized void run() {
		for (int i = 0;i<10000;i++) {
			aumentar();
		}
	}

	public synchronized void aumentar() {
		contador ++;

	}

	public static void main(String[] args) {

		ContadorThreads [] t = new ContadorThreads[1000];

		for (int i=0;i<t.length;i++) {
			t[i] = new ContadorThreads();
			t[i].start();
		}

		try {
			Thread.sleep(1000);
		} catch(Exception e) {
			e.printStackTrace();
		}

		System.out.println(contador);

	}

}
