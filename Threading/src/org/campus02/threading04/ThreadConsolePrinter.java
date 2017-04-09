package org.campus02.threading04;

public class ThreadConsolePrinter extends Thread {

	private char identifier;
	
	public ThreadConsolePrinter(char c)
	{
		identifier = c;
	}
	
	


	@Override
	public void run()
	{
		for (int i = 0; i < 1000; i++)
		{
			System.out.println(i + " [ identifier: " + identifier + "]");
			
			if (isStopped)
				break;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



	private boolean isStopped = false;
	public void setStopped(boolean b) {
		
		isStopped = b;
		
	}
}
