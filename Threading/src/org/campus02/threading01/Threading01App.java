package org.campus02.threading01;

public class Threading01App {

	public static void main(String[] args) throws InterruptedException {

		// Objekte erstellen
		ThreadConsolePrinter tcpA = 
				new ThreadConsolePrinter('A');
		ThreadConsolePrinter tcpB = 
				new ThreadConsolePrinter('B');
		
		// Klasse starten
		tcpA.start();
		tcpB.start();
		
		
			
		tcpA.join();
		tcpB.join();
		System.out.println("fertig - join");
	}

}
