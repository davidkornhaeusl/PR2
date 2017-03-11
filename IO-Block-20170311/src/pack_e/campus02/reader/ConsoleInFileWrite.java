package pack_e.campus02.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ConsoleInFileWrite {
	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(
					new InputStreamReader(System.in)
					);
				
				FileWriter pw = new FileWriter(
						"D:\\PR2\\noten.txt");)
		{
			
			
			String line;
			while ((line = br.readLine()) != null)
			{
				if (!line.equals("STOP"))
				{
					pw.write(line + "\r\n");			
				}
				else 
					break;
			}
			pw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
