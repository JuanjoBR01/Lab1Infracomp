package taller1Lab1;

import java.util.Scanner;

public class EjercicioThread extends Thread{

	private int inicio;
	private int limSuperior;
	private int miliseg;

	public EjercicioThread(int inicio, int limSuperior, int miliSeg) {
		this.inicio=inicio;
		this.limSuperior=limSuperior;
		this.miliseg= miliSeg;
	}


	public void run() {

		try {
			for (int i = inicio;i<=limSuperior;i+=2) {

				Thread.sleep(miliseg);
				System.out.println(i);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	public static void main(String[] args) {

		Scanner lector = new Scanner (System.in); 

		System.out.println("Seleccione límite superior");
		int numerito = lector.nextInt();

		Thread impares = new EjercicioThread(1, numerito, 10);
		Thread pares = new EjercicioThread(2, numerito, 10);

		pares.start();
		impares.start();
	}

}
