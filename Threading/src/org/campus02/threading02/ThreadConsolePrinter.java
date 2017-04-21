package org.campus02.threading02;

public class ThreadConsolePrinter 
	implements Runnable {

	private char identifier;
	public ThreadConsolePrinter(char c)
	{
		identifier = c;
	}
	
	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println(i + " [ identifier: " + identifier + "]");
		
			try {
				
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
