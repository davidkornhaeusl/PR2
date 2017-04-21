package org.campus02.threading.textloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TextLoaderApp {

	public static void main(String[] args) throws InterruptedException {
		
		// Datei einlesen
		TextLoader loader = new TextLoader("C:\\Users\\Stephan\\OneDrive\\Campus02\\SS2016\\PR2\\text.txt");
		ArrayList<String> lines = loader.loadFile();
		
		// Datei / Array aufteilen
		ArrayList<String> odd = new ArrayList<>();
		ArrayList<String> even = new ArrayList<>();
		
		for (int i = 0; i < lines.size(); i++)
		{
			if (i % 2 == 0)
				even.add(lines.get(i));
			else
				odd.add(lines.get(i));
		}
		
		
		
		
		
		
		
		// Threads erzeugen
		Thread thOdd = new Thread(new TextAnalyzer(odd));
		Thread thEven = new Thread(new TextAnalyzer(even));
		
		System.out.println("starting threads");
		thOdd.start(); thEven.start();
		System.out.println("waiting for threads to finish");
		thOdd.join(); thEven.join();
		System.out.println("threads finished");
		
		System.out.println("Total characters: " + TextAnalyzer.getCountTotal());
		HashMap<Character, Integer> characters = TextAnalyzer.getCountCharacters();
		
		for (Entry<Character, Integer> entry : 
			characters.entrySet())
		{
			System.out.println("Character: " +
					entry.getKey() + " : " + entry.getValue());
		}
		
		
		System.out.println("----- finished -----");

	}

}
