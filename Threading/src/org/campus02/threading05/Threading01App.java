package org.campus02.threading05;

public class Threading01App {

	public static void main(String[] args) throws InterruptedException {

		// Thread-Objekte erstellen
		ThreadConsolePrinter tcpA = new ThreadConsolePrinter('A');
		ThreadConsolePrinter tcpB = new ThreadConsolePrinter('B');
		
		// Threads starten
		tcpA.start();
		tcpB.start();
		
		Thread.sleep(3000);
		tcpA.interrupt();
		
		Thread.sleep(3000);
		tcpB.interrupt();
		
		// Auf Ende der Ausführung warten
		tcpA.join();
		tcpB.join();

	}

}
