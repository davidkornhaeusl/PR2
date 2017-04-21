package org.campus02.threading.persons;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonLoader {

	private String path;
	public PersonLoader(String path) {
		this.path = path;
	}

	public ArrayList<Person> load() throws PersonLoadException
	{
		try (BufferedReader br = 
				new BufferedReader(new FileReader(
						new File(path))))
		{
			ArrayList<Person> persons = new ArrayList<>();
			String input;
			
			while ((input = br.readLine()) != null)
			{
				String[] col = input.split(";");
				if (col.length != 3)
					throw new PersonLoadException("Ungültige Anzahl an Spalten: " + input);
				
				persons.add(new Person(Integer.parseInt(col[0]),
						col[1], col[2]));
			}
			
			return persons;
		} catch (FileNotFoundException e) {
			throw new PersonLoadException(e);
		} catch (IOException e) {
			throw new PersonLoadException(e);
		}
	}
}
