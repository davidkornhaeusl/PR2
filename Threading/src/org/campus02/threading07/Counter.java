package org.campus02.threading07;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter implements Runnable {

	public static  int Counter; // statisches Attribute, welches geteilt wird!
	private static Lock lock = new ReentrantLock();
	
	@Override
	public void run() {

		for (int i = 0; i < 1_000_000; i++) {
		
			
			lock.lock();
		
			try
			{
				Increase();
			}
			finally
			{
				lock.unlock();
			}			
		}
		System.out.println(Counter);
	}

	private void Increase() {
		Counter++;
	}
	
	
}
