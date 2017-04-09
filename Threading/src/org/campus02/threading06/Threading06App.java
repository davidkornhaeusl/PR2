package org.campus02.threading06;

public class Threading06App {

	public static void main(String[] args) {
		
		Counter c1 = new Counter();
		Counter c2 = new Counter();
		
		Thread th1 = new Thread(c1);
		Thread th2 = new Thread(c2);
		
		th1.start(); th2.start();
		
		 try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Result: " + Counter.Counter);
		
	}

}
