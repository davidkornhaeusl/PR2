package org.campus02.threading03;

public class PrimValidation2 implements Runnable{

	private long number;
	private boolean isPrim; 
	public PrimValidation2 (long number)
	{
		this.number = number;
		isPrim = false;
	}
	
	public long getNumber()
	{
		return number;
	}
	
	public void printResult()
	{
		System.out.println("Result of " + number + ": " + isPrim);
	}
	
	@Override
	public void run() {
	
		isPrim = true;
		for (long l = 2; l < number; l++)
		{
			if (number % l == 0)
			{
				isPrim = false;
				break;
			}
		}
		
		System.out.println("Validation for " + number + " finished");
	}

}
