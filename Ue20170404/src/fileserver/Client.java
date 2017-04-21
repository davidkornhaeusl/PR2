package fileserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try (Socket client =
				new Socket("localhost", 2021);) {

			try (BufferedReader br = 
					new BufferedReader(new InputStreamReader(client.getInputStream()));
					BufferedWriter bw = 
							new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
					BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {

				while (true) {
					String output = input.readLine();

					if (output.startsWith("quit")) {
						System.out.println("Verbindung unterbrochen");
						bw.write("quit");
						bw.newLine();
						bw.flush();

					}

					bw.write(output);
					bw.newLine();
					bw.flush();

					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}

				}
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
