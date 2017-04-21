package org.campus02.threading.persons.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.campus02.threading.persons.Person;

public class DemoClient {

	public static void main(String[] args) {

		try (Socket s = new Socket("127.0.0.1", 1234))
		{
			try (BufferedWriter bw = new BufferedWriter(
					new OutputStreamWriter(s.getOutputStream()));
				ObjectInputStream ooi = new ObjectInputStream(
						s.getInputStream())	
					)
			{
				sendCommand("GET 2", bw);
				printResult(ooi);
				
				sendCommand("GETALL", bw);
				printResult(ooi);
				
				sendCommand("GET 1", bw);
				printResult(ooi);
				
				sendCommand("EXIT", bw);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void sendCommand(String cmd, BufferedWriter bw)
	{
		try {
			bw.write(cmd);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void printResult (ObjectInputStream oois)
	{
		Person p;
		try {
			while ((p = (Person) oois.readObject()) != null)
			{
				System.out.println(p);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
