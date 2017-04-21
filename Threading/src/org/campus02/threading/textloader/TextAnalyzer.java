package org.campus02.threading.textloader;

import java.util.ArrayList;
import java.util.HashMap;

public class TextAnalyzer implements Runnable {

	private ArrayList<String> lines;
	private static int countTotal = 0;
	private static HashMap<Character, Integer> 
		countCharacters = new HashMap<>();
	private static Object lockObject = new Object();
	
	public TextAnalyzer(ArrayList<String> lines)
	{
		this.lines = lines;
	}
	
	@Override
	public void run() {
		for (String line : lines) 
		{
			synchronized (lockObject)
			{
				countTotal += line.length();
				for(int i = 0; i < line.length();i++)
				{
					if (countCharacters.containsKey(line.charAt(i)))
					{
						countCharacters.put(line.charAt(i), 
								countCharacters.get(line.charAt(i)) + 1);
					}
					else
					{
						countCharacters.put(line.charAt(i), 1);
					}
				}			
			}
		}
		
	}

	public static int getCountTotal() {
		return countTotal;
	}

	public static HashMap<Character, Integer> getCountCharacters() {
		return countCharacters;
	}

}
