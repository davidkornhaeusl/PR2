import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;

public class DemoApp {


	public static void main(String[] args) {
		ResultManager rm = new ResultManager("D:\\PR2\\letters.txt");
	
		rm.read();
		
		/*
		TextAnalyzer tm = new TextAnalyzer(rm, "D:\\PR2\\demotext.txt");
		
		
		long msStart = System.currentTimeMillis();		
		tm.readReader();
		System.out.println("Reader: " + (System.currentTimeMillis()- msStart) / 1000);
		
		msStart = System.currentTimeMillis();		
		tm.readStream();
		System.out.println("Stream: " + (System.currentTimeMillis()- msStart) / 1000);
		*/
		
		//rm.writeFile();
		
		
		try (ServerSocket server = new ServerSocket(2222))
		{
			System.out.println("server started");
			
			while (true)
			{
				Socket client = server.accept(); // blockt, wartet
				System.out.println(">> Client connected");
				
				ClientCommunication cc = 
						new ClientCommunication(client, rm);
				//cc.processClient();
				Thread th = new Thread(cc);
				th.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Öffnen von Server
		// Warten auf Client
		// Parsen Client-Command
		// Rufen von rm.write(client.getOutputStream())
		
	}



}
