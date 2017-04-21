package org.campus02.threading.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) {

		Logger.setPath("D:\\temp\\log.txt");
		Logger.LogMessage("Start Application");
		try (ServerSocket serverSocket = new ServerSocket(1111)){
			
			ArrayList<ChatClient> clients = new ArrayList<>();
			
			while(true)
			{
				Socket client = serverSocket.accept();
			
				ChatClient chatClient = new ChatClient(client, clients);
				clients.add(chatClient);
				
				Thread th = new Thread(chatClient);
				th.start();
			}
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
