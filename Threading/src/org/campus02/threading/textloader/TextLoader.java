package org.campus02.threading.textloader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TextLoader {

	private String path;
	
	public TextLoader (String path)
	{
		this.path = path;
	}
	
	public ArrayList<String> loadFile()
	{
		// Reader öffenen
		try (BufferedReader br = new BufferedReader
				(new FileReader(path)))
		{
			String line;
			// Rückgabe definieren
			ArrayList<String> returnList = new ArrayList<>();
			
			// Zeile für Zeile einlesen
			while ((line = br.readLine()) != null)
			{
				returnList.add(line);
			}
			return returnList;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
