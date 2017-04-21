package fileserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {

		System.out.println("starting server");
		try (ServerSocket sers = 
				new ServerSocket(2021)) {

			while (true)
			{
				System.out.println("waiting for next client");
				Socket client = sers.accept();
	
				ClientCommunication cc = new ClientCommunication(client);
				cc.runAll();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
