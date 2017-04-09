package org.campus02.threading02;

public class Threading02App {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadConsolePrinter tcpA = new ThreadConsolePrinter('A');
		ThreadConsolePrinter tcpB = new ThreadConsolePrinter('B');
		
		Thread threadA = new Thread(tcpA); // Thread-Objekt mit Runnable erstellen
		Thread threadB = new Thread(tcpB);
		
		threadA.start(); // Den Thread starten
		threadB.start(); // Den Thread starten
		
		threadA.join(); // Auf das Ende des Threads warten
		threadB.join(); // Auf das Ende des Threads warten

	}

}
