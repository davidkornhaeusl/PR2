package org.campus02.threading03;

public class PrimApp {

	public static void main(String[] args) throws InterruptedException  {

		PrimValidation p1 = new PrimValidation(1930000067 );
		PrimValidation p2 = new PrimValidation(1999990019);
		PrimValidation p3 = new PrimValidation(1999990119);
		PrimValidation p4 = new PrimValidation(1999990019);
		PrimValidation p5 = new PrimValidation(1999990019);

		
		Thread th1 = new Thread(p1);
		Thread th2 = new Thread(p2);
		Thread th3 = new Thread(p3);
		Thread th4 = new Thread(p4);
		Thread th5 = new Thread(p5);
		
		th1.start();th2.start();th3.start();th4.start();th5.start();
		
		System.out.println("waiting for threads");
		try {
			th1.join();
			th2.join();
			th3.join();
			th4.join();
			th5.join();
					
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		p1.printResult();
		p2.printResult();
		p3.printResult();
		p4.printResult();
		p5.printResult();

	}

}
