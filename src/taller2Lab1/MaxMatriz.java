package taller2Lab1;

import java.util.concurrent.ThreadLocalRandom;

public class MaxMatriz extends Thread{
	
	private final static int INT_MAX = 105345;
	
	private final static int DIM = 3;
	
	private static int [][] matriz = new int [DIM][DIM];
	
	private static int mayor = -1;
	
	private int mayorFila = -1;
	
	private int idThread;
	
	private int fila;
	
	public MaxMatriz(int idThread, int fila) {
		this.idThread=idThread;
		this.fila=fila;
	}
	
	//Se genera la matriz con los números aleatorios:
	
	public static void crearMatriz() {
		for (int i=0;i<DIM;i++) {
			for (int j=0;j<DIM;j++) {
				matriz [i][j]=ThreadLocalRandom.current().nextInt(0,INT_MAX);
			}
		}
		
		//Imprimir la matriz
		System.out.println("Matriz: ");
		System.out.println("=========================");
		imprimirMatriz();
	}
	
	private static void imprimirMatriz() {
		for(int i=0;i<DIM;i++) {
			for(int j=0;j<DIM;j++) {
				System.out.println(matriz[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public void run() {
		for (int j=0;j<DIM;j++) {
			if(this.mayorFila < matriz[this.fila][j])
				this.mayorFila = matriz[this.fila][j];
		}
		
		if(this.mayorFila>mayor) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			mayor = this.mayorFila;
			
			String warn = String.format(
					"===================Nuevo Máximo Encontrado===================\n" +
					"ID Thread: %d - Máximo Local Actual: %d - Máximo global: %d \n" +
					"\n", 
					this.idThread,
					mayor,
					this.mayorFila);
			
			System.out.println(warn);
		}
		
		//Resultados
		String msg = String .format("ID Thread: %d - Máximo local: %d - Máximo Global: %d", 
				this.idThread,
				this.mayorFila,
				mayor);
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		System.out.println("Búsqueda concurrente por una matriz");
		
		//Iniciar la matriz
		MaxMatriz.crearMatriz();
		System.out.println();
		System.out.println("Iniciando búsqueda");
		
		//Iniciar búsqueda
		MaxMatriz[] bThreads = new MaxMatriz[DIM];
		for (int i = 0;i<DIM;i++) {
			bThreads[i] = new MaxMatriz(i, i);
			bThreads[i].start();
		}

	}

}
