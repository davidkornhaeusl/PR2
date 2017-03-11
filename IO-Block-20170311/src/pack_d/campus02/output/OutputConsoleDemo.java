package pack_d.campus02.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputConsoleDemo {

	public static void main(String[] args) {
		File file = new File("D:\\PR2\\demo-text-from-console.txt");
		
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);
			
			// Console einlesen
			
			int byteRead;
			
			do
			{
				byteRead = System.in.read();
				
				fos.write(byteRead);
			} while (byteRead != 88 
					&& byteRead != 120);

			fos.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (fos != null)
			{
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}

	}

}
