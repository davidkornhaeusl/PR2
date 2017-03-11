package pack_d.campus02.output;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonDemoApp {

	public static void main(String[] args) {
		Person p = new Person("Max", "Muster");
		
		writePerson(p);
		
		Person p1 = readPerson();
		
		System.out.println(p1);

	}

	
	public static void writePerson(Person p)
	{
		File file = new File("D:\\PR2\\demo-person.txt");
				
		ObjectOutputStream oos = null;
		try
		{			
			oos	= new ObjectOutputStream(
					new BufferedOutputStream(
					new FileOutputStream(file)));
			oos.writeObject(p);
			oos.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (oos != null)
			{
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public static Person readPerson()
	{
		File file = new File("D:\\PR2\\demo-person.txt");
		
		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream(
					new FileInputStream(file));
			
			
			return (Person) ois.readObject();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if (ois != null)
			{
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return null;
	}
}
