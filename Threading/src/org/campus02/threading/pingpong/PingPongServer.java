package org.campus02.threading.pingpong;

import java.util.Scanner;

import org.campu02.threading.console.BackgroundWorker;

public class PingPongServer {

	public static void main(String[] args) {
		
		BackgroundServer bw = new BackgroundServer();
		Thread th = new Thread(bw);
		th.start();
		

		System.out.println("press ENTER");
		Scanner scanner = new Scanner(System.in); 
		
		String input;
		
		while (!(input=scanner.nextLine()).equals("exit"))
		{
			
		}
		
		System.out.println("finished");

		bw.stopWorker();
		System.out.println("stopped");

		try {
			th.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		scanner.close();
		
	}

	
}