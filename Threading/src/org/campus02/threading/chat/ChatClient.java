package org.campus02.threading.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ChatClient implements Runnable {

	private Socket client;
	private ArrayList<ChatClient> clients;
	private PrintWriter printWriter;
	private BufferedReader reader;
	private boolean isRunning;
	private static Object s_lock = new Object();
	private String name;
	
	
	public ChatClient(Socket client, ArrayList<ChatClient> clients) 
	{
		this.client = client;
		this.clients = clients;
		this.name = "ANONYM";

		try {
			reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
			printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void Stop()
	{
		isRunning = false;
	}
	
	@Override
	public void run() {
		isRunning = true;
		String line;
		try {
			while (isRunning && ((line = reader.readLine())
					!= null))
			{
				String[] commands = line.split(":");
				if (commands[0].equals("<name>"))
				{
					Logger.LogMessage(this.name + " sets name to: " + commands[1]);
					this.name = commands[1];
				}
				else if (commands[0].equals("<bye>"))
				{
					Logger.LogMessage(this.name + " closes connection");
					close();
					break;
				}
				else if (commands[0].equals("<msgto>"))
				{
					Logger.LogMessage(this.name + " sends private message to " + commands[2]);
					synchronized (s_lock) {
						for (ChatClient chatClient : clients) 
						{
							if (chatClient.name.equals(commands[1]))
							{
								chatClient.sendMessage("private msg from " + name + " >> " + commands[2]);
							}
						}
					}
				}
				else if (commands[0].equals("<msg>"))
				{
					Logger.LogMessage(this.name + " sends message: " + commands[1]);

					synchronized (s_lock) {
						for (ChatClient chatClient : clients) {
							if (chatClient != this)
							{
								chatClient.sendMessage(name + " >> " + commands[1]);
							}
						}
					}
				}
				else
				{
					Logger.LogMessage(this.name + " wrong command " + line);

					sendMessage("wrong command");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	public void sendMessage(String message)
	{
		printWriter.println(message);
		printWriter.flush();
	}
	
	public void close() throws IOException
	{
		Stop();
		synchronized (s_lock) {
			clients.remove(this);
		}

		reader.close();
		printWriter.close();
	}
	
	
}
