package org.campus02.threading.persons;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

	public static void main(String[] args) {
		
		System.out.println("staring server");
		try (ServerSocket server = new ServerSocket(1234))
		{
			System.out.println("socket bound");
			while (true)
			{
				System.out.println("waiting for client");
				Socket s = server.accept();
				System.out.println("got client");
				Thread th = new Thread(
						new ClientCommunication(s));
				th.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
