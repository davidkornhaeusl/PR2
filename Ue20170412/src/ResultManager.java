import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResultManager {

	private String path;
	private HashMap<Character, Integer> letters;
	public ResultManager(String path) {
		this.path = path;
		letters = new HashMap<>();
	}

	public void read()
	{
		// Datei öffnen
		try(BufferedReader br = new BufferedReader(
				new FileReader(path)))
		{
			String line;
			while ((line = br.readLine())!=null)
			{
				String[] columns = line.split(":");
				if (columns.length != 2)
					throw new TextException("Fehler bei Zeile: " + line);
				if (columns[0].length() != 1)
					throw new TextException("Wrong letter in: " + line);
				
				letters.put(columns[0].charAt(0),
						Integer.parseInt(columns[1]));	
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TextException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Zeilenweise einlesen
		
		// Zeile splitten "A:17" ==> String[2] {"A", "17"}
		
		// In HashMap speichern
	}
	
	public void write()
	{
		try(BufferedWriter bw = new BufferedWriter
				(new FileWriter(path)))
		{
			for(Map.Entry<Character, Integer> entry : letters.entrySet())
			{
				bw.write(entry.getKey() + ":" + entry.getValue());
				bw.newLine();
			}
			bw.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addLetter(Character c)
	{
		if (letters.containsKey(c))
			letters.put(c, letters.get(c) + 1);
		else
			letters.put(c, 1);
	}
}
