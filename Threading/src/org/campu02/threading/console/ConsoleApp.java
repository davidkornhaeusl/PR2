package org.campu02.threading.console;

import java.util.Scanner;

public class ConsoleApp {

	public static void main(String[] args) throws InterruptedException {

		BackgroundWorker bw = new BackgroundWorker();
		Thread th = new Thread(bw);
		th.start();
		
		System.out.println("press ENTER");
		Scanner scanner = new Scanner(System.in); 
		scanner.nextLine();
		
		System.out.println("finished");
		//th.stop(); // Stop funktioniert, aber nicht schön!
		bw.stopWorker();
		System.out.println("stopped");

		th.join();
		scanner.close();
	}
	
}
