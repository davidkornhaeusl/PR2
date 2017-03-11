package pack_c.campus02.consolein;

import java.io.FileInputStream;
import java.io.IOException;

public class ConsoleInApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int byteRead = 0;
		
		try {
			while ((byteRead = System.in.read()) != -1)
			{
				//System.out.println(byteRead);
				
				char[]b  = Character.toChars(byteRead);
				System.out.print(b[0]);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
