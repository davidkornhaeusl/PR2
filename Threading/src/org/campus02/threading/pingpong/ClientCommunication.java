package org.campus02.threading.pingpong;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientCommunication implements Runnable {

	private Socket client;
	public ClientCommunication (Socket client)
	{
		this.client = client;
	}
	
	private  void processClient() {
		
		try (
				BufferedReader br = new BufferedReader(
						new InputStreamReader(client.getInputStream()));

				BufferedWriter bw = new BufferedWriter(
						new OutputStreamWriter(client.getOutputStream()));
				) { 
						
			String line; 
			while((line = br.readLine()) != null) {
				System.out.println(" --> received: "+line);
				switch(line.toLowerCase()) {
				case "ping":
					System.out.println(" <-- sending pong response");
					bw.write("pong");
					break;
				case "pong":
					System.out.println(" <-- sending ping response");
					bw.write("ping");
					break;
				default: 
					System.err.println("error: "+line+" is invalid command!");
					System.out.println(" <-- sending error response");
					bw.write("error");
				}
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {

		processClient();
	}

	public void close() {
		try (
					BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream()));
					) { 
			bw.write("closing connection by server");
			bw.newLine();
			bw.flush();
			client.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
