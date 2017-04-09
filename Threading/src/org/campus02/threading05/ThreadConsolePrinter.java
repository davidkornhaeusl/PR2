package org.campus02.threading05;

public class ThreadConsolePrinter extends Thread {

	private char identifier;
	public ThreadConsolePrinter(char c)
	{
		identifier = c;
	}
	
	@Override
	public void run() {
		int i = 0;
		while(!Thread.currentThread().isInterrupted()) {
			i++;
			System.out.println(i + " [ identifier: " + identifier + "]");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				System.out.println(identifier + " Interrupted during sleep");
				Thread.currentThread().interrupt();
			}
		}
		System.out.println(identifier + " finished");
	}
}
