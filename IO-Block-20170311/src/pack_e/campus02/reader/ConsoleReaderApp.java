package pack_e.campus02.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReaderApp {

	public static void main(String[] args) {
		BufferedReader br = null;
		
		try
		{
			br = new BufferedReader(
					new InputStreamReader(System.in)
					);
			
			String line;
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
