package org.campus02.threading06;

public class Counter implements Runnable {

	public static String LockObject = "";
	public static int Counter; // statisches Attribute, welches geteilt wird!
	@Override
	public void run() {

		for (int i = 0; i < 1_000_000; i++) {
			Increase();
		}
	}

	public void Increase() {
		synchronized (LockObject) {
			Counter++;	
		}
			
	}
	
	
}
