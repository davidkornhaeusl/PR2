package org.campus02.threading03;

public class PrimValidation implements Runnable{

	private long number;
	private ValidationState status; 
	public PrimValidation (long number)
	{
		this.number = number;
		status = ValidationState.Unchecked;
	}
	
	public long getNumber()
	{
		return number;
	}
	
	public void printResult()
	{
		System.out.println("Result of " + number + ": "
					+ status);
	}
	
	@Override
	public void run() {
	
		status = ValidationState.Running;
		for (long l = 2; l < number; l++)
		{
			if (number % l == 0)
			{
				status = ValidationState.NumberIsNotPrim;
				break;
			}
		}
		if (status == ValidationState.Running)
			status = ValidationState.NumberIsPrim;
		
		printResult();
	}

}
