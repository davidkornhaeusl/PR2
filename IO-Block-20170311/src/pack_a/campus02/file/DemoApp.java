package pack_a.campus02.file;

import java.io.File;

public class DemoApp {

	public static void main(String[] args) {
		
		File dir= new File("D:\\PR2");
		long length = 0;
		
		//code ...
		for(File fi : dir.listFiles())
		{
			if (!fi.isDirectory())
				length += fi.length();
		}
		
		System.out.println("Gesamtgröße: " + length);
		
	}

}
