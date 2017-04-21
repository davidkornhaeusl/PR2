package org.campus02.threading.persons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientCommunication implements Runnable {

	private Socket client;
	
		
	public ClientCommunication(Socket client) {
		super();
		this.client = client;
	}


	@Override
	public void run() {

		try (BufferedReader rw = new BufferedReader(new InputStreamReader(client.getInputStream()));
				ObjectOutputStream oow = new ObjectOutputStream(client.getOutputStream())
				)
		{
			ArrayList<Person> persons = (new PersonLoader("D:\\PR2\\persons.csv")).load();
			
			String command;
			while ((command = rw.readLine()) != null 
					&& !command.equalsIgnoreCase("exit")
					)
			{
				System.out.println("Command from Client >> " + command);
				if (command.startsWith("GET "))
				{
					String[] parts = command.split(" ");
					int id = Integer.parseInt(parts[1]);
					
					for (Person p : persons) {
						if (p.getId() == id)
							oow.writeObject(p);
					}
				}
				else if (command.equalsIgnoreCase("GETALL"))
				{
					for (Person p : persons) {
						oow.writeObject(p);
					}
				}
				oow.writeObject(null);
				oow.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersonLoadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
