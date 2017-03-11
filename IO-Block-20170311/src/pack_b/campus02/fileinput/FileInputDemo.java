package pack_b.campus02.fileinput;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputDemo {

	public static void main(String[] args) {

		File file = new File("D:\\PR2\\demo-text.txt");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			BufferedInputStream bis = new 
					BufferedInputStream(fis);
			int byteRead = 0;
			
			while ((byteRead = bis.read()) != -1)
			{
				//System.out.println(byteRead);
				
				char[]b  = Character.toChars(byteRead);
				System.out.print(b[0]);
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
			if (fis != null)
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		

	}

}
