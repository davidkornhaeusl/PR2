package org.campus02.threading.pingpong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class BackgroundServer implements Runnable {

	private boolean shouldRun = true;
	private ServerSocket ss;
	private ArrayList<ClientCommunication> clients =
			new ArrayList<>();
	
	public void stopWorker()
	{
		this.shouldRun = false;
		try {
			for (ClientCommunication clientCommunication : clients) {
				clientCommunication.close();
			}
			
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		
		try  {
			ss = new ServerSocket(2222);			
			
			while(shouldRun) {
				System.out.println("waiting for connections");
				Socket client = ss.accept();
				System.out.println("client connected");
				
				ClientCommunication cc = 
						new ClientCommunication(client);
				
				Thread th = new Thread(cc);
				th.start();
				clients.add(cc); // Clients "merken"
			}	
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (!ss.isClosed())
					ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
