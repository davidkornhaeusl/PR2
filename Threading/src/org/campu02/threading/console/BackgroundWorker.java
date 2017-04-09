package org.campu02.threading.console;

import java.util.Date;

public class BackgroundWorker implements Runnable {

	private boolean shouldRun = true;
	
	public void stopWorker()
	{
		this.shouldRun = false;
	}
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted())
		{
			Date d = new Date();
			System.out.println(d.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				///e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}

}
