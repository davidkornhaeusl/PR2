package pack_d.campus02.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputDemo {

	public static void main(String[] args) {

		File file = new File("D:\\PR2\\demo.txt");
		
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);
			ObjectOutputStream oos
				= new ObjectOutputStream(fos);
			
			String demo = "Hello File";
			oos.writeObject(demo);

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
