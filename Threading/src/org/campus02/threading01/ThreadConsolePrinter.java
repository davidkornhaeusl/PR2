package org.campus02.threading01;

public class ThreadConsolePrinter extends Thread {

	private char identifier;
	public ThreadConsolePrinter(char c)
	{
		identifier = c;
	}
	
	public void run()
	{
		logic();
	}
	
	public void logic()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println(i + " [ identifier: " 
						+ identifier + "]");
		
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
